package com.example.demo.mapper;

import com.example.demo.model.TeacherInfo;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherInfoMapper {

    @Select("select * from teacherInfo")
    List<TeacherInfo> getAllTeachers();

    @Insert({"insert into teacherInfo(name,subject,number,imgurl,profile,experience,successfulCase,tel) values " +
            "(#{name},#{subject},#{number},#{imgurl},#{profile},#{experience},#{successfulCase},#{tel})"})
    int addTeacher(TeacherInfo t);


    @Select("select * from teacherInfo where id=#{id}")
    TeacherInfo getTeacherById(int id);


}
