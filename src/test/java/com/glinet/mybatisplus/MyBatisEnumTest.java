package com.glinet.mybatisplus;

import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.enums.SexEnum;
import com.glinet.mybatisplus.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisEnumTest {

    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.FEMALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }

}
