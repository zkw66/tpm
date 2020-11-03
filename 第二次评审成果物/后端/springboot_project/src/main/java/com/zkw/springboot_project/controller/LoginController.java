package com.zkw.springboot_project.controller;

import com.zkw.springboot_project.dao.UserDao;
import com.zkw.springboot_project.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "登录管理")
public class LoginController {
    private final UserDao userDao;
    @Autowired
    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }
    @PostMapping("/login")
    @ApiOperation(value = "判断用户身份")
    public String login(@RequestBody User user){
        String flag="n";
        user.setPid(userDao.getPid(user.getUsername(),user.getPassword()));
        User us=userDao.UserLogin(user.getUsername(),user.getPassword(),user.getPid());
        if(us!=null){
            flag ="y";
        }
        if(flag.equals("y") && user.getPid().equals("管理员")){
            flag="manager";
        }
        if(flag.equals("y") && user.getPid().equals("课程负责人")){
            flag="teacher";
        }
        if(flag.equals("y") && user.getPid().equals("专业负责人")){
            flag="professor";
        }
        System.out.println(us);
        return flag;
    }
}