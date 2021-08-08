<%@ taglib prefix="abc" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/8/2021
  Time: 下午6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>遍历</title>
    <style>
        table{
            width: 500px;
            border-collapse: collapse;
        }
        tr{
            height: 30px;
            text-align:  center;
        }
        tr:hover{
            background-color: darkseagreen;
        }
    </style>
</head>
<body>
<table border="1" >
    <tr>
        <th>序号</th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>成绩</th>
    </tr>
    <%--
    要先访问Servlet，直接访问JSP没有效果
    forEach的属性
    var：变量名，放在页面域中，表示集合中每个元素
    items：要使用EL表达式，指定需要遍历的集合或数组
    varStatus：变量名，放在页面域中，代表当前行的对象，有以下四个属性
        count：这是第几个，从1开始
        index：索引号，从0开始
        first：如果是第一个元素，返回true，否则返回false
        last：如果是最后一个元素，返回true，否则返回false
    --%>
    <abc:forEach var="student" items="${studentList}" varStatus="row">
        <tr>
            <td>${row.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender?"男":"女"}</td>
            <td>${student.score}</td>
        </tr>
    </abc:forEach>
</table>
</body>
</html>
