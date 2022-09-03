<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/26
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>JSP进阶-taglib指令</title>
</head>
<body>
<%
    pageContext.setAttribute("msg", "pageContext共享数据");
%>

<%=pageContext.getAttribute("msg")%>
</body>
</html>
