package com.zkw.springboot_project.controller;

import com.alibaba.fastjson.JSON;
import com.zkw.springboot_project.dao.UserDao;
import com.zkw.springboot_project.entity.QueryInfo;
import com.zkw.springboot_project.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(description = "管理用户列表")
@RestController
public class UserController {
    private final UserDao userDao;
    @Autowired

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ApiOperation(value = "查询全部用户（分页）")
    @GetMapping("/findallUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        int state = userDao.addUser(user);
        String str = state >0?"success":"error";
        return str;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/deleteUser")
    public String deleteUser(String username){
        System.out.println(username);
        int state = userDao.deleteUser(username);
        String str = state >0?"success":"error";
        return str;
    }


    @ApiOperation(value = "获取要更新的用户名")
    @GetMapping("/getUpdate")
    public String getUpdateUser(String username){
        System.out.println("用户名:"+username);
        User updateUser = userDao.getUpdateUser(username);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }


    @ApiOperation(value = "更新用户信息")
    @PutMapping("/updateUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int state = userDao.editUser(user);
        String str = state >0?"success":"error";
        return str;
    }
}
