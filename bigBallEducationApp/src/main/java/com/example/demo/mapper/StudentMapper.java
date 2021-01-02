package com.example.demo.mapper;


import com.example.demo.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {

    @Select("select * from students")
    List<Student> getAllStudents();

    @Insert({"insert into students(regDate,name,ident) values(#{regDate},#{name},#{ident})"})
    int addStduent(Student student);


    @Select("select * from students where ident=#{ident}")
    Student getStudnetByIdent(String ident);

    @Delete("delete from students where ident=#{ident}")
    Integer deleteStudentByIdentr(String ident);

    @Update("update students set name=#{name},phoneNumber=#{phoneNumber} where ident=#{ident}")
    Integer updateStudentWithBaseInfo(Student student);

    @Update("update students set number=#{number} where id=#{id}")
    Integer updateStudentNumber(Student student);
}
