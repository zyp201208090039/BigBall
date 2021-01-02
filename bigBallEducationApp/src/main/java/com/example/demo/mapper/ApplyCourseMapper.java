package com.example.demo.mapper;

import com.example.demo.model.Announcement;
import com.example.demo.model.ApplyCourse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ApplyCourseMapper {

    @Select("\n" +
            "SELECT a.tname AS tname, a.stuname AS stuname, t.imgurl AS imgurl, a.date AS DATE, a.tnumber AS tnumber,t.tel AS ttel, \n" +
            "a.stunumber AS stunumber,a.tsubject AS tsubject, a.tnum AS tnum, a. id AS id,\n" +
            "a.statusenum as statusenum\n"+
            "FROM ApplyCourse a LEFT JOIN Teacherinfo  t ON a.tnumber=t.number")
    List<ApplyCourse> getAllApplyCourses();

    @Select("SELECT a.tname AS tname, a.stuname AS stuname, t.imgurl AS imgurl, a.date AS DATE, a.tnumber AS tnumber,t.tel AS ttel, \n" +
            "a.stunumber AS stunumber,a.tsubject AS tsubject, a.tnum AS tnum, a. id AS id,\n" +
            "a.statusenum as statusenum\n"+
            "FROM ApplyCourse a LEFT JOIN Teacherinfo  t ON a.tnumber=t.number" +
            "  WHERE statusEnum='no' ")
    List<ApplyCourse> getAllApplyCoursesWithNoPass();


    @Select("SELECT a.tname AS tname, a.stuname AS stuname, t.imgurl AS imgurl, a.date AS DATE, a.tnumber AS tnumber,t.tel AS ttel, \n" +
            "a.stunumber AS stunumber,a.tsubject AS tsubject, a.tnum AS tnum, a. id AS id,\n" +
            "a.statusenum as statusenum\n"+
            "FROM ApplyCourse a LEFT JOIN Teacherinfo  t ON a.tnumber=t.number" +
            "  WHERE statusEnum='YES' ")
    List<ApplyCourse> getAllApplyCoursesWithPass();

    @Insert("insert into ApplyCourse (tname,tnumber,stuname,stunumber,tsubject,tnum,statusenum,date) values (#{tname},#{tnumber},#{stuname},#{stunumber},#{tsubject},#{tnum},#{statusenum},#{date})")
    int addApplyCourse(ApplyCourse applyCourse);

    @Update("update ApplyCourse set statusenum=#{statusenum} where id=#{id}")
    Integer updateApplyCourse(ApplyCourse applyCourse);
}
