package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.CourseRelationDao;
import com.zkw.springboot_project.entity.CourseRelation;
import com.zkw.springboot_project.entity.QueryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理课程的先修后修关系")
@RestController
@RequestMapping("/CourseRelations")
public class CourseRelationController {

    @Autowired
    private final CourseRelationDao courseRelationDao;

    public CourseRelationController(CourseRelationDao courseRelationDao){
        this.courseRelationDao = courseRelationDao;
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

    @ApiOperation(value = "添加课程先修后修关系")
    @PostMapping("/CourseRelation")
    public String addCourseRelation(@RequestBody CourseRelation courseRelation){
        System.out.println(courseRelation);
        int state = courseRelationDao.addCourseRelation(courseRelation);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除课程先修后修关系")
    @DeleteMapping("/CourseRelation")
    public String deleteCourseRelation(String courseid,String relacourseid){
        System.out.println("relacourseid:" + relacourseid);
        int state = courseRelationDao.deleteCourseRelation(courseid,relacourseid);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "获取要更新的课程先修后修关系")
    @GetMapping("/CourseRelationMessage")
    public String getUpdateCourseRelation(String courseid,String relacourseid){
        System.out.println("课程编号:" + courseid + "有关课程编号:" + relacourseid);
        CourseRelation updateCourseRelation = courseRelationDao.getUpdateCourseRelation(courseid,relacourseid);
        String users_json = JSON.toJSONString(updateCourseRelation);
        return users_json;
    }

    @ApiOperation(value = "更新课程先修后修关系")
    @PutMapping("/CourseRelation")
    public String editCourseRelation(@RequestBody CourseRelation courseRelation){
        System.out.println(courseRelation);
        int state = courseRelationDao.editCourseRelation(courseRelation);
        String str = state >0?"success":"error";
        return str;
    }

}
