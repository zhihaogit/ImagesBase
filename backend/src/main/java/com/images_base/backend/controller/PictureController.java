package com.images_base.backend.controller;

import com.images_base.backend.modal.entity.PictureEntity;
import com.images_base.backend.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@Api(value = "user", tags = "图片相关")
@RestController
@RequestMapping(path = "/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    /**
     * 上传图片
     *
     * @param file
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws SQLException
     */
    @PostMapping("/upload")
    @ApiOperation("图片上传接口")
    void updatePicture(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException, NoSuchAlgorithmException, SQLException {
        pictureService.updatePicture(file);
    }

    /**
     * 图片全列表查询
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("图片全列表查询")
    List<PictureEntity> getPictureList() {
        return pictureService.getPictureList();
    }
}
