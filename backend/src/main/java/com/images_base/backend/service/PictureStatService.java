package com.images_base.backend.service;

import com.images_base.backend.modal.vo.picture.PictureStatWeakVO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
public interface PictureStatService {
    /**
     * 创建图片统计信息
     *
     * @param pictureId
     * @param useTimes
     * @return
     */
    boolean createPictureStat(String pictureId, Long useTimes);

    /**
     * 更新图片当天的使用次数
     *
     * @param pictureId
     * @return
     */
    boolean updateUseTimesOneDay(String pictureId);

    /**
     * 获取最近一周 top5使用量图片
     *
     * @return
     */
    Map<LocalDate, List<PictureStatWeakVO>> getTop5Week();

    /**
     * 获取历史记录中的使用量总和
     *
     * @return
     */
    long getSumInAllDaysPictures();
}
