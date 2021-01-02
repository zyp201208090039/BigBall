package com.example.demo.service;


import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    int addStudent(Student student);
    Student getStudentByIdent(String Ident);
    int deletStudentByIdent(String Ident);
}
