package com.example.bigdata.service;

import com.example.bigdata.dao.User;
import com.example.bigdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-07-01
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public Map<String,User> selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }
}
