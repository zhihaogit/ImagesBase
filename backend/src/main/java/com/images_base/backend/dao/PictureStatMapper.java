package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.PictureStatEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Mapper
public interface PictureStatMapper extends BaseMapper<PictureStatEntity> {

    /**
     * 获取一条数据（忽略数据的软删除状态）
     *
     * @param pictureId
     * @param useDate
     * @return
     */
    PictureStatEntity getOneIgnoreStatus(@Param("pictureId") String pictureId, @Param("useDate") LocalDate useDate);

    /**
     * 更新一条数据的使用次数和删除状态
     *
     * @param entity
     * @return
     */
    boolean updateTimesDelete(@Param("entity") PictureStatEntity entity);
}
