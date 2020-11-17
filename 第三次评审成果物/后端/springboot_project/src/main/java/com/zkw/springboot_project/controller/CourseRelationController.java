package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseRelationDao;
import com.zkw.springboot_project.entity.CourseRelation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理课程的先修后修关系")
@RestController
public class CourseRelationController {

    @Autowired
    private final CourseRelationDao courseRelationDao;

    public CourseRelationController(CourseRelationDao courseRelationDao){
        this.courseRelationDao = courseRelationDao;
    }

    @ApiOperation(value = "查询全部课程先修后修关系")
    @GetMapping("/findallCourseRelation")
    public String getCourseRelationList(String courseid){
        System.out.println("courseid:" + courseid);
        List<CourseRelation> courseRelations = courseRelationDao.getAllCourseRelation(courseid);
        HashMap<String, Object> res = new HashMap<>();
        res.put("data",courseRelations);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加课程先修后修关系")
    @PostMapping("/addCourseRelation")
    public String addCourseRelation(@RequestBody CourseRelation courseRelation){
        System.out.println(courseRelation);
        int state = courseRelationDao.addCourseRelation(courseRelation);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程先修后修关系")
    @DeleteMapping("/deleteCourseRelation")
    public String deleteCourseRelation(String courseid,String relacourseid){
        System.out.println("relacourseid:" + relacourseid);
        int state = courseRelationDao.deleteCourseRelation(courseid,relacourseid);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的课程先修后修关系")
    @GetMapping("/getUpdateCourseRelation")
    public String getUpdateCourseRelation(String courseid,String relacourseid){
        System.out.println("课程编号:" + courseid + "有关课程编号:" + relacourseid);
        CourseRelation updateCourseRelation = courseRelationDao.getUpdateCourseRelation(courseid,relacourseid);
        String users_json = JSON.toJSONString(updateCourseRelation);
        return users_json;
    }

    @ApiOperation(value = "更新课程先修后修关系")
    @PutMapping("/updateCourseRelation")
    public String editCourseRelation(@RequestBody CourseRelation courseRelation){
        System.out.println(courseRelation);
        int state = courseRelationDao.editCourseRelation(courseRelation);
        String str = state >0?"success":"error";
        return str;
    }

}
