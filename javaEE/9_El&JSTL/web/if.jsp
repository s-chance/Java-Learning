<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/30
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL-if标签</title>
</head>
<body>
<%
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("str");
    request.setAttribute("list", arrayList);

    request.setAttribute("num", 8);
%>
<%--if标签和java不一样,没有else的说法,但可以再定义一个if标签来实现相同的逻辑--%>
<%--判断request域中的list集合是否为空,为空则输出标签里的内容--%>
<%--test为必须属性,且test的属性值必须为布尔类型,即EL表达式的返回值必须是布尔类型--%>
<c:if test="${empty list}">
    集合为空
</c:if>
<%--判断集合是否不为空,不为空则输出标签里的内容--%>
<c:if test="${not empty list}">
    集合不为空
</c:if>
<hr>
<c:if test="${num % 2 == 0}">
    ${num}为偶数
</c:if>
<c:if test="${num % 2 != 0}">
    ${num}为奇数
</c:if>
</body>
</html>
