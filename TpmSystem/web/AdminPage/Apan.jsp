<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/10/6
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String uname = (String)session.getAttribute("uname");
        if(uname == null){
            response.sendRedirect("../index.jsp");
        }
        else{
            String p = uname.substring(0,1);
            if(!p.equals("A")){
                response.sendRedirect("../index.jsp");
            }
        }
    %>
</body>
</html>