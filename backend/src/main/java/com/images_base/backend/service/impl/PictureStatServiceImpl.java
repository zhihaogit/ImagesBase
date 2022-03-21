package com.images_base.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.images_base.backend.dao.PictureStatMapper;
import com.images_base.backend.modal.entity.PictureStatEntity;
import com.images_base.backend.modal.vo.picture.PictureStatWeakVO;
import com.images_base.backend.service.PictureStatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Service
public class PictureStatServiceImpl extends ServiceImpl<PictureStatMapper, PictureStatEntity> implements PictureStatService {

    private static final Logger logger = LoggerFactory.getLogger(PictureStatServiceImpl.class);

    @Override
    public boolean createPictureStat(String pictureId, Long useTimes) {
        logger.info("创建图片统计信息: {}", pictureId);
        LocalDate now = LocalDate.now();
        PictureStatEntity one = this.getBaseMapper().getOneIgnoreStatus(pictureId, now);
        if (null == one) {
            PictureStatEntity entity = new PictureStatEntity();
            entity.setPictureId(pictureId);
            entity.setUseTimes(null == useTimes ? 0L : useTimes);
            entity.setUseDate(LocalDate.now());
            return this.save(entity);
        }
        one.setUseTimes(one.getUseTimes() + 1);
        return this.getBaseMapper().updateTimesDelete(one);
    }

    @Override
    public boolean updateUseTimesOneDay(String pictureId) {
        LocalDate now = LocalDate.now();
        PictureStatEntity one = this.getBaseMapper().getOneIgnoreStatus(pictureId, now);
        if (null == one) {
            return createPictureStat(pictureId, 1L);
        }
        one.setUseTimes(one.getUseTimes() + 1);
        return this.getBaseMapper().updateTimesDelete(one);
    }

    @Override
    public Map<LocalDate, List<PictureStatWeakVO>> getTop5Week() {
        List<PictureStatEntity> idsSum = this.getBaseMapper().getTop5IdSumWeekly();
        if (null == idsSum || idsSum.isEmpty()) {
            return new HashMap<>(0);
        }
        List<String> top5Ids = idsSum.stream()
                .map(PictureStatEntity::getPictureId)
                .collect(Collectors.toList());
        return this.getBaseMapper()
                .getTop5Week(top5Ids)
                .stream()
                .collect(
                        Collectors.groupingBy(PictureStatWeakVO::getUseDate)
                );
    }
}
