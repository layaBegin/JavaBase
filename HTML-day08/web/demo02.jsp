<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/8/2021
  Time: 下午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%--<h1>
    代码片段
</h1>
<ol>
<%
    String[] strArr = {"孙悟空","沙和尚","猪八戒"};
    for (String name : strArr) {
        out.println("<li>" + name + "</li>");
    }
%>
</ol>--%>
<%--<h1>
    表达式
</h1>

<%
    int m = 3;
%>
<%=m%>--%>
<h2>成员变量的申明</h2>
<%
    String name = "猪八戒";
%>
<%--  !声明的为类的成员变量   --%>
<%!

    String name = "changge";
%>
<%=name%>
<%=this.name%>
</body>
</html>
