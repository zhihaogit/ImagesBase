package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.PictureMapper;
import com.images_base.backend.exception.BadRequestException;
import com.images_base.backend.modal.entity.PictureEntity;
import com.images_base.backend.modal.vo.picture.PictureFileVO;
import com.images_base.backend.service.PictureInfoService;
import com.images_base.backend.service.PictureService;
import com.images_base.backend.service.PictureStatService;
import com.images_base.backend.util.Sha256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, PictureEntity> implements PictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Autowired
    PictureInfoService pictureInfoService;

    @Autowired
    PictureStatService pictureStatService;

    @Override
    public void uploadPicture(String filename, String description, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        String contentType = file.getContentType();
        String builder = file.getOriginalFilename() +
                contentType +
                file.getSize();
        String encode = Sha256Util.encode(builder);
        logger.info("upload request hash id of picture: {}", encode);
        Integer count = pictureInfoService.checkDuplication(encode);
        if (count > 0) {
            throw new BadRequestException("图片重复");
        }
        if (!pictureInfoService.createPictureInfo(file, encode, filename, description)) {
            throw new BadRequestException("创建图片信息失败");
        }
        if (!pictureStatService.createPictureStat(encode, 0L)) {
            throw new BadRequestException("创建图片统计信息失败");
        }
        PictureEntity entity = new PictureEntity();
        entity.setPictureId(encode);
        entity.setPictureOrigin(file.getBytes());
        this.getBaseMapper().uploadPicture(entity);
    }

    @Override
    public PictureFileVO getOneByPictureId(String pictureId) {
        PictureFileVO one = this.getBaseMapper().getOneByPictureId(pictureId);
        if (null == one) {
            throw new BadRequestException("未找到图片");
        }
        if (!pictureStatService.updateUseTimesOneDay(pictureId)) {
            throw new BadRequestException("统计失败");
        }
        return one;
    }

    @Override
    public boolean removeByPictureId(String pictureId) {
        if (!pictureInfoService.removeByPictureId(pictureId)) {
            throw new BadRequestException("删除图片信息失败");
        }
        return this.getBaseMapper().removeByPictureId(pictureId);
    }
}
