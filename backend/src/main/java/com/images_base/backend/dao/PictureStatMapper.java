package com.images_base.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.images_base.backend.modal.entity.PictureStatEntity;
import com.images_base.backend.modal.vo.picture.PictureStatWeakVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

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

    /**
     * 获取最近一周 top5使用量图片
     *
     * @return
     */
    List<PictureStatWeakVO> getTop5Week(List<String> ids);

    /**
     * 获取最近一周 top5使用量及图片ID
     *
     * @return
     */
    List<PictureStatEntity> getTop5IdSumWeekly();

    /**
     * 获取历史记录中的使用量总和
     *
     * @return
     */
    long getSumInAllDaysPictures();
}
