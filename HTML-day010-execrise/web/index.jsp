<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/8/2021
  Time: 下午10:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>

  <jsp:forward page="/contact">
    <jsp:param name="currentPage" value="1"/>
    <jsp:param name="size" value="5"/>
  </jsp:forward>>
  </body>
</html>
