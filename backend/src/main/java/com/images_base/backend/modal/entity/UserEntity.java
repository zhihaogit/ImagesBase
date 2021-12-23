package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName: UserEntity
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:42
 */
@TableName("user")
@ApiModel(value = "用户实体类")
public class UserEntity implements Serializable {
    public static final long serialVersionUID = 42L;

    @TableField("id")
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @TableField("name")
    @ApiModelProperty(value = "用户名称")
    private String name;

    @TableField("age")
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @TableField("email")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
