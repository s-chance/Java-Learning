<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/26
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<html>
<head>
    <title>JSP进阶-page指令</title>
</head>
<body>
<%--page指令指定异常跳转页面errorPage="500.jsp"--%>
<%--手动制造异常--%>
<%
    int num = 2/0;
%>
</body>
</html>
