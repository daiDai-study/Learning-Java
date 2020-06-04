<%--
  Created by IntelliJ IDEA.
  User: 60056306
  Date: 2020/6/4
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>Hello World - JSP</title>
</head>
<body>
<%@include file="header.jsp"%>

<%-- 这是一个注释 --%>
<h1>Hello World!</h1>
<h1>你好!</h1>
<p>
    <%
        out.println("Your IP address is");
    %>
    <span style="color: red">
        <%= request.getRemoteAddr() %>
    </span>
</p>
<p>
    <%
        final List<Integer> integers = Arrays.asList(1, 2, 3);
        out.println(integers);
    %>
</p>
<%@include file="footer.jsp"%>
</body>
</html>
