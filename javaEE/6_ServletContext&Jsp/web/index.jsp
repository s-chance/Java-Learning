<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/26
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP基础回顾</title>
  </head>
  <body>
  <!--java代码块-->
  <% out.println("java代码块"); %>
  <hr>
  <!--jsp表达式-->
  <%="这是jsp表达式"%>
  <hr>
  <!--jsp声明-->
  <%--需要注意的是<%!...%>是全局范围--%>
  <%!
    //需要注意的是这里是全局声明
    String str = "语法格式";
  %>
  <%=str%>
  <hr>

  <%--System.out.println是输出到后端,区别于out.println输出到前端--%>
  <% System.out.println("hello jsp"); %>
  <%!
    int num = 2;
  %>
  <%=num%>
  <%="hello"%>

  </body>
</html>
