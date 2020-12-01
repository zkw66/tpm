package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.*;
import com.zkw.springboot_project.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理公众查看课程信息")
@RestController
@RequestMapping("/Publics")
public class PublicCourseController {

    @Autowired
    private final CourseDao courseDao;
    private final CourseDetailintroDao courseDetailintrodao;
    private final CourseBookDao courseBookDao;
    private final CourseRelationDao courseRelationDao;
    private final CourseSimpleintroDao courseSimpleintroDao;


    public  PublicCourseController(CourseDao courseDao,CourseDetailintroDao courseDetailintrodao,CourseBookDao courseBookDao,CourseRelationDao courseRelationDao,CourseSimpleintroDao courseSimpleintroDao){

        this.courseDao = courseDao;
        this.courseDetailintrodao = courseDetailintrodao;
        this.courseBookDao = courseBookDao;
        this.courseRelationDao = courseRelationDao;
        this.courseSimpleintroDao = courseSimpleintroDao;
    }

    @ApiOperation(value = "查询已发布的课程基本信息")
    @GetMapping("/AllCourse")
    public String getPublicCourseBaseList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseDao.getPublicCourseCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Course> courses = courseDao.getAllPublicCourseBase("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courses);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
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

    @ApiOperation(value = "查询全部课程详细内容信息")
    @GetMapping("/AllCourseDetail")
    public String getCourseBaseList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseDetailintrodao.getCourseDetailCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<CourseDetailintro> courseDetailintros = courseDetailintrodao.getAllCourseDetail("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courseDetailintros);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "查询全部课程先修后修关系")
    @GetMapping("/AllCourseRelation")
    public String getCourseRelationList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseRelationDao.getCourseRelationCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<CourseRelation> courseRelations = courseRelationDao.getAllCourseRelation("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courseRelations);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "查询全部教材或参考书目信息")
    @GetMapping("/AllCourseBook")
    public String getCourseBookList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = courseBookDao.getCourseBookCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<CourseBook> courseBooks = courseBookDao.getAllCourseBook("%"+queryInfo.getQuery()+"%","%"+queryInfo.getRole()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",courseBooks);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }
}
