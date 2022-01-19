package com.images_base.backend.modal.vo.role;

import com.images_base.backend.modal.entity.FeatEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@ApiModel("角色VO")
public class RoleVO {

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;

    @ApiModelProperty("功能权限列表")
    private List<FeatEntity> feats;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<FeatEntity> getFeats() {
        return feats;
    }

    public void setFeats(List<FeatEntity> feats) {
        this.feats = feats;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "roleName='" + roleName + '\'' +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", feats=" + feats +
                '}';
    }
}
