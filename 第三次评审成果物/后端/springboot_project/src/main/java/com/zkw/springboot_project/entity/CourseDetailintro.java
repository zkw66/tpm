package com.zkw.springboot_project.entity;

public class CourseDetailintro {

    String courseid;
    String username;
    int ord;
    String coursedata;
    int coursetime;
    String goal;
    String secondindicid;

    public CourseDetailintro(){

    }

    public CourseDetailintro(String courseid, String username, int ord, String coursedata, int coursetime, String goal, String secondindicid) {
        this.courseid = courseid;
        this.username = username;
        this.ord = ord;
        this.coursedata = coursedata;
        this.coursetime = coursetime;
        this.goal = goal;
        this.secondindicid = secondindicid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public String getCoursedata() {
        return coursedata;
    }

    public void setCoursedata(String coursedata) {
        this.coursedata = coursedata;
    }

    public int getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(int coursetime) {
        this.coursetime = coursetime;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSecondindicid() {
        return secondindicid;
    }

    public void setSecondindicid(String secondindicid) {
        this.secondindicid = secondindicid;
    }

    @Override
    public String toString() {
        return "CourseDetailintro{" +
                "courseid='" + courseid + '\'' +
                ", username='" + username + '\'' +
                ", ord=" + ord +
                ", coursedata='" + coursedata + '\'' +
                ", coursetime=" + coursetime +
                ", goal='" + goal + '\'' +
                ", secondindicid='" + secondindicid + '\'' +
                '}';
    }
}
