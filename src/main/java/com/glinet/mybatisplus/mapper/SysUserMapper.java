package com.glinet.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.glinet.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SysUserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     *
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    /**
     * 自定义查询方法支持分页插件
     *
     * @param page MyBatis-Plus所提供的的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}