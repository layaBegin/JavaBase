<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/8/2021
  Time: 下午7:35
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
您已退出<a href="../index.jsp">重新登录</a>
</body>
</html>
