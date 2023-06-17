package com.glinet.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

// 测试通用枚举类
@Getter
public enum SexEnum {

    MALE(0, "male"),

    FEMALE(1, "female");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
