package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseBookDao;
import com.zkw.springboot_project.entity.CourseBook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理课程有关教材和参考书目信息")
@RestController
public class CourseBookController {

    @Autowired
    private final CourseBookDao courseBookDao;

    public  CourseBookController(CourseBookDao courseBookDao){
        this.courseBookDao = courseBookDao;
    }

    @ApiOperation(value = "查询全部课程教材信息")
    @GetMapping("/findallCourseBook")
    public String getCourseBookList(String courseid){
        System.out.println("courseid:" + courseid);
        List<CourseBook> courseBooks = courseBookDao.getAllCourseBook(courseid);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data",courseBooks);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加教材或参考书目信息")
    @PostMapping("/addCourseBook")
    public String addCourseBook(@RequestBody CourseBook courseBook){
        System.out.println(courseBook);
        int state = courseBookDao.addCourseBook(courseBook);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除教材或参考书目")
    @DeleteMapping("/deleteCourseBook")
    public String deleteCourseBook(String courseid,String bookname){
        System.out.println("bookname:" + bookname);
        int state = courseBookDao.deleteCourseBook(courseid,bookname);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的教材或参考书目信息")
    @GetMapping("/getUpdateCourseBook")
    public String getUpdateCourseBook(String courseid,String bookname){
        System.out.println("课程编号:" + courseid + "书名" + bookname);
        CourseBook updateCourseBook = courseBookDao.getUpdateCourseBook(courseid,bookname);
        String users_json = JSON.toJSONString(updateCourseBook);
        return users_json;
    }

    @ApiOperation(value = "更新教材或参考书目信息")
    @PutMapping("/updateCourseBook")
    public String editCourseBook(@RequestBody CourseBook courseBook){
        System.out.println(courseBook);
        int state = courseBookDao.editCourseBook(courseBook);
        String str = state >0?"success":"error";
        return str;
    }

}
