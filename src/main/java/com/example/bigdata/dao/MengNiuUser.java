package com.example.bigdata.dao;

import lombok.Data;

import java.util.Date;

/**
 * @author zhanjun
 * date 2020-07-02
 */

@Data
public class MengNiuUser {
    private String id;
    private String type;
    private String name;
    private String uid;
    private String phone;
    private String role;
    private String area;
    private Integer sign_in_count;
    private Integer draw_count;
    private Integer win_count;
    private Integer play_game_count;
    private Integer upload_receipt_count;
    private Integer jd_exchange_count;
    private Integer b_register_count;
    private Integer point;
    private Date statistics_date;
    private Date updateTime;
}
