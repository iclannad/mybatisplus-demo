package com.glinet.mybatisplus;

import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationServiceTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;


    @Test
    public void testGetCount() {
        // SELECT COUNT( * ) FROM sys_user
        long count = userService.count();
        System.out.println("count:" + count);

    }

    @Test
    public void testInsertMore() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setId(String.format("%d", i + 1));
//            user.setUserName("testname" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveOrUpdateBatch(list);
        System.out.println(b);

    }

}
