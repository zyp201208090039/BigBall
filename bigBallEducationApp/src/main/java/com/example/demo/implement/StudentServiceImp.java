package com.example.demo.implement;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getAllStudents() {
       return studentMapper.getAllStudents();
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStduent(student);
    }

    @Override
    public Student getStudentByIdent(String Ident) {
        return  studentMapper.getStudnetByIdent(Ident);
    }

    @Override
    public int deletStudentByIdent(String Ident) {
        return studentMapper.deleteStudentByIdentr(Ident);
    }
}
