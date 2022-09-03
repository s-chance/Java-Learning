<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entropy.pojo.User" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/30
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL-foreach标签</title>
</head>
<body>
<%--foreach标签相当于java的for循环--%>
<%--begin开始值,end结束值,var临时变量名,step步长,varStatus循环状态--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}
</c:forEach>
<hr>
<c:forEach begin="1" end="10" var="i" step="3" varStatus="s">
    <%--index索引(默认从0开始),count循环次数(默认从1开始)--%>
    索引:${s.index}-第${s.count}次循环-内容:${i}<br>
</c:forEach>
<hr>
<%
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("acs");
    arrayList.add("ppt");
    arrayList.add("word");
    arrayList.add("excel");
    arrayList.add("office");

    request.setAttribute("list", arrayList);
%>
<%--items容器,var容器元素临时变量名--%>
<c:forEach items="${list}" var="data" varStatus="status">
    索引:${status.index}-第${status.count}次循环-内容:${data}<br>
</c:forEach>
<hr>

<%--综合使用--%>
<h1 align="center">JSTL-遍历实体类数据</h1>
<%
    List list = new ArrayList();
    list.add(new User("zdb", 11, new Date()));
    list.add(new User("mfy", 21, new Date()));
    list.add(new User("lemon", 18, new Date()));
    list.add(new User("luck", 23, new Date()));

    request.setAttribute("dataList", list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>更新时间</th>
    </tr>
    <%--使用foreach标签简化开发--%>
    <c:forEach items="${dataList}" var="user" varStatus="status">
        <%--if标签筛选数据进行处理,这里对数据的背景色进行了不同的处理--%>
        <%--行数为奇数--%>
        <c:if test="${status.count % 2 != 0}">
            <tr style="text-align: center" bgcolor="#7fffd4">
                <td>${status.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.formatTime}</td>
            </tr>
        </c:if>
        <%--行数为偶数--%>
        <c:if test="${status.count % 2 == 0}">
            <tr style="text-align: center" bgcolor="#ff8c00">
                <td>${status.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.formatTime}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
