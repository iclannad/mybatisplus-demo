package com.glinet.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPluginsTest {

    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void testPage() {
        // 第一页，一页3个数量
        Page<User> page = new Page<>(1, 3);

        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM sys_user WHERE is_deleted=0 LIMIT ?,?
        userMapper.selectPage(page, null);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());
    }


    @Test
    public void testPageVo() {
        // 自定义SQL支持分页查询
        Page<User> page = new Page<>(1, 3);

//==>  Preparing: select * from sys_user where age <= ? LIMIT ?
//==> Parameters: 30(Integer), 3(Long)
        userMapper.selectPageVo(page, 30);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());

    }

}
