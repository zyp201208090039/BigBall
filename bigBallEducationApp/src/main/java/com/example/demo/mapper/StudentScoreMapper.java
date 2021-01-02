package com.example.demo.mapper;


import com.example.demo.model.StudentScore;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentScoreMapper {



    @Select("select * from studentscore")
    List<StudentScore> getAllStudentScore();

    @Insert({"insert into studentscore(scoreDate,name,number,chinese,math,english,physics,chemistry,biology,history,politics,geographic) " +
            "values(#{scoreDate},#{name},#{number},#{chinese},#{math},#{english},#{physics},#{chemistry},#{biology},#{history},#{politics},#{geographic})"})
    int addScore(StudentScore score);


    @Select("select * from studentscore  where number=#{number} or name= #{name} ORDER BY id DESC")
    List<StudentScore> getScoreByIdent(String number,String name);

    @Delete("delete from studentscore where id=#{id} ")
    Integer deleteScoreByIdent(String ident,String subject);

    @Update("update studentscore set score=#{score} where ident=#{ident} and subject=#{subject}")
    Integer updateScoreWithIdAndSubject(StudentScore score);

    @Update("update studentscore set score=#{score} where id=#{id}")
    Integer updateScoreWithId(StudentScore score);

    @Select("select * from studentscore where number=#{number} or name= #{name}")
    StudentScore getScoreByid(String number,String name);


}
