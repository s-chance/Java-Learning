### Http
概念:全称Hyper Text Transfer Protocol超文本传输协议  
定义了客户端与服务端通信的数据格式。  

特点

   1. 基于TCP/IP的高级协议
   2. 默认端口号:80
   3. 基于请求/响应模型,一次请求对应一次响应
   4. 无状态的:每次请求之间相互独立,不能交互数据  

历史版本

   1.0:每一次请求响应都会建立新的连接  
   1.1:复用连接
   
请求数据格式

请求:客户端发送数据给服务端
   1. 请求行
   2. 请求头
   3. 请求空行
   4. 请求体
   
响应数据格式

响应:服务端发送数据给客户端
   1. 响应行
   2. 响应头
   3. 响应空行
   4. 响应体

关于[Request和Response](request&response.md)

### 补充:JavaWeb form表单action填写方式  
前提条件:tomcat采用默认端口设置,虚拟路径为localhost:8080/
1. 提交到具体的文件,例如web/path目录下的example.jsp
   ```html
   <!--绝对地址-->
   <form action="http://localhost:8080/path/example.jsp">
   </form>
   
   <!--以"/"开头的相对地址-->
   <!--此时的/代表整个web项目,即:http://localhost:8080/-->
   <form action="/path/example.jsp">
   </form>
   
   <!--不以"/"开头的相对地址-->
   <form action="example.jsp">
   </form>
   ```
   如果不同目录下有重名的文件就不能使用第三种方式
2. 提交到Servlet程序,假设其路径为/servletPath(一级目录),用于提交的test.jsp文件位于web/jsp目录下
   ```html
   <!--绝对地址-->
   <form action="http://localhost:8080/servletPath">
   </form>
   
   <!--以"/"开头的相对地址-->
   <!--此时的/代表整个web项目,即:http://localhost:8080/-->
   <form action="/servletPath">
   </form>
   
   <!--不以"/"开头的相对地址-->
   <!--
       不以"/"开头的相对地址是相对于当前资源的路径
       此时test.jsp的地址是http://localhost:8080/jsp/test.jsp
       当前资源路径就是http://localhost:8080/jsp
       Servlet程序的地址是http://localhost:8080/servletPath
       Servlet程序的地址与test.jsp的上一级目录同级
       因此提交的相对路径为../servletPath
   -->
   <form action="../servletPath">
   </form>
   ```
