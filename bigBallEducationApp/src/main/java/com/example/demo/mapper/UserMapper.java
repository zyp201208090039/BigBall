package com.example.demo.mapper;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select * from Login")
    List<User> getAllUser();

    @Insert({"insert into Login(PhoneNumber,Pwd,name,nick,saying,Photo) values(#{PhoneNumber},#{Pwd},#{name},#{nick},#{saying},#{Photo})"})
    int addUser(User user);


    @Select("select * from Login where PhoneNumber=#{Number}")
    User getUserByPhoneNumber(String Number);

    @Update("update Login set saying=#{saying},nick=#{nick},name=#{name}, photo=#{photo} where PhoneNumber=#{PhoneNumber}")
    Integer updateUser(User user);

    @Update("update Login set saying=#{saying},nick=#{nick} where PhoneNumber=#{PhoneNumber}")
    Integer updateUserWithBaseInfo(User user);

    @Update("update Login set photo=#{path} where PhoneNumber=#{PhoneNumber}")
    Integer updateUserPhoto(String PhoneNumber, String path);

    @Delete("delete from Login where PhoneNumber=#{Number}")
    Integer deleteUserByPhoneNumber(String Number);


}
