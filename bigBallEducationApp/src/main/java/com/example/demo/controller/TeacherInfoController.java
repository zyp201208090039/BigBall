package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.FileUtils;
import com.example.demo.mapper.TeacherInfoMapper;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("TInfo")
public class TeacherInfoController {

    @Autowired
    TeacherInfoMapper mapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Status add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Status status = new Status();
        try {

            // @RequestParam("file") MultipartFile file
            String s = request.getParameter("teacher");
            JSONObject json = JSONObject.parseObject(s);

            String fileName = FileUtils.saveFile(file);

            TeacherInfo tIfno = new TeacherInfo();
            tIfno.setProfile(json.getString("profile"));
            tIfno.setExperience(json.getString("experience"));
            tIfno.setSuccessfulCase(json.getString("successfulCase"));
            tIfno.setName(json.getString("name"));
            tIfno.setSubject(json.getString("subject"));
            tIfno.setNumber(json.getString("number"));
            tIfno.setTel(json.getString("tel"));
            tIfno.setImgurl(fileName);

            mapper.addTeacher(tIfno);


            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");


        } catch (Exception e) {
            e.printStackTrace();
            status.setMsg("failed");
            status.setReason(e.toString());
        }

        return status;
    }


    @RequestMapping("/getTeacher/{id}")
    public Status getTeacher(@PathVariable("id") int id) {
        Status status = new Status();
        try {

            TeacherInfo info= mapper.getTeacherById(id);
            status.setT(info);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");

        } catch (Exception e) {
            e.printStackTrace();
            status.setMsg("failed");
            status.setReason(e.toString());
        }

        return status;
    }


    @RequestMapping("/getAllTeachers")
    public Status getAllTeachers() {
        Status status = new Status();
        try {

            List<TeacherInfo> info= mapper.getAllTeachers();
            status.setT(info);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");

        } catch (Exception e) {
            e.printStackTrace();
            status.setMsg("failed");
            status.setReason(e.toString());
        }

        return status;
    }

}
