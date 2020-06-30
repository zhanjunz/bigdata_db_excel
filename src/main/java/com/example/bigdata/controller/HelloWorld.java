package com.example.bigdata.controller;

import com.example.bigdata.entity.UserDO;
import com.example.bigdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanjun
 * date 2020-06-30
 */
@RestController
@RequestMapping("/db")
public class HelloWorld {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public UserDO selectUserByName(String name) {
        long oldtime = System.currentTimeMillis();
        UserDO userDO = userMapper.selectUserByName(name);
        long newTime = System.currentTimeMillis();
        System.out.println(newTime - oldtime);
        return userDO;
    }
}
