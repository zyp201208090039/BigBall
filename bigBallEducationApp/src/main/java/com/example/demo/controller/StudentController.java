package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.ApiResult;
import com.example.demo.model.StateEnum;
import com.example.demo.model.Status;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.acl.AllPermissionsImpl;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RequestMapping("/student")
@RestController
public class StudentController {

    @RequestMapping("/Student")
    public String sayUser()
    {
        return "Student controller";
    }
    @Autowired
    private StudentService studentService;
    @RequestMapping("/getAllStudents")
    public Status getAllStudents()
    {
        Status status=new Status();
        try {
            status.setT(studentService.getAllStudents());
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
            status.setReason(ex.toString());
        }
        return status;

    }
    @RequestMapping("/addStudent")
    public Status addStudent(@RequestBody Student student)
    {
        Status status=new Status();
        try {
            java.sql.Date dt=new  java.sql.Date( new  java.util.Date().getTime());
            student.setRegDate(dt);
            studentService.addStudent(student);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg("failed");
            status.setReason(ex.toString());
        }
        return status;
    }
    @RequestMapping("/getStudentByIdent/{Ident}")
    public Student getUserWithPhone( @PathVariable("Ident") String Ident)
    {
        return  studentService.getStudentByIdent(Ident);
    }
    @RequestMapping("/deleteStudentByIdent/{Ident}")
    public int deleteStudentByIdent( @PathVariable("Ident") String Ident)
    {
        return  studentService.deletStudentByIdent(Ident);
    }
    @Autowired
    StudentMapper mapper;
    //updateStudentNumber
    @RequestMapping("/updateStudentNumber")
    public ApiResult deleteStudentByIdent(@RequestBody Student student)
    {
        mapper.updateStudentNumber(student);

        return ApiResult.ok();
    }
}
