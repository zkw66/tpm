package com.zkw.springboot_project.entity;

public class Course {

    String courseid;
    String username;
    String attribute;
    String cname;
    String points;
    int period,theory,practice,state;
    String major;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Course(){

    }


    public Course(String courseid, String username, String attribute, String cname, String points, int period, int theory, int practice, int state, String major) {
        this.courseid = courseid;
        this.username = username;
        this.attribute = attribute;
        this.cname = cname;
        this.points = points;
        this.period = period;
        this.theory = theory;
        this.practice = practice;
        this.state = state;
        this.major = major;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", username='" + username + '\'' +
                ", attribute='" + attribute + '\'' +
                ", cname='" + cname + '\'' +
                ", points='" + points + '\'' +
                ", period=" + period +
                ", theory=" + theory +
                ", practice=" + practice +
                ", state=" + state +
                ", major='" + major + '\'' +
                '}';
    }

}
