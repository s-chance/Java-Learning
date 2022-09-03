<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/28
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>欢迎<%=request.getSession().getAttribute("username")%>的到来</h1>
</body>
</html>
