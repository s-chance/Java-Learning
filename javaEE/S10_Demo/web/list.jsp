<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("注意：您正在进行不可恢复的操作，是否确认删除？")) {
                location.href = "${pageContext.request.contextPath}/delete?id="+id;
            }
        }
        window.onload = function () {
            //批量删除添加点击提交事件
            document.getElementById("deleteSelected").onclick = function () {
                if (confirm("是否确定批量删除选中的内容？")) {
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }
            //实现全选按钮
            document.getElementById("mainCB").onclick = function () {
                var cbs = document.getElementsByName("uid");
                console.log(cbs);
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body background="images/bg2.jpg" style="background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/page" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name" value="${map.name[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" name="address" value="${map.address[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" name="email" value="${map.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="deleteSelected">批量删除</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/deleteSelected" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="mainCB"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>住址</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${page.pageList}" var="user" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/searchById?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <%--分页--%>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.pageNow == 1}">
<%--                    <li class="disabled">--%>
<%--                        <a href="" aria-label="Previous">--%>
<%--                            <span aria-hidden="true">&laquo;</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>
                </c:if>
                <c:if test="${page.pageNow != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow-1}&pageSize=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${page.pageTotal}" var="p">
                    <c:if test="${page.pageNow == p}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/page?pageNow=${p}&pageSize=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}">${p}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNow != p}">
                        <li>
                            <a href="${pageContext.request.contextPath}/page?pageNow=${p}&pageSize=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}">${p}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNow == page.pageTotal}">
<%--                    <li class="disabled">--%>
<%--                        <a href="" aria-label="Next">--%>
<%--                            <span aria-hidden="true">&raquo;</span>--%>
<%--                        </a>--%>
<%--                    </li>--%>
                </c:if>
                <c:if test="${page.pageNow != page.pageTotal}">
                    <li>
                        <a href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow+1}&pageSize=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <span style="font-size: 24px;margin-left: 5px">
                    共${page.count}条记录，共${page.pageTotal}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
