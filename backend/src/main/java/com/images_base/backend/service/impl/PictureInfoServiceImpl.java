package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.PictureInfoMapper;
import com.images_base.backend.modal.entity.PictureInfoEntity;
import com.images_base.backend.service.PictureInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Service
public class PictureInfoServiceImpl extends ServiceImpl<PictureInfoMapper, PictureInfoEntity> implements PictureInfoService {

    private static final Logger logger = LoggerFactory.getLogger(PictureInfoServiceImpl.class);

    @Override
    public Integer checkDuplication(String pictureId) {
        return this.getBaseMapper().checkDuplication(pictureId);
    }

    @Override
    public List<PictureInfoEntity> getPictureList() {
        return this.getBaseMapper().getPictureList();
    }

    @Override
    public boolean createPictureInfo(MultipartFile file, String pictureId, String filename, String description) {
        logger.info("创建图片信息: {}", pictureId);
        this.getBaseMapper().removeInfoByPictureId(pictureId);
        LocalDateTime now = LocalDateTime.now();
        PictureInfoEntity entity = new PictureInfoEntity();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = (Long) authentication.getPrincipal();
        entity.setUploader(id);
        entity.setPictureId(pictureId);
        entity.setPictureName(filename);
        entity.setPictureType(file.getContentType());
        entity.setDescription(description);
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean removeByPictureId(String pictureId) {
        return this.remove(new QueryWrapper<PictureInfoEntity>().eq(PictureInfoEntity.PICTURE_ID, pictureId));
    }
}
