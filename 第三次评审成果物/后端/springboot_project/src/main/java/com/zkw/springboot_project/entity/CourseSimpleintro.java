package com.zkw.springboot_project.entity;

public class CourseSimpleintro {

    String courseid;
    String username;
    int weeklytime;
    String totalgoal;
    String coursedes;
    String ways;
    String tests;

    public CourseSimpleintro(){

    }

    public CourseSimpleintro(String courseid, String username, int weeklytime, String totalgoal, String coursedes, String ways, String tests) {
        this.courseid = courseid;
        this.username = username;
        this.weeklytime = weeklytime;
        this.totalgoal = totalgoal;
        this.coursedes = coursedes;
        this.ways = ways;
        this.tests = tests;
    }

    public String getWays() {
        return ways;
    }

    public void setWays(String ways) {
        this.ways = ways;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
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

    public int getWeeklytime() {
        return weeklytime;
    }

    public void setWeeklytime(int weeklytime) {
        this.weeklytime = weeklytime;
    }

    public String getTotalgoal() {
        return totalgoal;
    }

    public void setTotalgoal(String totalgoal) {
        this.totalgoal = totalgoal;
    }

    public String getCoursedes() {
        return coursedes;
    }

    public void setCoursedes(String coursedes) {
        this.coursedes = coursedes;
    }

    @Override
    public String toString() {
        return "CourseSimpleintro{" +
                "courseid='" + courseid + '\'' +
                ", username='" + username + '\'' +
                ", weeklytime=" + weeklytime +
                ", totalgoal='" + totalgoal + '\'' +
                ", coursedes='" + coursedes + '\'' +
                ", ways='" + ways + '\'' +
                ", tests='" + tests + '\'' +
                '}';
    }
}
