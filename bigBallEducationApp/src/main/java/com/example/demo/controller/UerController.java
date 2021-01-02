package com.example.demo.controller;

import com.example.demo.model.StateEnum;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UerController {
    @RequestMapping("/user")
    public String sayUser()
    {
        return "user controller";
    }
    @Autowired
    private UserService userService;
    @RequestMapping("getAllUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @RequestMapping("/addUser")
    public Status addUser(@RequestBody User user)
    {
        Status status=new Status();
        try {

            java.sql.Date dt=new  java.sql.Date( new  java.util.Date().getTime());
            user.setRegistTime(dt);
            userService.addUser(user);
            status.setCode(StateEnum.secuccessful.getValue());
            status.setMsg("seccessful");
        }
        catch (Exception ex)
        {
            status.setMsg("failed");
            status.setReason(ex.toString());
        }
         return status;
    }
    @RequestMapping("/getUserWithPhone/{phoneNumber}")
    public User getUserWithPhone( @PathVariable("phoneNumber") String PhoneNumber)
    {
        return  userService.getUserByPhoneNumber(PhoneNumber);
    }

    @RequestMapping("/login/{phoneNumber}/{pwd}")
    public Status login(@PathVariable("phoneNumber") String PhoneNumber, @PathVariable("pwd") String pwd, HttpServletRequest request)
        {
        Status status=new Status();
        User user= userService.getUserByPhoneNumber(PhoneNumber);
        if (user!=null)
        {
            if (user.getPwd().equals(pwd))
            {
                request.getSession().setAttribute("phoneNumber", user.getPhoneNumber());
                request.getSession().setAttribute("user", user);
                status.setT(user);
                status.setCode(StateEnum.secuccessful.getValue());
                status.setMsg("seccessful");
            }
            else
            {
                status.setMsg("failed");
            }
        }
        else
        {
            status.setMsg("failed");
        }
        return  status;
    }

    @RequestMapping("/logout/{phoneNumber}")
    public Status login(@PathVariable("phoneNumber") String PhoneNumber, HttpServletRequest request)
    {
        System.out.println("you are invoking login");
        Status status=new Status();
        User user= userService.getUserByPhoneNumber(PhoneNumber);
        if (user!=null)
        {
                request.getSession().removeAttribute("phoneNumber");
                request.getSession().removeAttribute("user");
                status.setMsg("seccessful");

        }
        else
        {
            status.setMsg("failed");
        }
        return  status;
    }

    @RequestMapping("/updateUserBaseInfo")
    public Status updateUser(@RequestBody User user)
    {
        Status status=new Status();
        try {
           int row= userService.updateUserBaseInfo(user);
           if (row>0)
           {
               status.setMsg("seccessful");
           }
           else
           {
               status.setMsg("failed");
           }

        }
        catch (Exception ex)
        {
            status.setMsg("failed");
            status.setReason(ex.toString());
        }
        return status;
    }
}
