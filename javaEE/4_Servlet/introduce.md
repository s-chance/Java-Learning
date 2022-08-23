### Servlet API
#### 简单介绍
概念
   1. 运行在服务器端的程序
   2. Servlet程序、Filter过滤器、Listener监听器是javaWeb三大组件

作用:Servlet运行在服务器端,能够接受客户端发送的请求,并返回数据响应客户端
#### 快速使用
1. 创建javaEE项目
2. 创建一个类,实现Servlet接口
3. 配置Servlet,在[web.xml](web/WEB-INF/web.xml)中配置
#### Servlet大致执行流程
1. 服务器接受到客户端请求
2. 服务器查找web.xml文件的<url-pattern>标签内容
3. 通过绑定的<servlet-name>标签找到<servlet-class>全类名
4. tomcat加载相应的文件到内存中,创建对象
5. 调用对应的方法响应客户端
#### Servlet生命周期
1. 被创建时,执行init方法,只执行一次
   - <load-on-startup>标签可以配置servlet创建时机  
   - init方法在整个周期仅执行一次,说明servlet不支持多线程处理,解决方法就是不要在servlet中定义成员变量
2. 响应请求,执行service方法,次数不限  
   - 每次请求执行一次
3. 被销毁时,执行destroy方法,只执行一次
   - 在服务器正常关闭的前提下,servlet被销毁,释放资源  

[示例](src/com/entropy/test/ServletTest.java)(访问路径以web.xml中的配置为准)
#### Servlet注解式开发
servlet版本3.0以上支持注解开发,可以用注解@WebServlet代替web.xml简化配置  
[示例](src/com/entropy/annotation/ServletAnnotation.java)
#### 关于Servlet体系
Servlet接口-->GenericServlet抽象类-->HttpServlet抽象类  
一步步对上一级进行封装简化  
[前端示例](web/index.html)、[后端示例](src/com/entropy/annotation/HServlet.java)  
测试时访问@WebServlet的路径即可,post请求只能通过前端示例的post表单实现
#### 关于url-pattern
访问路径可以设置多个,如@WebServlet({"/1","/2","/3"})  
访问路径可以设置多级,如@WebServlet("/1/2/3")  
访问路径可以设置成模糊路径,如`@WebServlet("*")或者@WebServlet("*.html")`
#### 测试时可能遇到的问题
- 前端示例与后端示例url路径没有对应,修改路径使前后端保持一致
- out文件夹缓存问题,删除out文件夹,重启tomcat重新生成