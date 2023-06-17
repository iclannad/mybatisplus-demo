package com.glinet.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
public class MybatisplusApplicationWrapperTests {

    @Autowired
    private SysUserMapper userMapper;


    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("user_name", "o").between("age", 20, 30);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    // 测试排序
    @Test
    public void test02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper
                .like("user_name", "o")
                .between("age", 20, 30)
                .orderByDesc("uid");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    // 测试删除
    @Test
    public void test03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper
                .like("user_name", "o")
                .between("age", 20, 30);
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    // 测试修改
    @Test
    public void test04() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper
                .like("user_name", "o")
                .between("age", 20, 30)
                .or()
                .isNull("email");

        User user = new User();
        user.setName("ming");


        int update = userMapper.update(user, wrapper);
        System.out.println(update);

    }

    @Test
    public void test05() {
        // lambda中的条件构造器优先执行
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        // UPDATE sys_user SET user_name=? WHERE is_deleted=0 AND (user_name LIKE ? AND age > ? OR email IS NULL)
//        wrapper
//                .like("user_name", "o")
//                .gt("age", 20)
//                .or()
//                .isNull("email");

        // UPDATE sys_user SET user_name=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        wrapper
                .like("user_name", "o")
                .and(i -> i.gt("age", 20).or().isNull("email"));

        User user = new User();
        user.setName("ming");


        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }


    @Test
    public void test06() {
        // 查询用户名，年龄，邮箱信息,设置查询字段
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07() {
        // 查询id小于等于100的用户信息
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM sys_user WHERE is_deleted=0 AND (uid IN (select uid from sys_user where uid <= 100))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid", "select uid from sys_user where uid <= 100");

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08() {
        // lambda中的条件构造器优先执行
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();

        wrapper
                .like("user_name", "o")
                .and(i -> i.gt("age", 20).or().isNull("email"));

        wrapper.set("user_name", "xxx");

        // UPDATE sys_user SET user_name=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        int update = userMapper.update(null, wrapper);
        System.out.println(update);
    }


    @Test
    public void test09() {
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM sys_user WHERE is_deleted=0 AND (age > ? AND age <= ?)
        String username = "o";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        if (StringUtils.isNotBlank(username)) {
//            wrapper.like("user_name", username);
//        }
//        if (Objects.nonNull(ageBegin)) {
//            wrapper.gt("age", ageBegin);
//        }
//        if (Objects.nonNull(ageEnd)) {
//            wrapper.le("age", ageEnd);
//        }
//        wrapper.like(StringUtils.isNotBlank(username), "user_name", username)
//                .gt(Objects.nonNull(ageBegin), "age", ageBegin)
//                .le(Objects.nonNull(ageEnd), "age", ageEnd);

        wrapper = wrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .gt(Objects.nonNull(ageBegin), "age", ageBegin)
                .le(Objects.nonNull(ageEnd), "age", ageEnd);

        userMapper.selectList(wrapper).forEach(System.out::println);


    }


    // 测试lambda查询
    @Test
    public void test11() {
//        String name = null;
        String name = "o";

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 保证字段名不会写错
        wrapper.like(StringUtils.isNotBlank(name), User::getName, name);
//        wrapper.like(User::getName, name);


        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    // 测试lambda更新
    @Test
    public void test12() {
        String name = null;
//        String name = "o";

        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
//        wrapper.like(StringUtils.isNotBlank(name), User::getName,name);
        wrapper.like(User::getName, name);

        // 不用自己设置字段
        wrapper.set(User::getName, "xie");
//
//        User user = new User();
//        user.setName("ming");


        // UPDATE sys_user SET user_name=? WHERE is_deleted=0 AND (user_name LIKE ?)
        int update = userMapper.update(null, wrapper);
        System.out.println(update);
    }

}
