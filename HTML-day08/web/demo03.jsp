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
<%
    pageContext.setAttribute("name","sunwukong");
    request.setAttribute("name","zhubajie");
    session.setAttribute("name","baigujing");
    application.setAttribute("name","liumowang");

    //删除4个作用域中所有同名的值
    //pageContext.removeAttribute("name");
    //要删除指定的作用域，需要配置第2个参数: 1,2,3,4
    pageContext.removeAttribute("name",PageContext.PAGE_SCOPE);

%>
<%=pageContext.getAttribute("name")%><br/>
<%=request.getAttribute("name")%><br/>
<%=session.getAttribute("name")%><br/>
<%=application.getAttribute("name")%><br/>
<%=pageContext.findAttribute("name")%><br/>
<hr/>
</body>
</html>
