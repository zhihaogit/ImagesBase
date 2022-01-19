package com.images_base.backend.modal.vo.user;

import com.images_base.backend.modal.entity.FeatEntity;
import com.images_base.backend.modal.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/6
 */
@ApiModel("用户与功能权限VO")
public class UserFeatVO extends UserEntity {

    @ApiModelProperty("功能权限列表")
    private List<FeatEntity> feats;

    public List<FeatEntity> getFeats() {
        return feats;
    }

    public void setFeats(List<FeatEntity> feats) {
        this.feats = feats;
    }


    @Override
    public String toString() {
        return "UserFeatVO{" +
                "feats=" + feats +
                '}';
    }
}
