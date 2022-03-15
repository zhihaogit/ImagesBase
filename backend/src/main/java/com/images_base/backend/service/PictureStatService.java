package com.images_base.backend.service;

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
}
