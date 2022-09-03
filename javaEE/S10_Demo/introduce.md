### JavaWeb简易项目制作
采用三层架构设计,区别于MVC设计模式
#### 三层架构:一种软件设计架构
1. 界面层(UI):用户交互界面,可以通过界面上的组件和服务器进行交互
2. 业务逻辑层(BLL):处理业务逻辑
3. 数据访问层(DAL):操作数据存储文件

三层架构基于业务逻辑划分,MVC基于页面展示划分
#### 技术栈
Servlet+Jsp+Tomcat、MySQL+Druid+JdbcTemplate+BeanUtil  
#### 功能介绍
基本:登录、列表查询、增加数据、删除数据、修改数据  
进阶:批量删除、分页查询、条件查询  
#### 开发流程
1. 数据库搭建,测试数据准备[10_demo.sql](10_demo.sql),注意要使用中文字符的话需要在创建数据库时设置字符集为uft8  
2. 导入必要的jar包
    > MySQL驱动:`mysql-connector-java-5.1.37-bin.jar`
    >
    > druid连接池:`druid-1.0.9.jar`,把配置文件准备好(项目已提供模板[druid.properties](src/druid.properties))
    >
    > JSTL:
     `javax.servlet.jsp.jstl.jar`
     `jstl-impl.jar`
    >
    > JdbcTemplate:
     `commons-logging-1.2.jar`
     `spring-beans-5.0.0.RELEASE.jar`
     `spring-core-5.0.0.RELEASE.jar`
     `spring-jdbc-5.0.0.RELEASE.jar`
     `spring-tx-5.0.0.RELEASE.jar`
    >
    > JavaBean操作工具:`commons-beanutils-1.8.3.jar`
3. 前端页面,这里直接使用网上提供的模板,具体样式可自行修改
4. 编写实体类pojo  
主要是编写各个成员变量、构造方法、getter和setter方法以及toString方法
5. 编写JDBC的工具类,这里已经提供了模板(适用于本项目的环境,如有其它环境需求,可自行修改)  
6. 编写web层:主要是servlet程序的编写
7. 编写service层:主要是service接口和接口实现类
8. 编写dao层:主要是dao接口和接口实现类
9. 修改前端html文件为jsp文件:利用EL表达式和JSTL进行开发

#### 功能模块划分  
service层和dao层的方法都是写在一个接口和一个接口实现类中的,这里主要说明各个jsp页面和servlet程序所执行的功能  
> 列表查询:[list.jsp](web/list.jsp)、[UserListServlet.java](src/com/entropy/web/servlet/UserListServlet.java)(后面被分页查询的servlet程序替代)
>
> 登录:[login.jsp](web/login.jsp)、[LoginServlet.java](src/com/entropy/web/servlet/LoginServlet.java)
>
> 增加数据:通过list.jsp跳转到[add.jsp](web/add.jsp)、[AddUserServlet.java](src/com/entropy/web/servlet/AddUserServlet.java)
>
> 删除数据:通过list.jsp页面按钮实现、[DeleteUserServlet.java](src/com/entropy/web/servlet/DeleteUserServlet.java)
>
> 修改数据:通过list.jsp页面跳转到[update.jsp](web/update.jsp)、[UpdateUserServlet.java](src/com/entropy/web/servlet/UpdateUserServlet.java)、数据回显[SearchByIdServlet.java](src/com/entropy/web/servlet/SearchByIdServlet.java)

> 批量删除:通过list.jsp页面复选框实现、[DeleteSelectedServlet.java](src/com/entropy/web/servlet/DeleteSelectedServlet.java)
>
> 分页查询:通过list.jsp页面上的组件实现、[PageServlet.java](src/com/entropy/web/servlet/PageServlet.java)、需要额外的[Page对象](src/com/entropy/pojo/Page.java)
>
> 条件查询:通过list.jsp页面上的组件实现、[PageServlet.java](src/com/entropy/web/servlet/PageServlet.java)
#### 细节说明
- UserListServlet前期用于过渡、后期改用PageServlet实现分页查询,这个时候需要对多个servlet转发的地址以及list.jsp页面表单或功能按键指向的地址进行修改
- PageServlet同时实现了分页查询和条件查询的功能,配合Page对象实现了分页功能
- 条件查询是通过流程控制以及sql语句拼接实现的动态条件查询,同时基于动态条件查询使得任意查询条件下都能实现分页功能
- 格外注意sql拼接语句格式,字符串中不能缺少必要的空格