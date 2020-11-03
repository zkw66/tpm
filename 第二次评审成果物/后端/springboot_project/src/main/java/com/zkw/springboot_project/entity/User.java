package com.zkw.springboot_project.entity;

public class User {

    private String username;
    private String password;
    private String pid;
    private int state;
    private String memorandum;


    public User() {
    }

    public User(String username, String password, String pid, int state,String memorandum) {
        this.username = username;
        this.password = password;
        this.pid = pid;
        this.state = state;
        this.memorandum=memorandum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getState() {
        return state;
    }

    public void setStates(int state) {
        this.state = state;
    }


    public String getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(String memorandum) {
        this.memorandum = memorandum;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pid='" + pid + '\'' +
                ", state=" + state +
                ", memorandum='" + memorandum + '\'' +
                '}';
    }
}
