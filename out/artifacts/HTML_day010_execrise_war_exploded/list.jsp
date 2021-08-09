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
            <abc:forEach items="${pageBean.data}" var="contcat" varStatus="row">
                <tr>
                    <td>${row.count + pageBean.currentPage * pageBean.size - pageBean.size}</td>
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
    <form action="contact" method="post" id="contactForm">
        <!--    页脚-->
        <div class="row text-center">
            <div class="btn-group btn-group-sm">
                <a href="javascript: jumpPage('${pageBean.firstPage}','${pageBean.size}')" class="btn btn-default">首页</a>
                <a href="javascript: jumpPage('${pageBean.previousPage}','${pageBean.size}')" class="btn btn-default">上页</a>
                <a href="javascript: jumpPage('${pageBean.nextPage}','${pageBean.size}')" class="btn btn-default">下页</a>
                <a href="javascript: jumpPage('${pageBean.totalPage}','${pageBean.size}')" class="btn btn-default">末页</a>
            </div>

            每页
            <input type="number" class="form-control" name="size" style="width: 60px;" id="size" value="${pageBean.size}"/>
            条

            第
            <select id="currentPage" class="form-control" name="currentPage">
                <%--显示所有页数--%>
                <abc:forEach var="num" begin="${pageBean.firstPage}" end="${pageBean.totalPage}">
                    <%--如果当前页等于num，就选中--%>
                    <option value="${num}" ${pageBean.currentPage==num?'selected="selected"':''}>${num}</option>
                </abc:forEach>
            </select>
            页/共${pageBean.totalPage}页 共${pageBean.totalCount}条
    </form>

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
    function jumpPage(page,size) {
        location.href = "contact?currentPage=" + page + "&size=" + size
    }

    window.onload = function () {
        document.getElementById("size").onchange =  function () {
            document.getElementById("contactForm").submit();
        }
        document.getElementById("currentPage").onchange =  function () {
            document.getElementById("contactForm").submit();
        }
    }
</script>

</body>
</html>
