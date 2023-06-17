package com.glinet.mybatisplus;

import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.mapper.SysUserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = sysUserMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        //INSERT INTO sys_user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        // 1650165172364427265(Long), xie(String), 30(Integer), 975516776@qq.com(String)
        List<User> userList = sysUserMapper.selectList(null);
        userList.forEach(System.out::println);
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
        user.setEmail("975516776@qq.com");
//        user.setName("xie");
        user.setName("xie");
        user.setAge(30);
        int insert = sysUserMapper.insert(user);
        System.out.println("result:" + insert);
        System.out.println("id:" + user.getId());

    }

    @Test
    public void testDeleteById() {
//        List<User> userList = sysUserMapper.selectList(null);
//        userList.forEach(System.out::println);
//        System.out.println(("----- selectAll method test ------"));
//        User user = new User();
//        user.setEmail("975516776@qq.com");
////        user.setName("xie");
//        user.setAge(30);
//        int insert = sysUserMapper.insert(user);
//        System.out.println("result:" + insert);
//        System.out.println("id:" + user.getId());
//        System.out.println(("----- insert method test ------"));
//        int deleteById = sysUserMapper.deleteById(user.getId());
//        System.out.println("result:" + deleteById);

        // 根据条件删除数据
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","xie");
//        map.put("age","30");
//        int deleteByMap = sysUserMapper.deleteByMap(map);
//        System.out.println("result:" + deleteByMap);

        // 批量删除 DELETE FROM sys_user WHERE id IN ( ? , ? , ? )
        int deleteBatchIds = sysUserMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println("result:" + deleteBatchIds);

        // 测试逻辑删除
        List<User> list = sysUserMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("xie");
//        // UPDATE sys_user SET name=? WHERE id=?
//        int result = sysUserMapper.updateById(user);
//        System.out.println("result:" + result);
//
//        System.out.println(("----- update method test ------"));
//        List<User> userList = sysUserMapper.selectList(null);
//        userList.forEach(System.out::println);
//        System.out.println(("----- selectAll method test ------"));
    }

    @Test
    public void testSelect1() {
        // SELECT id,name,age,email FROM sys_user WHERE id=?
//        User user = sysUserMapper.selectById(1L);
//        System.out.println(user);

        // SELECT id,name,age,email FROM sys_user WHERE id IN ( ? , ? , ? )
//        List<User> users = sysUserMapper.selectBatchIds(Arrays.asList(1, 2, 3));
//        users.forEach(System.out::println);

        // SELECT id,name,age,email FROM sys_user WHERE name = ?
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","Jone");
//        List<User> users = sysUserMapper.selectByMap(map);
//        users.forEach(System.out::println);

//        // SELECT id,name,age,email FROM sys_user
//        List<User> userList = sysUserMapper.selectList(null);
//        userList.forEach(System.out::println);

        // select id,name,age,email from sys_user where id = ? 自定义sql
        Map<String, Object> map = sysUserMapper.selectMapById(1L);
        System.out.println(map);
    }


}
