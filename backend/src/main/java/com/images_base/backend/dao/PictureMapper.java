package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.PictureEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Mapper
public interface PictureMapper extends BaseMapper<PictureEntity> {

    /**
     * 检查散列ID是否重复
     *
     * @param pictureId
     * @return
     */
    Integer checkDuplication(@Param("pictureId") String pictureId);

    /**
     * 上传图片
     *
     * @param entity
     */
    void uploadPicture(@Param("entity") PictureEntity entity);

    /**
     * 图片全列表查询
     *
     * @return
     */
    List<PictureEntity> getPictureList();

    /**
     * 查看图片
     *
     * @param pictureId
     * @return
     */
    PictureEntity getOneByPictureId(@Param("pictureId") String pictureId);

    /**
     * 直接删除单个图片
     *
     * @param pictureId
     * @return
     */
    boolean removeByPictureId(@Param("pictureId") String pictureId);
}
