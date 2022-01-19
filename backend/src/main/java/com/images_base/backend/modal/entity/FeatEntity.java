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
 * Created on 2022/1/6
 */
@TableName("feat")
@ApiModel("权限功能类")
public class FeatEntity extends BaseEntity {

    @TableField("name")
    @ApiModelProperty("功能字段")
    private String name;

    @TableField("feat_name")
    @ApiModelProperty("功能名称")
    private String featName;

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

    public String getFeatName() {
        return featName;
    }

    public void setFeatName(String featName) {
        this.featName = featName;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
