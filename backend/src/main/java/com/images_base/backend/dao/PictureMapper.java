package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.PictureEntity;
import com.images_base.backend.modal.vo.picture.PictureFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Mapper
public interface PictureMapper extends BaseMapper<PictureEntity> {

    /**
     * 上传图片
     *
     * @param entity
     */
    boolean uploadPicture(@Param("entity") PictureEntity entity);

    /**
     * 查看图片
     *
     * @param pictureId
     * @return
     */
    PictureFileVO getOneByPictureId(@Param("pictureId") String pictureId);

    /**
     * 直接删除单个图片
     *
     * @param pictureId
     * @return
     */
    boolean removeByPictureId(@Param("pictureId") String pictureId);
}
