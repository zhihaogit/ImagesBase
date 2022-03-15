package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.PictureInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Mapper
public interface PictureInfoMapper extends BaseMapper<PictureInfoEntity> {

    /**
     * 检查散列ID是否重复
     *
     * @param pictureId
     * @return
     */
    Integer checkDuplication(@Param("pictureId") String pictureId);

    /**
     * 图片全列表查询
     *
     * @return
     */
    List<PictureInfoEntity> getPictureList();

    /**
     * 直接删除单个图片
     *
     * @param pictureId
     * @return
     */
    boolean removeInfoByPictureId(@Param("pictureId") String pictureId);
}
