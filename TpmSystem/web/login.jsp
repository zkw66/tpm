<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/10/13
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript">
    function pan(){
        var uname = document.form1.uname.value;
        var password = document.form1.pas.value;
        if(uname == ""||password == ""){
            alert("用户名或密码不能为空！");
            return false;
        }
        return true;
    }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <meta name="keywords" content="轻量级培养方案管理系统-->登录" />
    <meta name="description" content="轻量级培养方案管理系统-->登录" />
    <link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="whole">
    <div class="topall">
        <div class="top">
            <div class="tit"><img alt="图片无法显示" src="image/tit.png" width="500" height="85" /> </div>
            <div class="phone">
                联系电话：<span>003-88888888</span>
            </div>
        </div>
    </div>
    <div class="nav">
        <ul>
            <li><a href="index.jsp" title="">网站首页</a></li>
            <li><a href="pei.jsp" title="">培养方案</a></li>
            <li><a href="gang.jsp" title="">课程大纲</a></li>
            <li><a href="login.jsp" title="">用户登录</a></li>
        </ul>
    </div>
    <div class="latest"><br><br><br><br><br><br>
        <font size="7">登录界面</font><br><br><br><br>
        <form action = "DoLogin" method = "post" name = "form1" onsubmit = "return pan()">
            <p><label><font size = "5">用户名：</font></label><input type = "text" name = "uname" style="height:30px;width:200px"></p><br><br>
            <p>&nbsp;&nbsp;<label><font size = "5">密码：</font></label><input type = "password" name = "pas" style="height:30px;width:200px"></p><br><br>&nbsp;&nbsp;&nbsp;
            <input type = "submit" value = "登录" style="font-size:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value = "取消" style="font-size:20px">
        </form>
    </div>
</div>
</body>
</html>
