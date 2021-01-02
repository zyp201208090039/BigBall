package com.example.demo.mapper;


import com.example.demo.model.Teacher;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Delete("delete from teachers where id=#{id}")
    int deleteByPrimaryKey(Integer id);
    @Insert({"insert into teachers(name,pwd,subject,number,imgurl,pass,tel) values(#{name},#{pwd},#{subject},#{number},#{imgurl},#{pass},#{tel})"})
    int insert(Teacher record);


    @Select("select * from teachers where id=#{id}")
    Teacher getTeacher(Integer id);
//    int insertSelective(Teacher record);
//
//    Teacher selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Teacher record);

    @Update("update teachers set saying=#{saying},nick=#{nick},name=#{name}, photo=#{photo} where PhoneNumber=#{PhoneNumber}")
    int updateByPrimaryKey(Teacher record);

    @Select("select * from teachers")
    List<Teacher> getAllTeacher();

    @Select("select * from teachers where pass='NO'")
    List<Teacher> getAllUnAuthenTeacher();

    @Select("select * from teachers where pass='YES'")
    List<Teacher> getAllAuthenTeacher();

    @Update("update teachers set pass='YES' where id=#{id}")
    int setAuthen(int id);
}