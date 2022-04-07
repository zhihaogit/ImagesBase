package com.images_base.backend.modal.vo.picture;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/15
 */
@ApiModel("图片下载VO")
public class PictureFileVO implements Serializable {

    public static final long serialVersionUID = 2L;

    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @ApiModelProperty("图片类型")
    private String pictureType;

    @ApiModelProperty("图片二进制数据")
    private byte[] pictureOrigin;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public byte[] getPictureOrigin() {
        return pictureOrigin;
    }

    public void setPictureOrigin(byte[] pictureOrigin) {
        this.pictureOrigin = pictureOrigin;
    }

    @Override
    public String toString() {
        return "PictureFileVO{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureType='" + pictureType + '\'' +
                ", pictureOrigin=" + Arrays.toString(pictureOrigin) +
                '}';
    }
}
