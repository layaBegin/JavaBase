<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/8/2021
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
<%
    session.invalidate();
%>
<h2>您已退出，当前在线人数是${applicationScope.count}</h2>
</body>
</html>
