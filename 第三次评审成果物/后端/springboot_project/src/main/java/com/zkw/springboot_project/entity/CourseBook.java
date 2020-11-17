package com.zkw.springboot_project.entity;

public class CourseBook {

    String courseid;
    String types;
    String author;
    String bookname;
    String press;
    String presstime;

    public  CourseBook(){

    }

    public CourseBook(String courseid, String types, String author, String bookname, String press, String presstime) {
        this.courseid = courseid;
        this.types = types;
        this.author = author;
        this.bookname = bookname;
        this.press = press;
        this.presstime = presstime;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPresstime() {
        return presstime;
    }

    public void setPresstime(String presstime) {
        this.presstime = presstime;
    }

    @Override
    public String toString() {
        return "CourseBook{" +
                "courseid='" + courseid + '\'' +
                ", types='" + types + '\'' +
                ", author='" + author + '\'' +
                ", bookname='" + bookname + '\'' +
                ", press='" + press + '\'' +
                ", presstime='" + presstime + '\'' +
                '}';
    }
}
