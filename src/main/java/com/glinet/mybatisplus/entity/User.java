package com.glinet.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.glinet.mybatisplus.enums.SexEnum;
import lombok.Data;

@Data
//@TableName("sys_user")
public class User {
    // 主键注解
//    @TableId(value = "uid", type = IdType.ASSIGN_UUID)
//    private String id;
    @TableId(value = "uid")
    private String id;

    // 指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;

    private SexEnum sex;

    // 逻辑删除/物理删除
    @TableLogic
    private Integer isDeleted;

}