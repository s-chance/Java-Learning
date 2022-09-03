<%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/30
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body background="images/bg3.jpg" style="background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<div align="center">
  <h1>用户信息后台管理系统</h1>
  <div style="text-decoration:none;font-size:33px">欢迎${userInfo.username}登录</div>
  <%--${pageContext.request.contextPath}动态获取虚拟路径,增强项目的可迁移性--%>
  <a
          href="${pageContext.request.contextPath}/page?pageNow=${p}&pageSize=5" style="text-decoration:none;font-size:33px">查询所有用户信息
  </a>

</div>
</body>
</html>
