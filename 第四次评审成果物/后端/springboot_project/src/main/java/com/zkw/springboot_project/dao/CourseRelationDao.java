package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseDetailintro;
import com.zkw.springboot_project.entity.CourseRelation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRelationDao {

    //获取课程先修/后修内容信息
    @Select("SELECT * FROM course_relation WHERE relacname like #{relacname} AND courseid like #{courseid} LIMIT #{pageStart},#{pageSize}")
    List<CourseRelation> getAllCourseRelation(@Param("relacname") String relacname,@Param("courseid") String courseid, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取课程先修/后修条目数
    @Select("SELECT count(*) FROM course_relation WHERE courseid like #{courseid}")
    int getCourseRelationCounts(@Param("courseid") String courseid);

    //获取选中先修/后修的全部内容信息
    @Select("SELECT * FROM course_relation WHERE courseid = #{courseid} AND relacourseid = #{relacourseid}")
    CourseRelation getUpdateCourseRelation(@Param("courseid") String courseid,@Param("relacourseid") String relacourseid);

    //添加先修/后修的课程
    @Insert("INSERT INTO course_relation (courseid,coursetype,relacourseid,relacname) VALUE (#{courseid},#{coursetype},#{relacourseid},#{relacname})")
    int addCourseRelation(CourseRelation courseRelation);

    //删除先修/后修的课程
    @Delete("DELETE FROM course_relation WHERE courseid = #{courseid} AND relacourseid = #{relacourseid}")
    int deleteCourseRelation(@Param("courseid") String courseid,@Param("relacourseid") String relacourseid);

    //根据先修/后修的课程id更新该课程
    @Update("UPDATE course_relation SET coursetype = #{coursetype},relacname = #{relacname} WHERE courseid = #{courseid} AND relacourseid = #{relacourseid}")
    int editCourseRelation(CourseRelation courseRelation);
}
