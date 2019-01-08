package com.wzn.test;

import com.wzn.pojo.User;
import com.wzn.service.IuserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Testw {
    @Resource
    private IuserService dao;
    @Test
    public void test(){
        List<User> lists= dao.getUser();
        for (User u:lists
             ) {
            System.out.println(u);
        }
    }
}
