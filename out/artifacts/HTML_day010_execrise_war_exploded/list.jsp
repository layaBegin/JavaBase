<%@ taglib prefix="abc" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/8/2021
  Time: 下午6:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表格</title>
    <style>
        table{
            border-collapse: collapse;
            width: 700px;
            cellpadding:10px;
            cellspacing:0px;
        }
    </style>

</head>
<body>
<div align="center">
    <a style="background-color: forestgreen " href="form.jsp" >点击添加联系人</a><br/>
</div>
<div align="center" padding-top="100" >
    <form action="contact" method="post">
        <table border="1">

            <tr bgcolor="#8fbc8f">
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <abc:forEach items="${allContacts}" var="contcat">
                <tr>
                    <td>${contcat.id}</td>
                    <td>${contcat.name}</td>
                    <td>${contcat.sex}</td>
                    <td>${contcat.age}</td>
                    <td>${contcat.county}</td>
                    <td>${contcat.qq}</td>
                    <td>${contcat.mail}</td>
                    <td>
                        <a id = "update" href="javascript:onClickUpdate(${contcat.id})" >修改</a>
                        <a href="javascript:deleteContact('${contcat.id}','${contcat.name}')">删除</a>
                    </td>
                </tr>
            </abc:forEach>

        </table>

    </form>
</div>
<div align="center">
    <!--    页脚-->
    <input type="button" value="首页" onclick="onClickFisrtPage()">

</div>
<script type="text/javascript">
    function onClickUpdate(id) {
        //错误示范，千万不要有/,否则会跳到html 而不是servlet
        //location.href = "/update?id=" + id;
        location.href = "query?id=" + id;
    }

    function deleteContact(id,name) {
        if (confirm("真的要删除" + name + "吗？")) {
            location.href="delete?id="+ id;
        }
    }
</script>

</body>
</html>
