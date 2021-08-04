<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/8/2021
  Time: 下午12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>当前在线人数</title>
  </head>
  <body>
  <%
    /*application.setAttribute("user1","孙悟空");
    application.setAttribute("user1","猪八戒");
    application.removeAttribute("user1");*/

  %>
  <h2>当前在线人数是${applicationScope.count}</h2>
  <a href="logout.jsp">退出</a>
  </body>
</html>
