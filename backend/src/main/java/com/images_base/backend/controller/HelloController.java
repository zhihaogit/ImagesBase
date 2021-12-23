package com.images_base.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 01:20
 */
@Api(value = "hello", tags = "测试连通性")
@RestController
@RequestMapping(path = "/info")
public class HelloController {

    @GetMapping
    @ApiOperation(value = "Hello测试连通性")
    public String getInfo() {
        return "Hello";
    }
}
