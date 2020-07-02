package com.example.bigdata.mapper;

import com.example.bigdata.dao.MengNiuUser;
import com.example.bigdata.dao.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhanjun
 * date 2020-06-30
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM app_user WHERE name = #{name} ")
    @MapKey("name")
    Map<String, User> selectUserByName(@Param("name") String name);

    @Select("SELECT * FROM app_user ORDER BY id LIMIT 20000")
    @MapKey("id")
    List<Map> selectAllUsers();

    @Insert("INSERT INTO mengniu_activity_detail(`type`, `name`, `uid`, `phone`, `role`,`area`,`sign_in_count`,`draw_count`,`win_count`,`play_game_count`,`upload_receipt_count`,`jd_exchange_count`,`b_register_count`,`point`,`statistics_date`)" +
            "values(#{type},#{name},#{uid},#{phone},#{role},#{area},#{sign_in_count},#{draw_count},#{win_count},#{play_game_count},#{upload_receipt_count},#{jd_exchange_count},#{b_register_count},#{point},#{statistics_date})")
    void insertMengNiuUser(MengNiuUser user);

}
