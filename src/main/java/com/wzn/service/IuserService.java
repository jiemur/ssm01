package com.wzn.service;

import com.wzn.pojo.User;

import java.util.List;

public interface IuserService {
    public List<User> getUser();
    public List<User> getUsername(User user);
    public User getOne(String username);
}
