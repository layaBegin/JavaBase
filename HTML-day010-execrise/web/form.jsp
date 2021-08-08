
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>表格查询</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


</head>
<body>
<div class="container" style="max-width: 400px">
    <h2>添加联系人</h2>
    <form action="add" method="post" id="contactForm">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" name="name" id="name" class="form-control" placeholder="请输入姓名"/>
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <input type="text" name="sex" id="sex" class="form-control" placeholder="请输入性别"/>
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" name="age" id="age"  class="form-control" placeholder="请输入年龄"/>
        </div>
        <div class="form-group">
            <label for="county">籍贯</label>
            <input type="text" name="county" id="county"  class="form-control" placeholder="请输入籍贯"/>
        </div>
        <div class="form-group">
            <label for="qq">qq</label>
            <input type="text" name="qq" id="qq"  class="form-control" placeholder="请输入qq"/>
        </div>
        <div class="form-group">
            <label for="mail">邮箱</label>
            <input type="text" name="mail" id="mail"  class="form-control" placeholder="请输入邮箱"/>
        </div>

        <div style="text-align: center;">
            <input type="submit" value="添加" class="btn btn-success"/>
            <input type="button" value="重置" class="btn btn-success" onclick="onClickReset()"/>
            <a href="index.jsp">返回</a>
        </div>
    </form>
</div>

<script type="text/javascript">
    function onClickReset() {
        let name = document.getElementById("name");
        name.value = "";
        let age = document.getElementById("age");
        age.value = "";
        let sex = document.getElementById("sex");
        sex.value = "";
        let county = document.getElementById("county");
        county.value = "";
        let qq = document.getElementById("qq");
        qq.value = "";
        let mail = document.getElementById("mail");
        mail.value = "";
    }
</script>
</body>
</html>