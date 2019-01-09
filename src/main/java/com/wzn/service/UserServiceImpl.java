package com.wzn.service;

import com.wzn.dao.UserDao;
import com.wzn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IuserService {
    @Autowired
    private UserDao dao;
    @Override
    public List<User> getUser() {
        return dao.getUser();
    }

    @Override
    public List<User> getUsername(User user) {
        return dao.getUsername(user);
    }
}
