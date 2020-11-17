package com.zkw.springboot_project.dao;

import com.zkw.springboot_project.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //获取前端传递的username,password以及pid并在数据库中查询
    @Select("SELECT * FROM userinfo WHERE username=#{username} AND password=#{password} AND pid=#{pid}")
    User UserLogin(@Param("username") String username, @Param("password") String password, @Param("pid") String pid);

    //通过用户名模糊查询用户信息
    @Select("SELECT * FROM userinfo WHERE username like #{username} LIMIT #{pageStart},#{pageSize}")
    List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取用户条目数
    @Select("SELECT count(*) FROM userinfo WHERE username like #{username}")
    int getUserCounts(@Param("username") String username);

    //添加用户
    @Insert("INSERT INTO userinfo (username,password,pid,memorandum) VALUE (#{username},#{password},#{pid},#{memorandum})")
    int addUser(User user);

    //删除用户
    @Delete("DELETE FROM userinfo WHERE username = #{username}")
    int deleteUser(@Param("username")String username);

    //
    @Select("SELECT * FROM userinfo WHERE username = #{username}")
    User getUpdateUser(@Param("username")String username);

    //查询输入正确用户名密码的用户身份
    @Select("SELECT pid FROM userinfo WHERE username=#{username} AND password=#{password}")
    String getPid(@Param("username") String username, @Param("password") String password);

    //根据用户名更新用户
    @Update("UPDATE userinfo SET password=#{password} ,memorandum=#{memorandum} WHERE username=#{username}")
    int editUser(User user);


}
