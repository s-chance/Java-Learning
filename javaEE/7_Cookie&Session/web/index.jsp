<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/27
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>session登录页面</title>
    <script>
      window.onload = function () {
        document.getElementById("img").onclick = function () {
          this.src = "verify?" + new Date().getTime();
        }
      }
    </script>
    <style>
      div {
        color: red;
      }
    </style>
  </head>
  <body>
  <form action="login" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name="username" placeholder="默认admin" value="<%=request.getSession().getAttribute("username") == null?
          "":request.getSession().getAttribute("username")%>"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password" placeholder="默认admin123" value="<%=request.getSession().getAttribute("password") == null?
          "":request.getSession().getAttribute("password")%>"></td>
      </tr>
      <tr>
        <td>验证码</td>
        <td><input type="text" name="verify"></td>
      </tr>
      <tr>
        <td colspan="2"><img id="img" src="verify"></td>
      </tr>
      <tr>
        <td><input type="checkbox" name="remember" value="true" checked>记住密码</td>
        <td colspan="2"><input type="submit" value="submit"></td>
      </tr>
    </table>
  </form>
  <div>
    <%=request.getSession().getAttribute("verifyMistake") == null?
          "":request.getSession().getAttribute("verifyMistake")%>
  </div>
  <div>
    <%=request.getSession().getAttribute("infoMistake") == null?
            "":request.getSession().getAttribute("infoMistake")%>
  </div>
  </body>
</html>
