package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class PictureEntity {

    @TableId
    @TableField("picture_id")
    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @TableField(value = "picture_origin", typeHandler = BlobTypeHandler.class)
    @ApiModelProperty("图片二进制数据")
    private byte[] pictureOrigin;

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
}
