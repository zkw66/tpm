<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/10/6
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.invalidate();
        response.sendRedirect("index.jsp");
    %>
</body>
</html>
