<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/8/2021
  Time: 下午1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         errorPage="error.jsp"
         session="true"
         isELIgnored="false"
%>
<html>
<head>
    <title>page指令</title>
</head>
<body>
<%
    out.print(new Date() + "<br/>");
    out.print(new Timestamp(System.currentTimeMillis()) + "<br/>");
    //out.print(1/0);
    String id = session.getId();
    out.print(id);
%>
EL表达式：${5/2}
</body>
</html>
