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
@TableName("user_role_association")
@ApiModel(value = "用户角色关联类")
public class UserRoleAssociation extends BaseEntity {

    @TableField("user_id")
    @ApiModelProperty("用户ID")
    private Long userId;

    @TableField("role_id")
    @ApiModelProperty("角色ID")
    private Long roleId;

    @TableLogic(value = "0", delval = "1")
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
