<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,factory-scalable=no" name="viewport">
</head>

<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
<section class="content-header">
    <h1>
        系统管理
        <small>用户列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
    </ol>
</section>
<section class="content">
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">用户列表</h3>
        </div>
        <div class="box-body">
            <div class="table-box">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default" title="添加" onclick=onClickAdd()>
                                <i class="fa fa-file-o"></i> 添加
                            </button>

                            <button type="button" class="btn btn-default" title="删除" onclick="deleteUser()">
                                <i class="fa fa-file-o"></i> 删除
                            </button>
                        </div>
                    </div>
                </div>
                <div class="box-tools pull-right">
                    <div class="has-feedback">
                        <input type="text" class="form-control input-sm" placeholder="搜索">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </div>
                <table id="dataList" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="sorting">选择</th>
                        <th class="sorting">账户ID</th>
                        <th class="sorting">用户名称</th>
                        <th class="sorting">用户生日</th>
                        <th class="sorting">性别</th>
                        <th class="sorting">地址</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="row">
                        <tr>
                            <td><input type="radio" name="userId" value="${user.id}"></td>
                            <td>${row.count}</td>
                            <td>${user.username}</td>
                            <td>${user.birthday}</td>
                            <td>${user.sex}</td>
                            <td>${user.address}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="box-footer">
        </div>
    </div>

</section>
</div>

<script>
    $(function () {

    })
    function deleteUser() {
        //属性选择器，获取所有选中的单选框,返回一个数组，如果长度为0
        let length = $("[name=userId]:checked").length;
        if  (length <= 0){
            alert("请选中要删除的用户")
        }else {
            let id = $("[name=userId]:checked").val();

            if (confirm("真的要删除这个用户吗？")){
                alert("id是："+id);
                $.ajax({
                    url:"user/"+id,
                    method:"delete",
                    success:function (result) {
                        if (result > 0){
                            //location.reload();
                        }else {
                            alert("删除失败")
                        }
                    },
                    error:function (request) {
                        alert("删除失败，错误码：" + request.status)
                    }
                })
            }
        }

    }

    function onClickAdd() {
        $.get({
            url:"/dept/findAll",  //访问地址
            success: function (depts) {  //返回所有部门
                window["depts"] = depts;
                location.href="pages/user-add.jsp"

            },
            error:function (request) {
                alert("请求findAll错误，错误码："+JSON.stringify(request))
            }
        });
    }
</script>
</body>

</html>