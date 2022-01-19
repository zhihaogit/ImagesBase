package com.images_base.backend.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
@ApiModel("用户注册DTO")
public class UserRegisterDTO {

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty("用户名称")
    @NotNull(message = "用户名称不能为空")
    private String username;

    @ApiModelProperty("用户年龄")
    @NotNull(message = "用户年龄不能为空")
    private Integer age;

    @ApiModelProperty("用户邮箱")
    @NotNull(message = "用户邮箱不能为空")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
