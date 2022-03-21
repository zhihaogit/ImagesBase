package com.images_base.backend.controller;

import com.images_base.backend.modal.entity.PictureInfoEntity;
import com.images_base.backend.service.PictureInfoService;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Api(value = "picture_info", tags = "图片信息相关")
@RestController
@ResponseBodyAnnotation
@RequestMapping(path = "/picture_info")
public class PictureInfoController {

    @Autowired
    PictureInfoService pictureInfoService;

    /**
     * 图片全列表查询
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("图片全列表查询")
    List<PictureInfoEntity> getPictureList() {
        return pictureInfoService.getPictureList();
    }
}
