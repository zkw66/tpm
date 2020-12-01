package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseDetailintro;
import com.zkw.springboot_project.entity.CourseRelation;
import com.zkw.springboot_project.entity.CourseSimpleintro;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSimpleintroDao {

    //获取课程章节的全部详细内容信息
    @Select("SELECT * FROM course_info2 WHERE ways like #{ways} AND courseid like #{courseid} LIMIT #{pageStart},#{pageSize}")
    List<CourseSimpleintro> getAllCourseSimpleintro(@Param("ways") String ways,@Param("courseid") String courseid, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取课程章节的条目数
    @Select("SELECT count(*) FROM course_info2 WHERE courseid like #{courseid}")
    int getCourseSimpleintroCounts(@Param("courseid") String courseid);

    //获取选中的章节的全部详细内容信息
    @Select("SELECT * FROM course_info2 WHERE courseid = #{courseid}")
    CourseSimpleintro getUpdateCourseSimple(@Param("courseid") String courseid);

    //删除该课程的基础内容信息
    @Delete("DELETE FROM course_info2 WHERE courseid = #{courseid}")
    int deleteCourseSimple(@Param("courseid") String courseid);

    //添加课程的基础内容信息
    @Insert("INSERT INTO course_info2 (courseid,weeklytime,totalgoal,coursedes,ways,tests) VALUE (#{courseid},#{weeklytime},#{totalgoal},#{coursedes},#{ways},#{tests})")
    int addCourseSimple(CourseSimpleintro courseSimpleintro);

    //更新该课程的基础内容信息
    @Update("UPDATE course_info2 SET weeklytime = #{weeklytime},totalgoal = #{totalgoal},coursedes = #{coursedes},ways = #{ways},tests = #{tests} WHERE courseid = #{courseid}")
    int editCourseSimple(CourseSimpleintro courseSimpleintro);


}
