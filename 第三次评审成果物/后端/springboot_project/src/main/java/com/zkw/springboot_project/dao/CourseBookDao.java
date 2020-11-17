package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseBook;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseBookDao {

    //获取所有该课程的教材和参考书目
    @Select("SELECT * FROM course_book WHERE courseid = #{courseid}")
    List<CourseBook> getAllCourseBook(@Param("courseid") String courseid);

    //获取选中的书目的全部内容信息
    @Select("SELECT * FROM course_book WHERE courseid = #{courseid} AND bookname = #{bookname}")
    CourseBook getUpdateCourseBook(@Param("courseid") String courseid,@Param("bookname") String bookname);

    //添加教材或参考书目
    @Insert("INSERT INTO course_book (courseid,types,author,bookname,press,presstime) VALUE (#{courseid},#{types},#{author},#{bookname},#{press},#{presstime})")
    int addCourseBook(CourseBook courseBook);

    //删除教材或参考书目
    @Delete("DELETE FROM course_book WHERE courseid = #{courseid} AND bookname = #{bookname}")
    int deleteCourseBook(@Param("courseid") String courseid,@Param("bookname") String bookname);

    //根据教材名称更新书目
    @Update("UPDATE course_book SET types = #{types},author = #{author},bookname = #{bookname},press = #{press},presstime = #{presstime} WHERE courseid = #{courseid} AND bookname = #{bookname}")
    int editCourseBook(CourseBook courseBook);

}
