<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户添加</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->
</head>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            系统管理
            <small>用户添加</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="${pageContext.request.contextPath}/user/findAll.do">用户列表</a></li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!--订单信息-->
        <div class="panel panel-default">
            <div class="panel-heading">用户信息</div>
            <form id="editForm" action="${pageContext.request.contextPath}/user" method="post">
                <div class="row data-type" style="margin: 0px">
                    <div class="col-md-2 title">用户名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="用户名称" name="username">
                    </div>

                    <div class="col-md-2 title">生日</div>
                    <div class="col-md-4 data">
                        <input type="text" id="datepicker" readonly class="form-control" placeholder="生日" name="birthday">
                    </div>

                    <div class="col-md-2 title">性别</div>
                    <div class="col-md-4 data">
                        <div class="form-group form-inline">
                            <div class="radio"><label><input type="radio" name="sex" value="男">男</label></div>
                            <div class="radio"><label><input type="radio" name="sex" value="女">女</label></div>
                        </div>
                    </div>

                    <div class="col-md-2 title">地址</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="地址" name="address">
                    </div>
					

                    <div class="col-md-2 title">部门</div>
                    <div class="col-md-4 data">
                        <select id="selectDept" name="deptId" class="form-control">
                            <option value="0">请选择</option>
                        </select>
                    </div>


                </div>
            </form>
        </div>
        <!--工具栏-->
        <div class="box-tools text-center">
            <button type="button" onclick='document.getElementById("editForm").submit()' class="btn bg-maroon">保存</button>
            <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
        </div>
		
    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->
</body>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<link rel="stylesheet" href="../css/style.css">
<script>
    /*$('#datepicker').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd',
        language: 'zh-CN'
    });*/

    //页面加载完毕以后自动执行
    $(function () {
        let depts = window["depts"];
        alert(depts)
        let html=`<option value="">请选择</option>`;
        //把所有的部门显示在下拉列表中
        for (let dept of depts) {
            //注：js中插值运算与jsp中el有冲突，要将el进行转义，让它失效，在前面添加\就可以
            html+=`<option value="\${dept.deptId}">\${dept.deptName}</option>`;
        }
        //显示在select中
        $("#selectDept").html(html);

    })

    /**
     * 页面加载完的时候加载
     */
    /*$(function () {
      $.get({
          url:"/dept/findAll",
          success:function (depts) {

              alert(JSON.stringify(depts));
              let str = `<option value="0">请选择1</option>`;
               for (let dept of depts) {
                   // \$ 让EL语法失效
                   str += `<option value="\${dept.deptId}}">\${dept.deptName}</option>`
               }
              $("#selectDept").html(str);
          },
          error:function (request) {
                alert("请求错误，错误码："+JSON.stringify(request))
          }
      })
    })*/
</script>
</html>