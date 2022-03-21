package com.images_base.backend.modal.vo.picture;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/3/21
 */
@ApiModel("最近一周 top5使用量图片")
public class PictureStatWeakVO {

    @ApiModelProperty("使用次数")
    private Long useTimes;

    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @ApiModelProperty("使用日期")
    private LocalDate useDate;

    @ApiModelProperty("图片名称")
    private String pictureName;

    public PictureStatWeakVO() {
    }

    public PictureStatWeakVO(Long useTimes, String pictureId, LocalDate useDate, String pictureName) {
        this.useTimes = useTimes;
        this.pictureId = pictureId;
        this.useDate = useDate;
        this.pictureName = pictureName;
    }

    public Long getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Long useTimes) {
        this.useTimes = useTimes;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public LocalDate getUseDate() {
        return useDate;
    }

    public void setUseDate(LocalDate useDate) {
        this.useDate = useDate;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return "PictureStatWeakVO{" +
                "useTimes=" + useTimes +
                ", pictureId='" + pictureId + '\'' +
                ", useDate=" + useDate +
                ", pictureName='" + pictureName + '\'' +
                '}';
    }
}
