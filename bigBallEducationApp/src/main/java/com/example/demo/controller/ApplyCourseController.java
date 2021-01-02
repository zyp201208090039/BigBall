package com.example.demo.controller;

import com.example.demo.mapper.ApplyCourseMapper;
import com.example.demo.model.ApiResult;
import com.example.demo.model.ApplyCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/applyCourse")
public class ApplyCourseController {

    @Autowired
    ApplyCourseMapper mapper;

    @RequestMapping("/getAllApplyCourses")
    public ApiResult getAllApplyCourse()
    {
        List<ApplyCourse> applyCourseList=mapper.getAllApplyCourses();
        return  ApiResult.ok(applyCourseList);
    }

    @RequestMapping("/getAllApplyCoursesWithoutPass")
    public ApiResult getAllApplyCourseWithoutPass()
    {
        List<ApplyCourse> applyCourseList=mapper.getAllApplyCoursesWithNoPass();
        return  ApiResult.ok(applyCourseList);
    }

    @RequestMapping("/getAllApplyCoursesWithPass")
    public ApiResult getAllApplyCourseWithPass()
    {
        List<ApplyCourse> applyCourseList=mapper.getAllApplyCoursesWithPass();
        return  ApiResult.ok(applyCourseList);
    }


    @RequestMapping(value = "/addApplyCourse",method = RequestMethod.POST)
    public ApiResult addApplyCourse(@RequestBody ApplyCourse applyCourse)
    {
        applyCourse.setStatusenum("NO");
         mapper.addApplyCourse(applyCourse);
        return  ApiResult.ok();
    }
    @RequestMapping(value = "/setApplyCourseStatus",method = RequestMethod.POST)
    public ApiResult setApplyCourseStatus(@RequestBody ApplyCourse applyCourse)
    {
        applyCourse.setStatusenum("YES");
        mapper.updateApplyCourse(applyCourse);
        return  ApiResult.ok();
    }


}
