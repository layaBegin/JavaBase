<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/8/2021
  Time: 下午6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
    <form action="login" method="post">
      登录名：<input type="text" name="username">${msg}<br>
      密码：<input type="password" name="password"><br>
      <input type="submit" value="登录">
    </form>
  </body>
</html>
