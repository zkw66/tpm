package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseDetailintroDao;
import com.zkw.springboot_project.entity.CourseDetailintro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理课程详细内容信息")
@RestController
public class CourseDetailintroController {

    @Autowired
    private final CourseDetailintroDao courseDetailintrodao;

    public CourseDetailintroController(CourseDetailintroDao courseDetailintrodao){
        this.courseDetailintrodao = courseDetailintrodao;
    }

    @ApiOperation(value = "查询全部课程详细内容信息")
    @GetMapping("/findallCourseDetail")
    public String getCourseDetailList(String courseid,String username){
        System.out.println("courseid:" + courseid + "username" + username);
        List<CourseDetailintro> courseDetailintros = courseDetailintrodao.getAllCourseDetail(courseid,username);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data",courseDetailintros);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加课程详细章节信息")
    @PostMapping("/addCourseDetail")
    public String addCourseDetail(@RequestBody CourseDetailintro courseDetailintro){
        System.out.println(courseDetailintro);
        int state = courseDetailintrodao.addCourseDetail(courseDetailintro);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程章节内容")
    @DeleteMapping("/deleteCourseDetail")
    public String deleteCourseDetail(String courseid,int ord){
        System.out.println(courseid + "章节：" + ord);
        int state = courseDetailintrodao.deleteCourseDetail(courseid,ord);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的章节基本信息")
    @GetMapping("/getUpdateCourseDetail")
    public String getUpdateCourseDetail(String courseid,int ord){
        System.out.println("课程编号:" + courseid + "章节" + ord);
        CourseDetailintro updateCourseDetail = courseDetailintrodao.getUpdateCourseDetail(courseid,ord);
        String users_json = JSON.toJSONString(updateCourseDetail);
        return users_json;
    }

    @ApiOperation(value = "更新课程章节内容信息")
    @PutMapping("/updateCourseDetail")
    public String editCourseDetail(@RequestBody CourseDetailintro courseDetailintro){
        System.out.println(courseDetailintro);
        int state = courseDetailintrodao.editCourseDetail(courseDetailintro);
        String str = state >0?"success":"error";
        return str;
    }

}
