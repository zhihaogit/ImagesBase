package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@TableName("role")
@ApiModel("角色类")
public class RoleEntity extends BaseEntity {

    @TableField("name")
    @ApiModelProperty("角色字段")
    private String name;

    @TableField("role_name")
    @ApiModelProperty("角色名称")
    private String roleName;

    @TableLogic(value = "0", delval = "1")
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
