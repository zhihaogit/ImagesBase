package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.type.BlobTypeHandler;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@TableName("picture")
@ResponseBodyAnnotation
@ApiModel("图片存储类")
public class PictureEntity extends BaseEntity {

    public static final String PICTURE_ID = "picture_id";

    @TableField("use_times")
    @ApiModelProperty("使用次数")
    private Long useTimes;

    @TableField("uploader")
    @ApiModelProperty("上传者ID")
    private Long uploader;

    @TableField("picture_name")
    @ApiModelProperty("图片名称")
    private String pictureName;

    @TableField("picture_type")
    @ApiModelProperty("图片类型")
    private String pictureType;

    @TableField("picture_id")
    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @TableField(value = "picture_origin", typeHandler = BlobTypeHandler.class)
    @ApiModelProperty("图片二进制数据")
    private byte[] pictureOrigin;

    @TableLogic(value = "0", delval = "1")
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

    public Long getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Long useTimes) {
        this.useTimes = useTimes;
    }

    public Long getUploader() {
        return uploader;
    }

    public void setUploader(Long uploader) {
        this.uploader = uploader;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getPictureOrigin() {
        return pictureOrigin;
    }

    public void setPictureOrigin(byte[] pictureOrigin) {
        this.pictureOrigin = pictureOrigin;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
