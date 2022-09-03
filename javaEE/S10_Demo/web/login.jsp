<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
		function updateCode() {
			var code = document.getElementById("code");
			code.src = "${pageContext.request.contextPath}/verify?"+new Date().getTime();
		}
    </script>
  </head>
  <body background="images/bg1.jpg" style="background-repeat:no-repeat;background-size:100% 100%;
background-attachment: fixed;">
  	<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form action="login" method="post">
	      <div class="form-group">
	        <label for="user">用户名：</label>
	        <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名" required/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" required/>
	      </div>
	      
	      <div class="form-inline">
	        <label for="code">验证码：</label>
	        <input type="text" name="verifyInfo" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;" required/>
	        <a href="javascript:updateCode()"><img src="verify" title="看不清点击刷新" id="code"/></a>
	      </div>
	      <hr/>
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit" value="登录">
	       </div>
	  	</form>
		
		<!-- 出错显示的信息框 -->
		<c:if test="${not empty verifyFailed}">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" >
					<span>&times;</span>
				</button>
				<strong>${verifyFailed}</strong>
			</div>
		</c:if>
  	</div>
  </body>
</html>