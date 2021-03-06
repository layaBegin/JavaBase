<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>黑马旅游网-登录</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
<!--引入头部-->
<div id="header"></div>
<%--动态引入 先将header.jsp执行，结果包含进来，会形成2个servlet 文件--%>
<jsp:include page="header.jsp"/>
<!-- 头部 end -->
<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(images/login_bg.png);height: 532px;">

    </div>
    <div class="login-box">
        <div class="title">
            <img src="images/login_logo.png" alt="">
            <span>欢迎登录黑马旅游账户</span>
        </div>
        <div class="login_inner">
            <!--登录错误提示消息-->
            <div id="errorMsg" class="alert alert-warning alert-dismissible">输入用户名和密码</div>
            <form id="loginForm">
                <input type="hidden" name="action" value="login"/>
                <input name="username" type="text" placeholder="请输入账号" autocomplete="off">
                <input name="password" type="password" placeholder="请输入密码" autocomplete="off">
                <div class="verify">
                    <input name="check" type="text" placeholder="请输入验证码" autocomplete="off">
                    <span><img src="code" style="cursor: pointer"></span>
                    <script type="text/javascript">
                    </script>
                </div>
                <div class="submit_btn">
                    <button type="button" id="btnLogin">登录</button>
                    <div class="auto_login">
                        <input type="checkbox" name="" class="checkbox">
                        <span>自动登录</span>
                    </div>
                </div>
            </form>
            <div class="reg">没有账户？<a href="register.html">立即注册</a></div>
        </div>
    </div>
</section>
<!--引入尾部-->
<div id="footer"></div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
<script type="text/javascript">
</script>
</body>

</html>