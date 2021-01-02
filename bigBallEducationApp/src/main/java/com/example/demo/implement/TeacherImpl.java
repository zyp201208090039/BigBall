package com.example.demo.implement;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class TeacherImpl implements TeacherService {
    @Autowired
    TeacherMapper mapper;
    @Override
    public int deleteTeacher(int id) {
        return  mapper.deleteByPrimaryKey(new Integer(id));
    }

    @Override
    public int addTeacher(Teacher t) {
        return mapper.insert(t);
    }

    @Override
    public int updateTeacher(Teacher t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return mapper.getAllTeacher();
    }

    @Override
    public List<Teacher> getAllAuThenTeacher() {
        return mapper.getAllAuthenTeacher();
    }

    @Override
    public List<Teacher> getAllUnAuThenTeacher() {
        return mapper.getAllUnAuthenTeacher();
    }


    @Override
    public int setAuthen(String id) {
        int b = Integer.valueOf(id).intValue();
        return mapper.setAuthen(b);
    }
}
