package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseDetailintro;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailintroDao {

    //获取课程详细内容信息
    @Select("SELECT * FROM course_infodetails WHERE ord like #{ord} AND courseid like #{courseid} LIMIT #{pageStart},#{pageSize}")
    List<CourseDetailintro> getAllCourseDetail(@Param("ord") String ord,@Param("courseid") String courseid,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取课程详细内容条目数
    @Select("SELECT count(*) FROM course_infodetails WHERE courseid like #{courseid}")
    int getCourseDetailCounts(@Param("courseid") String courseid);

    //获取选中的章节的全部详细内容信息
    @Select("SELECT * FROM course_infodetails WHERE courseid = #{courseid} AND ord = #{ord}")
    CourseDetailintro getUpdateCourseDetail(@Param("courseid") String courseid,@Param("ord") int ord);

    //添加课程详细内容信息
    @Insert("INSERT INTO course_infodetails (courseid,ord,coursedata,coursetime,goal,secondindicid) VALUE (#{courseid},#{ord},#{coursedata},#{coursetime},#{goal},#{secondindicid})")
    int addCourseDetail(CourseDetailintro courseDetailintro);

    //删除课程选中章节详细内容
    @Delete("DELETE FROM course_infodetails WHERE courseid = #{courseid} AND ord = #{ord}")
    int deleteCourseDetail(@Param("courseid") String courseid,@Param("ord") int ord);

    //根据章节编号更新课程基本信息
    @Update("UPDATE course_infodetails SET ord = #{ord},coursedata = #{coursedata},coursetime = #{coursetime},goal = #{goal},secondindicid = #{secondindicid} WHERE courseid = #{courseid} AND ord = #{ord}")
    int editCourseDetail(CourseDetailintro courseDetailintro);

}
