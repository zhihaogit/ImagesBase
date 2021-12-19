package com.images_base.backend.modal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserEntity
 * @Description:
 * @Author: zhengzhihao
 * @Date: 2021/12/19 21:42
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
    public static final long serialVersionUID = 42L;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
