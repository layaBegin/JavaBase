<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/8/2021
  Time: 下午6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- isELEgnored  会让整个EL 表达式都无效--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <script type="text/javascript">
    let m = 1;
    let n =2;
    let result = m + n;
    //js 中${} $ 前需要加上\,否则会被认为是el表达式
    document.write(`\${m} + \${n} = \${result}`)
  </script>
  </body>
</html>
