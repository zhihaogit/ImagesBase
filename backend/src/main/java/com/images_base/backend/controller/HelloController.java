package com.images_base.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 01:20
 */
@RestController
@RequestMapping(path = "/info")
public class HelloController {

    @GetMapping
    public String sendInfo() {
        return "Hello";
    }
}
