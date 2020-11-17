package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseSimpleintro;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSimpleintroDao {

    //查询该课程的基础内容信息
    @Select("SELECT * FROM course_info2 WHERE courseid = #{courseid}")
    CourseSimpleintro getUpdateCourseSimple(@Param("courseid") String courseid);

    //删除该课程的基础内容信息
    @Delete("DELETE FROM course_info2 WHERE courseid = #{courseid}")
    int deleteCourseSimple(@Param("courseid") String courseid);

    //添加课程的基础内容信息
    @Insert("INSERT INTO course_info2 (courseid,username,weeklytime,totalgoal,coursedes,ways,tests) VALUE (#{courseid},#{username},#{weeklytime},#{totalgoal},#{coursedes},#{ways},#{tests})")
    int addCourseSimple(CourseSimpleintro courseSimpleintro);

    //更新该课程的基础内容信息
    @Update("UPDATE course_info2 SET weeklytime = #{weeklytime},totalgoal = #{totalgoal},coursedes = #{coursedes},ways = #{ways},tests = #{tests} WHERE courseid = #{courseid}")
    int editCourseSimple(CourseSimpleintro courseSimpleintro);


}
