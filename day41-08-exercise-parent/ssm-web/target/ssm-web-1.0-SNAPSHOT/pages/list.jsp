<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查询所有联系人</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        tr, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h3>用户和订单列表</h3>
        </div>

        <div class="col-md-8">
            <form action="/order/find" method="post">
                <div class="input-group" style="padding-top: 15px">
                    <div class="input-group">
                        <input type="text" id="address" name="address" class="form-control" placeholder="输入查询的地址">
                        <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit">查询订单</button>
                      </span>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table border="1" class="table table-striped table-bordered table-hover table-condensed">
                <tr class="info">
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>金额</th>
                </tr>
                <c:forEach items="${orderList}" var="order" varStatus="row">
                    <tr>
                        <td>${row.count}</td>
                        <td>${order.user.name}</td>
                        <td>${order.user.sex}</td>
                        <td>${order.user.phone}</td>
                        <td>${order.address}</td>
                        <td>${order.total}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</div>

</div>
</body>
<script type="text/javascript">
</script>

</html>
