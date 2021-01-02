package com.example.demo.implement;


import com.example.demo.mapper.StudentScoreMapper;
import com.example.demo.model.StudentScore;
import com.example.demo.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentScoreImp implements StudentScoreService {
    @Autowired
    private StudentScoreMapper studentScoreMapper;
    @Override
    public List<StudentScore> getAllScore() {
        return studentScoreMapper.getAllStudentScore();
    }

    @Override
    public int addStudentScore(StudentScore score) {
        return studentScoreMapper.addScore(score);
    }


    @Override
    public List<StudentScore> getScoreByIdent(String Ident) {
        return studentScoreMapper.getScoreByIdent(Ident,Ident);
    }

    @Override
    public int deleteScoreByIdentAndSubject(String Ident, String Subject) {
        return studentScoreMapper.deleteScoreByIdent(Ident,Subject);
    }

    @Override
    public int updateScoreByIdentAndSubject(StudentScore score) {
        return studentScoreMapper.updateScoreWithIdAndSubject(score);
    }

    @Override
    public Integer updateScoreWithId(StudentScore score) {
        return studentScoreMapper.updateScoreWithId(score);
    }

    @Override
    public StudentScore getScoreByid(String number,String name) {
        return studentScoreMapper.getScoreByid(number,name);
    }
}
