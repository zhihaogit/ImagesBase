package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@TableName("picture_info")
@ResponseBodyAnnotation
@ApiModel("图片存储类")
public class PictureInfoEntity {

    public static final String PICTURE_ID = "picture_id";

    @TableField("uploader")
    @ApiModelProperty("上传者ID")
    private Long uploader;

    @TableField("picture_type")
    @ApiModelProperty("图片类型")
    private String pictureType;

    @TableField("picture_name")
    @ApiModelProperty("图片名称")
    private String pictureName;

    @TableField("description")
    @ApiModelProperty("图片描述")
    private String description;

    @TableId
    @TableField("picture_id")
    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @TableLogic(value = "0", delval = "1")
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUploader() {
        return uploader;
    }

    public void setUploader(Long uploader) {
        this.uploader = uploader;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }
}
