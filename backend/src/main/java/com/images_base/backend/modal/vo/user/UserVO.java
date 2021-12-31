package com.images_base.backend.modal.vo.user;

import com.images_base.backend.modal.entity.UserEntity;
import com.images_base.backend.modal.vo.role.RoleVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/29
 */
@ApiModel("用户VO")
public class UserVO extends UserEntity {

    @ApiModelProperty("角色列表")
    List<RoleVO> roles;

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }
}
