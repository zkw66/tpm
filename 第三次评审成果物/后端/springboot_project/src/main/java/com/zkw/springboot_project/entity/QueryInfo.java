package com.zkw.springboot_project.entity;

public class QueryInfo {

    private String query;
    private String role;
    private int pageNum=1;
    private int pageSize=4;

    public QueryInfo() {
    }


    public QueryInfo(String query, String role, int pageNum, int pageSize) {
        this.query = query;
        this.role = role;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getQuery() {
        return query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", role='" + role + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
