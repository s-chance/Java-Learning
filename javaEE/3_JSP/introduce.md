### Java Web
#### Tomcat服务器
1. [Tomcat官网下载地址](http://tomcat.apache.org/)
2. Tomcat的目录结构  
   bin:二进制文件目录,存放命令  
   conf:配置文件目录,非常重要,不要轻易改动  
   lib:运行tomcat所需jar包目录  
   logs:日志目录  
   temp:临时文件目录
   webapps:应用发布目录,启动tomcat后能够通过url访问到里面的资源  
   work:工作目录
3. Tomcat的基本使用  
   bin目录下startup.bat启动tomcat,shutdown.bat停止tomcat  
   tomcat的运行需要提前配置好java环境变量
#### IDEA集成Tomcat
[演示](IDEA集成Tomcat.mp4)
#### jsp实现html嵌入java代码
1. html使用jsp,需要在文件最前面添加以下脚本
    ```jsp
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    ```
2. jsp格式  
   ```jsp指令:<%@%>  
   脚本:<%java代码%>  
   表达式:<%=java表达式%>  
   声明:<%!方法%>  
   ```
3. jsp的使用[示例](web/index.jsp)
4. html输入与jsp输出交互  
   在[interact.html](web/interact.html)中输入参数提交后,跳转至[interact.jsp](web/interact.jsp)  
   本示例不能直接访问[interact.jsp](web/interact.jsp),会出现异常