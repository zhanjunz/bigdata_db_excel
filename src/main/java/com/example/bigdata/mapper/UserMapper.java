package com.example.bigdata.mapper;

import com.example.bigdata.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhanjun
 * date 2020-06-30
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM app_user WHERE name = #{name} ")
    UserDO selectUserByName(@Param("name") String name);
}
