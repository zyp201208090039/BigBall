package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class PageController {
    @RequestMapping("/test")
    public String test(){
        return "index";
    }
    @RequestMapping("/test3")
    public String test3(){
        return "ScoreTrend";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String Test2(){
        return "Hello world..";
    }

    @RequestMapping("/UnAuth")
    public String UnAuth()
    {
        return "UnAuthoring";
    }
    @RequestMapping("/Lookup")
    public String Lookup(ServletRequest servletRequest){

        String url="ScoreTrend";
//        System.out.println("you are invoking BMOnline");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession session= httpServletRequest.getSession();
//        if (session!=null)
//        {
//            if (session.getAttribute("phoneNumber")==null)
//            {
//                System.out.println("you are invoking BMOnline phoneNumber is null");
//                // ((HttpServletResponse) servletResponse).sendRedirect("/Education/UnAuthoring.html");
//                url= "/UnAuthoring";
//            }
//        }

        return "ScoreTrend";
    }


    @RequestMapping("/BMOnline")
    public String BaoMingOnLine(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        System.out.println("you are invoking BMOnline");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session= httpServletRequest.getSession();
        if (session!=null)
        {
            if (session.getAttribute("phoneNumber")==null)
            {
                System.out.println("you are invoking BMOnline phoneNumber is null");
               // ((HttpServletResponse) servletResponse).sendRedirect("/Education/UnAuthoring.html");
                return "/UnAuthoring";
            }
        }

        return "/BaoMingOnLine";
    }

    @RequestMapping("/LookUpScore")
    public String LookUpScore(ServletRequest servletRequest, ServletResponse servletResponse)
    {
        System.out.println("you are invoking LookUpScore");
        Boolean flog=true;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session= httpServletRequest.getSession();
        if (session!=null)
        {
            if (session.getAttribute("user")==null)
            {
                // ((HttpServletResponse) servletResponse).sendRedirect("/Education/UnAuthoring.html");
                flog= false;
            }
        }
        if (!flog)
        {
            System.out.println("you are invoking LookUpScore failed..");
            return "UnAuthoring";
        }
        else
        {
            System.out.println("you are invoking ScoreTrend");
            return "ScoreTrend";
        }
    }

    private  boolean isAdmin(ServletRequest servletRequest, ServletResponse servletResponse)
    {

        Boolean flag = false;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        if (session != null)
        {
            User user=(User)session.getAttribute("user");
            if (user!=null)
            {
                if (user.getRole().equalsIgnoreCase("admin"))
                {
                    flag = true;
                }
            }

        }
        return  flag;
    }
    @RequestMapping("/OperationScore")
    public String CheckSocreAdmin(ServletRequest servletRequest, ServletResponse servletResponse)
    {

        boolean flag=this.isAdmin(servletRequest,servletResponse);
        if (!flag)
        {
            return "/ForAdmin";
        }
      return "StudentsScoreOperation";
    }
    @RequestMapping("/StudentListAdmin")
    public String StudentList(ServletRequest servletRequest, ServletResponse servletResponse)
    {
        System.out.println("you are invoking StudentListAdmin");
        boolean flag=this.isAdmin(servletRequest,servletResponse);
        if (!flag)
        {
            System.out.println("you are invoking StudentListAdmin failed..");
            return "/ForAdmin";
        }
        return "StudentList";
    }

}
