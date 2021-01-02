package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

import java.util.List;

public interface TeacherService {

    int deleteTeacher(int id);
    int addTeacher(Teacher t);
    int updateTeacher(Teacher t);
    List<Teacher> getAllTeacher();
    List<Teacher> getAllAuThenTeacher();
    List<Teacher> getAllUnAuThenTeacher();
    int setAuthen(String id);
}
