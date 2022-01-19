package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: UserEntity
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:42
 */
@TableName("user")
@ApiModel("用户实体类")
public class UserEntity extends BaseEntity {

    public static final String NAME_FIELD = "name";

    public static final String EMAIL_FIELD = "email";

    @TableField("password")
    @ApiModelProperty("密码")
    private String password;

    @TableField("name")
    @ApiModelProperty("用户名称")
    private String name;

    @TableField("age")
    @ApiModelProperty("用户年龄")
    private Integer age;

    @TableField("email")
    @ApiModelProperty("用户邮箱")
    private String email;

    @TableLogic(value = "0", delval = "1")
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
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
