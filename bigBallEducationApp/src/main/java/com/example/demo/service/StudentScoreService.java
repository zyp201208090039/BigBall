package com.example.demo.service;


import com.example.demo.model.StudentScore;

import java.util.List;

public interface StudentScoreService {

    List<StudentScore> getAllScore();
    int addStudentScore(StudentScore score);
    List<StudentScore> getScoreByIdent(String Ident);
    int deleteScoreByIdentAndSubject(String Ident,String Subject);
    int updateScoreByIdentAndSubject(StudentScore score);

    Integer updateScoreWithId(StudentScore score);
    StudentScore getScoreByid(String id,String name);
}
