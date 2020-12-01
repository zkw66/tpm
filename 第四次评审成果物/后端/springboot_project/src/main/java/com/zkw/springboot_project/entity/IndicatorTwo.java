package com.zkw.springboot_project.entity;

public class IndicatorTwo {

    int fid;
    String sid;
    String sindicname;
    String sindicdes;

    public IndicatorTwo(){

    }

    public IndicatorTwo(int fid, String sid, String sindicname, String sindicdes) {
        this.fid = fid;
        this.sid = sid;
        this.sindicname = sindicname;
        this.sindicdes = sindicdes;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSindicname() {
        return sindicname;
    }

    public void setSindicname(String sindicname) {
        this.sindicname = sindicname;
    }

    public String getSindicdes() {
        return sindicdes;
    }

    public void setSindicdes(String sindicdes) {
        this.sindicdes = sindicdes;
    }

    @Override
    public String toString() {
        return "IndicatorTwo{" +
                "fid=" + fid +
                ", sid='" + sid + '\'' +
                ", sindicname='" + sindicname + '\'' +
                ", sindicdes='" + sindicdes + '\'' +
                '}';
    }
}
