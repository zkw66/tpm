package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseDao;
import com.zkw.springboot_project.entity.Course;
import com.zkw.springboot_project.entity.QueryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理课程基本信息")
@RestController
@RequestMapping("/Courses")
public class CourseController {

    @Autowired
    private final CourseDao courseDao;


    public  CourseController(CourseDao courseDao){
        this.courseDao = courseDao;
    }

    @ApiOperation(value = "查询全部课程基本信息")
    @GetMapping("/AllCourse")
    public String getCourseBaseList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseDao.getCourseCounts("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Course> courses = courseDao.getAllCourseBase("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courses);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加课程基本信息")
    @PostMapping("/Course")
    public String addCourseBase(@RequestBody Course course){
        System.out.println(course);
        int state = courseDao.addCourseBase(course);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("/Course")
    public String deleteCourseBase(String courseid){
        System.out.println(courseid);
        int state = courseDao.deleteCourse(courseid);
        String str = state >0?"success":"error";
        return str;
    }


    @ApiOperation(value = "获取要更新的课程基本信息")
    @GetMapping("/CourseMessage")
    public String getUpdateCourseBase(String courseid){
        System.out.println("课程编号:" + courseid);
        Course updateCourse = courseDao.getUpdateCourse(courseid);
        String users_json = JSON.toJSONString(updateCourse);
        return users_json;
    }


    @ApiOperation(value = "更新课程基础信息")
    @PutMapping("/Course")
    public String editCourseBase(@RequestBody Course course){
        System.out.println(course);
        int state = courseDao.editCourse(course);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "更改课程发布状态")
    @PutMapping("/CourseState")
    public String editCourseState(String state,String courseid){
        int states = courseDao.editState(state,courseid);
        String str = states >0?"success":"error";
        return str;
    }


}
