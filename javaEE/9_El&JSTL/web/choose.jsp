<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/30
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL-choose标签</title>
</head>
<body>

<%
    request.setAttribute("day", 4);
%>

<%--choose标签相当于java中的switch关键字--%>
<%--when标签,专门与choose配合使用,相当于case关键字--%>
<%--otherwise标签,也是只能用在choose中,相当于default关键字--%>
<c:choose>
    <c:when test="${day == 1}">Monday</c:when>
    <c:when test="${day == 2}">Tuesday</c:when>
    <c:when test="${day == 3}">Wednesday</c:when>
    <c:when test="${day == 4}">Thursday</c:when>
    <c:when test="${day == 5}">Friday</c:when>
    <c:when test="${day == 6}">Saturday</c:when>
    <c:when test="${day == 7}">Sunday</c:when>
    <c:otherwise>Maybe there is a mistake...</c:otherwise>
</c:choose>
</body>
</html>
