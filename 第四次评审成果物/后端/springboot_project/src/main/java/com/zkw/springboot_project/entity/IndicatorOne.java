package com.zkw.springboot_project.entity;

public class IndicatorOne {

    int fid;
    String findicname;
    String findicdes;

    public IndicatorOne(){

    }

    public IndicatorOne(int fid, String findicname, String findicdes) {
        this.fid = fid;
        this.findicname = findicname;
        this.findicdes = findicdes;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFindicname() {
        return findicname;
    }

    public void setFindicname(String findicname) {
        this.findicname = findicname;
    }

    public String getFindicdes() {
        return findicdes;
    }

    public void setFindicdes(String findicdes) {
        this.findicdes = findicdes;
    }

    @Override
    public String toString() {
        return "indicatorone{" +
                "fid=" + fid +
                ", findicname='" + findicname + '\'' +
                ", findicdes='" + findicdes + '\'' +
                '}';
    }
}
