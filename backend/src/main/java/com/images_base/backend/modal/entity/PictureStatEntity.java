package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.images_base.backend.util.annotation.ResponseBodyAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
@TableName("picture_stat")
@ResponseBodyAnnotation
@ApiModel("图片存储类")
public class PictureStatEntity {

    public static final String PICTURE_ID = "picture_id";

    public static final String USE_DATE = "use_date";

    public static final String USE_TIMES = "use_times";

    @TableField("use_times")
    @ApiModelProperty("使用次数")
    private Long useTimes;

    @TableId
    @TableField("picture_id")
    @ApiModelProperty("图片散列ID")
    private String pictureId;

    @ApiModelProperty("使用日期")
    private LocalDate useDate;

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
}
