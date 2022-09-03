<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/9/2
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload = function () {
            document.getElementById("codeImg").onclick = function () {
                this.src = "${pageContext.request.contextPath}/verify?"+new Date().getTime();
            }
        }
    </script>
    <style>
        label {
            width: 100px;
            text-align: right;
            display: inline-block;
        }
    </style>
</head>
<body>
<div align="center">
    <form action="login" method="post">
        <label for="name">用户名</label>
        <input id="name" type="text" name="name" placeholder="请输入用户名"><br>
        <label for="password">密码</label>
        <input id="password" type="password" name="password" placeholder="请输入密码"><br>
        <label for="verifyCode">验证码</label>
        <input id="verifyCode" type="text" name="verifyCode" placeholder="请输入验证码"><br>
        <img id="codeImg" src="verify"><br>
        <input type="submit" value="提交">
    </form>

    <div>
        ${msg}
    </div>
</div>

</body>
</html>
