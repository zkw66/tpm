package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    //课程基础信息部分
    //通过课程名模糊查询课程基础信息
    @Select("SELECT courseid,username,cname,points,period,theory,practice,major,attribute FROM course_info1 WHERE courseid like #{courseid} AND username like #{username} LIMIT #{pageStart},#{pageSize}")
    List<Course> getAllCourseBase(@Param("courseid") String courseid,@Param("username") String username,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取该课程负责人负责的课程条目数
    @Select("SELECT count(*) FROM course_info1 WHERE courseid like #{courseid} AND username like #{username}")
    int getCourseCounts(@Param("courseid") String courseid,@Param("username") String username);

    //添加课程基础信息
    @Insert("INSERT INTO course_info1 (courseid,cname,points,period,theory,practice,major,username,attribute) VALUE (#{courseid},#{cname},#{points},#{period},#{theory},#{practice},#{major},#{username},#{attribute})")
    int addCourseBase(Course course);

    //删除课程
    @Delete("DELETE FROM course_info1 WHERE courseid = #{courseid}")
    int deleteCourse(@Param("courseid") String courseid);

    //获取选中的课程的全部基本信息
    @Select("SELECT courseid,username,cname,points,period,theory,practice,major FROM course_info1 WHERE courseid = #{courseid}")
    Course getUpdateCourse(@Param("courseid") String courseid);

    //根据课程id更新课程基本信息
    @Update("UPDATE course_info1 SET points=#{points},period=#{period},theory=#{theory},practice=#{practice},major=#{major} WHERE courseid = #{courseid}")
    int editCourse(Course course);


}
