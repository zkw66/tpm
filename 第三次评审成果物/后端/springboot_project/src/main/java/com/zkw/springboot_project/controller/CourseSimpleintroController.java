package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseSimpleintroDao;
import com.zkw.springboot_project.entity.CourseSimpleintro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Api(description = "管理课程基础内容信息")
@RestController
public class CourseSimpleintroController {

    @Autowired
    private final CourseSimpleintroDao courseSimpleintroDao;

    public CourseSimpleintroController(CourseSimpleintroDao courseSimpleintroDao){
        this.courseSimpleintroDao = courseSimpleintroDao;
    }

    @ApiOperation(value = "查询全部课程基础内容信息")
    @GetMapping("/findallCourseSimple")
    public String getUpdateCourseSimple(String courseid){
        CourseSimpleintro updateCourseSimple = courseSimpleintroDao.getUpdateCourseSimple(courseid);
        String users_json = JSON.toJSONString(updateCourseSimple);
        return users_json;
    }

    @ApiOperation(value = "添加课程基础内容信息")
    @PostMapping("/addCourseSimple")
    public String addCourseSimple(@RequestBody CourseSimpleintro courseSimpleintro){
        System.out.println(courseSimpleintro);
        int state = courseSimpleintroDao.addCourseSimple(courseSimpleintro);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程基础内容信息")
    @DeleteMapping("/deleteCourseSimple")
    public String deleteCourseSimple(String courseid){
        System.out.println(courseid);
        int state = courseSimpleintroDao.deleteCourseSimple(courseid);
        String str = state >0?"success":"error";
        return str;
    }



    @ApiOperation(value = "更新课程基础内容信息")
    @PutMapping("/updateCourseSimple")
    public String editCourseSimple(@RequestBody CourseSimpleintro courseSimpleintro){
        System.out.println(courseSimpleintro);
        int state = courseSimpleintroDao.editCourseSimple(courseSimpleintro);
        String str = state >0?"success":"error";
        return str;
    }

}
