<%@ page import="org.daistudy.web.hellomvc.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 60056306
  Date: 2020/6/4
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Hello World - JSP</title>
</head>
<body>
    <h1>Hello <%= user.getName() %>!</h1>
    <p>School Name:
        <span style="color:red">
            <%= user.getSchool().getName() %>
        </span>
    </p>
    <p>School Address:
        <span style="color:red">
            <%= user.getSchool().getAddress() %>
        </span>
    </p>
</body>
</html>
