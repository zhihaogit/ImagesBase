package com.images_base.backend.controller;

import com.images_base.backend.modal.vo.picture.PictureStatWeakVO;
import com.images_base.backend.service.PictureStatService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Api(value = "picture_stat", tags = "图片统计相关")
@RestController
@ResponseBodyAnnotation
@RequestMapping(path = "/picture_stat")
public class PictureStatController {

    @Autowired
    PictureStatService pictureStatService;

    /**
     * 获取最近一周 top5使用量图片
     *
     * @return
     */
    @GetMapping("/top5_weak")
    @ApiOperation("获取最近一周使用量的top5图片")
    Map<LocalDate, List<PictureStatWeakVO>> getTop5Week() {
        return pictureStatService.getTop5Week();
    }

    /**
     * 获取历史记录中的使用量总和
     *
     * @return
     */
    @GetMapping("/sum")
    @ApiOperation("获取历史记录中的使用量总和")
    long getSumInAllDaysPictures() {
        return pictureStatService.getSumInAllDaysPictures();
    }

}
