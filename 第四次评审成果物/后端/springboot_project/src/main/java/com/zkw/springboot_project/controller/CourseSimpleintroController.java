package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseSimpleintroDao;
import com.zkw.springboot_project.entity.CourseDetailintro;
import com.zkw.springboot_project.entity.CourseRelation;
import com.zkw.springboot_project.entity.CourseSimpleintro;
import com.zkw.springboot_project.entity.QueryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Api(description = "管理课程基础内容信息")
@RestController
@RequestMapping("/CourseSimples")
public class CourseSimpleintroController {

    @Autowired
    private final CourseSimpleintroDao courseSimpleintroDao;

    public CourseSimpleintroController(CourseSimpleintroDao courseSimpleintroDao){
        this.courseSimpleintroDao = courseSimpleintroDao;
    }

    @ApiOperation(value = "查询全部基础内容信息")
    @GetMapping("/AllCourseSimple")
    public String getCourseSimpleList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseSimpleintroDao.getCourseSimpleintroCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<CourseSimpleintro> courseSimpleintros = courseSimpleintroDao.getAllCourseSimpleintro("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courseSimpleintros);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加课程基础内容信息")
    @PostMapping("/CourseSimple")
    public String addCourseSimple(@RequestBody CourseSimpleintro courseSimpleintro){
        System.out.println(courseSimpleintro);
        int state = courseSimpleintroDao.addCourseSimple(courseSimpleintro);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程基础内容信息")
    @DeleteMapping("/CourseSimple")
    public String deleteCourseSimple(String courseid){
        System.out.println(courseid);
        int state = courseSimpleintroDao.deleteCourseSimple(courseid);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "更新课程基础内容信息")
    @PutMapping("/CourseSimple")
    public String editCourseSimple(@RequestBody CourseSimpleintro courseSimpleintro){
        System.out.println(courseSimpleintro);
        int state = courseSimpleintroDao.editCourseSimple(courseSimpleintro);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的课程基本信息")
    @GetMapping("/CourseSimpleMessage")
    public String getUpdateCourseSimple(String courseid){
        System.out.println("课程编号:" + courseid);
        CourseSimpleintro updateCourseSimple = courseSimpleintroDao.getUpdateCourseSimple(courseid);
        String users_json = JSON.toJSONString(updateCourseSimple);
        return users_json;
    }

}
