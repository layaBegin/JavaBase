<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/8/2021
  Time: 下午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>HELLO</title>
    <style>
        h1{
            background-color: darkseagreen;
            border: 1px dashed red;
        }
    </style>
</head>
<body>
<h1>
    <%
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = sd.format(date);
        out.println(format);
    %>
</h1>
</body>
</html>
