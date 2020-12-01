package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.CourseBook;
import com.zkw.springboot_project.entity.CourseRelation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseBookDao {

    //获取课程书目内容信息
    @Select("SELECT * FROM course_book WHERE bookname like #{bookname} AND courseid like #{courseid} LIMIT #{pageStart},#{pageSize}")
    List<CourseBook> getAllCourseBook(@Param("bookname") String bookname,@Param("courseid") String courseid, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取课程总书目条目数
    @Select("SELECT count(*) FROM course_book WHERE courseid like #{courseid}")
    int getCourseBookCounts(@Param("courseid") String courseid);

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
