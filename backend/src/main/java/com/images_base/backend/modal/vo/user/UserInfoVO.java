package com.images_base.backend.modal.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/2/10
 */
@ApiModel("用户登录返回详情")
public class UserInfoVO extends UserBriefVO {

    @ApiModelProperty("功能权限信息")
    List<String> feats;

    public List<String> getFeats() {
        return feats;
    }

    public void setFeats(List<String> feats) {
        this.feats = feats;
    }
}
