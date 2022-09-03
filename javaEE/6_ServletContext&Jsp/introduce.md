### ServletContext对象
#### 简介
代表整个web应用,每一个应用中只有一个ServletContext对象  
ServletContext域对象是Servlet规范中4个域对象之一,拥有web应用中最大的作用域,也叫application域,能实现整个应用之间的数据共享。  
生命周期:应用加载时创建,应用停止时销毁
#### 使用
1. 获取servletContext对象[示例](src/com/entropy/test/ServletContextTest.java)
2. 获取MIME类型(如image/jpeg、audio/mpeg、video/mp4)  
   MIME类型:在互联网通信过程中定义的一种文件数据类型  
   [示例](src/com/entropy/test/MIMETest.java)
3. 共享数据  
   一端存储数据[示例](src/com/entropy/test/DataSaveTest.java)、一端获取数据[示例](src/com/entropy/test/DataShareTest.java)  
   注意:由于servletContext生命周期比较长,使用servletContext存储大量数据会对服务器造成不小的内存压力  
   删除数据[示例](src/com/entropy/test/DataCleanTest.java)
4. 获取文件真实路径(服务器路径)  
   [示例](src/com/entropy/test/PathInfo.java)  
#### 实现网页文件下载  
路径和文件名不能包含空格和特殊字符  
文件名中文乱码问题  
解决思路:获取浏览器版本信息,不同的浏览器版本有不同的编码方式,根据版本信息创建一个专门用于处理编码方式的[工具类](src/com/entropy/util/EncodeUtil.java)

### JSP进阶学习
JSP全称Java Server Page,和Servlet一样是一套开发动态web资源的技术,合称为JSP/Servlet规范,JSP本质上是一种特殊的Servlet  
[简单回顾](web/index.jsp)  
#### jsp指令
> 1.page指令
>
> [示例](web/page.jsp)
>
> 2.include指令:使一个页面能够包含其他页面的内容
>
> [示例](web/include.jsp)
>
> 3.taglib指令(需要导入jar包,注意路径是在WEB-INF下面):引入外部标签库
>
> [示例](web/taglib.jsp)
#### jsp细节
##### 九大隐式对象(内置对象)

| 隐式对象名称 |                  类型                  |               备注               |
| :----------: | :------------------------------------: | :------------------------------: |
|   request    | javax.servlet.http.HttpServletRequest  |             请求对象             |
|   response   | javax.servlet.http.HttpServletResponse |             响应对象             |
|   session    |     javax.servlet.http.HttpSession     |            会话范围内            |
| application  |      javax.servlet.ServletContext      |        整个应用范围内共享        |
|     page     |            Java.lang.Object            |   当前jsp对应的servlet引用实例   |
|    config    |      javax.servlet.ServletConfig       |        Servlet的配置对象         |
|  exception   |          java.lang.Throwable           |             异常对象             |
|     out      |      javax.servlet.jsp.JspWriter       |  字符输出流，相当于printwriter   |
| pageContext  |     javax.servlet.jsp.PageContext      | 很重要,页面范围,当前页面共享数据 |

##### PageContext对象  
jsp独有的对象,Servlet中没有这个对象。  
pageContext本身也是一个域对象,但它能够操作其它3个域对象中的属性,还能够获取其它8个隐式对象  
生命周期:随jsp的创建而创建,随jsp的销毁而销毁。每一个jsp页面都有一个独立的pageContext
##### 四大域对象

| 域对象名称     | 范围     | 级别                     | 备注                                     |
| :--------------: | :--------: | :------------------------: | :----------------------------------------: |
| PageContext    | 页面范围 | 最小只能在当前页面用   | 因范围太小，开发中用的很少               |
| ServletRequest | 请求范围 | 一次请求或当期请求转发用 | 当请求转发之后，再次转发时请求域丢失     |
| HttpSession    | 会话范围 | 多次请求数据共享时使用   | 多次请求共享数据，但不同的客户端不能共享 |
| ServletContext | 应用范围 | 最大，整个应用都可以使用 | 尽量少用，如果对数据有修改需要做同步处理 |

### MVC设计范式
如果按照传统的jsp技术进行javaWeb开发会有以下的缺陷:
1. 业务逻辑和展示逻辑没有明显区分,维护和后续开发拓展困难
2. 主要依赖后端服务器的生成,一旦需求量过大会对服务器产生较大的负担
3. 代码耦合过重

MVC:Model View Controller设计范式
1. Model在java中指代业务逻辑service层,负责各种数据的业务操作
2. View是视图层,主要就是展示在前端的html、jsp文件等
3. Controller是控制层,根据用户的需求,从Model中调用对应的数据传递给视图层来展示给用户

MVC设计范式主要是划分了业务逻辑和展示逻辑,M、V、C三个层次各司其职,降低了代码耦合性,便于后期维护与开发拓展。  
jsp技术与mvc范式的主要区别就是分层,分层是为了实现“高内聚、低耦合”。  
这也是一种“分而治之”的思想,把问题划分开来各个解决,易于控制,延展和分配资源。