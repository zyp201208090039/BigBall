package com.example.demo.controller;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/T")
public class TeachersController {

    @Autowired
    private  TeacherMapper tmapper;
    @Autowired
    private TeacherService mapper;
    @Autowired
    private  Status status;
    @GetMapping("/")
    public String index()
    {
        return  "Teacher";
    }
    @RequestMapping("/Add")
    public Status add(@RequestBody Teacher t)
    {
        try
        {
            status.setCode(StateEnum.secuccessful.getValue());
            t.setPass("NO");
            mapper.addTeacher(t);
        }
        catch ( Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg(ex.toString());
        }
        return  status;
    }

    @RequestMapping("/getUnAuthen")
    public Status getAllUnAuthen()
    {
        try
        {
            status.setCode(StateEnum.secuccessful.getValue());
            status.setT(mapper.getAllUnAuThenTeacher());
        }
        catch ( Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg(ex.toString());
        }
        return  status;
    }
    @Autowired
    UserMapper umpper;
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/setUnAuthen/{id}")
    public Status setUnAuthen(  @PathVariable("id") String id)
    {
        try
        {
            status.setCode(StateEnum.secuccessful.getValue());
            mapper.setAuthen(id);

           Teacher t= tmapper.getTeacher(Integer.parseInt(id));
            User user=new User();
            user.setName(t.getName());
            user.setRole(RoleEnum.Teacher.getSrole());
            user.setPwd(t.getPwd());
            user.setPhoneNumber(t.getTel());
            umpper.addUser(user);


        }
        catch ( Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg(ex.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            ex.printStackTrace();
        }
        return  status;
    }

    @RequestMapping("/delete/{id}")
    public Status deleteTeacher(  @PathVariable("id") String id)
    {
        try
        {
            status.setCode(StateEnum.secuccessful.getValue());
            mapper.deleteTeacher(Integer.parseInt(id));
        }
        catch ( Exception ex)
        {
            status.setCode(StateEnum.failed.getValue());
            status.setMsg(ex.toString());
        }
        return  status;
    }

}
