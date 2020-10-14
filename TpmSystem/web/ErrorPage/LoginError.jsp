<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/10/7
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<center>
    <head>
        <title>登录错误提示</title>
    </head>
    <body>
    <%
        request.setCharacterEncoding("utf-8");
        String errora = (String)session.getAttribute("errora");
        out.print("<font size = 5>登录失败！</font><br><br>");
        out.print("失败原因：" + errora + "<br><br>");
    %>
    <a href="../login.jsp">重新登录</a>
    </body>
</center>
</html>
