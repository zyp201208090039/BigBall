package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.StateEnum;
import com.example.demo.model.Status;
import com.example.demo.model.Student;
import com.example.demo.model.StudentScore;
import com.example.demo.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.List;



@RequestMapping("/score")
@RestController
public class StudentScoreController {

    @Autowired
    private StudentScoreService studentScoreServiceImpl;

    @RequestMapping("/getAllScore")
    public List<StudentScore> getAllStudentScore()
    {
        return  studentScoreServiceImpl.getAllScore();
    }
    @RequestMapping("/addStudentScore")
    public int  addStudentScore(@RequestBody StudentScore score)
    {
        java.sql.Date dt=new  java.sql.Date( new  java.util.Date().getTime());
        score.setScoreDate(dt);
        return  studentScoreServiceImpl.addStudentScore(score);
    }
    //HttpServletRequest request


    @RequestMapping("/add")
    public Status add(HttpServletRequest qrequest) throws IOException {
       // String value=qrequest.getParameter("name");
        Status status = new Status();
        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) qrequest.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }

        // 将资料解码
        String s = sb.toString();
        JSONObject json = JSONObject.parseObject(s);

        StudentScore score=new StudentScore();
        score.setName(json.getString("name"));
        score.setNumber(json.getString("number"));
        JSONArray arry= json.getJSONArray("subjects");
        if (arry!=null)
        {
            for (int i=0;i<arry.size();i++)
            {
               String sub= (String) arry.getJSONObject(i).get("subject");
                int sco= Integer.parseInt((String)arry.getJSONObject(i).get("score")) ;
                this.parse(sub,sco,score);
            }
        }

        try
        {
            java.sql.Date dt=new  java.sql.Date( new  java.util.Date().getTime());
            score.setScoreDate(dt);
            studentScoreServiceImpl.addStudentScore(score);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch ( Exception e)
        {
            e.printStackTrace();
            status.setMsg("failed");
            status.setReason(e.toString());
        }

        return status;
    }
     private  void parse(String sub, int score, StudentScore stu)
     {
         if (sub.equalsIgnoreCase("数学"))
         {
             stu.setMath(score);
         }
         else if (sub.equalsIgnoreCase("物理"))
         {
             stu.setPhysics(score);
         }
         else if (sub.equalsIgnoreCase("化学"))
         {
             stu.setChemistry(score);
         }
         else if (sub.equalsIgnoreCase("语文"))
         {
             stu.setChinese(score);
         }
         else if (sub.equalsIgnoreCase("英语"))
         {
             stu.setEnglish(score);
         }
         else if (sub.equalsIgnoreCase("生物"))
         {
             stu.setBiology(score);
         }
         else if (sub.equalsIgnoreCase("政治"))
         {
             stu.setPolitics(score);
         }
         else if (sub.equalsIgnoreCase("历史"))
         {
             stu.setHistory(score);
         }
         else if (sub.equalsIgnoreCase("地理"))
         {
             stu.setGeographic(score);
         }
     }

    @RequestMapping("/getScoreByIdent/{Ident}")
    public Status getScoreByIdent( @PathVariable("Ident") String Ident)
    {
        Status status = new Status();

        try {
            List<StudentScore>  ls=studentScoreServiceImpl.getScoreByIdent(Ident);
            status.setT(ls);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            status.setMsg("failed");
            status.setReason(e.toString());
        }

        return  status;
    }
    @RequestMapping("/updateScoreWithIdAndSubject")
    public int updateScoreWithIdAndSubject(StudentScore score)
    {
        return  studentScoreServiceImpl.updateScoreByIdentAndSubject(score);
    }
    @RequestMapping("/updateScoreWithId")
    public Integer updateScoreWithId(@RequestBody StudentScore score)
    {
        return  studentScoreServiceImpl.updateScoreWithId(score);
    }
    @RequestMapping("/getScoreByid/{id}")
    public StudentScore getScoreByid( @PathVariable("id") String id,@PathVariable("id") String name)
    {
        return  studentScoreServiceImpl.getScoreByid(id,name);
    }
}
