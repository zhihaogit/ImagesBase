package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.PictureMapper;
import com.images_base.backend.exception.BadRequestException;
import com.images_base.backend.modal.entity.BaseEntity;
import com.images_base.backend.modal.entity.PictureEntity;
import com.images_base.backend.service.PictureService;
import com.images_base.backend.util.Sha256Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, PictureEntity> implements PictureService {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Override
    public void updatePicture(MultipartFile file) throws IOException, NoSuchAlgorithmException, SQLException {
        LocalDateTime now = LocalDateTime.now();
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        String builder = originalFilename +
                contentType +
                file.getSize();
        String encode = Sha256Util.encode(builder);
        logger.info("upload request hash id of picture: {}", encode);
        Integer count = this.getBaseMapper().checkDuplication(encode);
        if (count > 0) {
            throw new BadRequestException("图片重复");
        }
        PictureEntity entity = new PictureEntity();
        entity.setUseTimes(0L);
        entity.setUploader(null);
        entity.setPictureName(originalFilename);
        entity.setPictureType(contentType);
        entity.setPictureId(encode);
        entity.setPictureOrigin(file.getBytes());
        entity.setDelete(false);
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
        this.getBaseMapper().uploadPicture(entity);
    }

    @Override
    public List<PictureEntity> getPictureList() {
        return this.getBaseMapper().getPictureList();
    }

    @Override
    public PictureEntity getOneByPictureId(String pictureId) {
        PictureEntity one = this.getBaseMapper().getOneByPictureId(pictureId);
        if (null == one) {
            throw new BadRequestException("未找到图片");
        }
        Long useTimes = one.getUseTimes();
        this.update(new UpdateWrapper<PictureEntity>()
                .eq(BaseEntity.ID_FIELD, one.getId())
                .set(PictureEntity.USE_TIMES, null == useTimes ? 1L : useTimes + 1)
                .set(BaseEntity.UPDATED_AT, LocalDateTime.now()));
        return one;
    }
}
