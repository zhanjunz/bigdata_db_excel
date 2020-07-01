package com.example.bigdata.mapper;

import com.example.bigdata.dao.User;
import com.example.bigdata.entity.UserDO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT * FROM app_user ORDER BY id LIMIT 1000000")
    @MapKey("id")
    List<Map> selectAllUsers();

}
