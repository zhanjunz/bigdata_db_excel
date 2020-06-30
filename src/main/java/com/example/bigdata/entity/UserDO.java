package com.example.bigdata.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhanjun
 * date 2020-06-30
 */
@Data
public class UserDO {

    private String id;
    private String name;
    private String phone;
    private int gender;
    private String password;
    private int age;
    private Date createTime;
    private Date updateTime;
}
