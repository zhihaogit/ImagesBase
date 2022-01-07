package com.images_base.backend.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
@ApiModel("用户登录DTO")
public class UserLoginDTO {

    @ApiModelProperty("用户名称")
    @NotNull(message = "登录名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "登录密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String
    toString() {
        return "LoginUserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
