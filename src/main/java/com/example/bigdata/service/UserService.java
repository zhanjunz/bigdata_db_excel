package com.example.bigdata.service;

import com.example.bigdata.dao.MengNiuUser;
import com.example.bigdata.dao.User;

import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-07-01
 */
public interface UserService {
    List<Map> selectAllUsers();

    Map<String, User> selectUserByName(String name);

    void insertMengNiuUser(MengNiuUser user);
}
