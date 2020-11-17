package com.zkw.springboot_project.entity;

public class CourseRelation {

    String courseid;
    String coursetype;
    String relacourseid;
    String relacname;

    public  CourseRelation(){

    }

    public CourseRelation(String courseid, String coursetype, String relacourseid, String relacname) {
        this.courseid = courseid;
        this.coursetype = coursetype;
        this.relacourseid = relacourseid;
        this.relacname = relacname;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getRelacourseid() {
        return relacourseid;
    }

    public void setRelacourseid(String relacourseid) {
        this.relacourseid = relacourseid;
    }

    public String getRelacname() {
        return relacname;
    }

    public void setRelacname(String relacname) {
        this.relacname = relacname;
    }

    @Override
    public String toString() {
        return "CourseRelation{" +
                "courseid='" + courseid + '\'' +
                ", coursetype='" + coursetype + '\'' +
                ", relacourseid='" + relacourseid + '\'' +
                ", relacname='" + relacname + '\'' +
                '}';
    }
}
