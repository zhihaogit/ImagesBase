package com.images_base.backend.controller;

import com.images_base.backend.modal.entity.PictureEntity;
import com.images_base.backend.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Api(value = "picture", tags = "图片相关")
@RestController
@RequestMapping(path = "/view")
public class PictureViewController {

    @Autowired
    PictureService pictureService;

    @GetMapping("/{pictureId}")
    @ApiOperation(value = "单个图片查询接口")
    void getOneByPictureId(@PathVariable(name = "pictureId") String pictureId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PictureEntity one = pictureService.getOneByPictureId(pictureId);
        byte[] origin = one.getPictureOrigin();
        response.setContentType(one.getPictureType());
        response.setContentLength(origin.length);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(origin);
        outputStream.flush();
    }
}