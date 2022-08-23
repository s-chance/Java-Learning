<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/20
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  计算结果：
  <%
    int a = 4, b = 5;
    int result = a + b;
  %>
  <%=result%>
  <br>
  <%!
    String formatDate(Date date) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return sdf.format(date);
    }
  %>
  今天是
  <%=formatDate(new Date())%>
  <!--html注释,客户端可见-->
  <%--jsp注释,客户端不可见--%>


  </body>
</html>
