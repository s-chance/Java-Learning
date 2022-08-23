<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/23
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp交互端</title>
</head>
<body>
<ul>
    <li>第一个参数</li>
    <%
        String s1 = request.getParameter("a");
        int a = Integer.parseInt(s1);
        out.println(a);
    %>
    <li>第二个参数</li>
    <%
        String s2 = request.getParameter("b");
        int b = Integer.parseInt(s2);
        out.println(b);
    %>
    <li>参数之和</li>
    <%
        out.println(a + b);
    %>
</ul>
</body>
</html>
