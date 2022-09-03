### 数据库连接池Connection Pool
概念:连接池是一个用于存放数据库连接的容器(集合)  
大致流程:系统初始化,创建好容器,容器申请到一些连接对象,当用户访问数据库时,从容器中获取连接对象,完成操作后将连接对象重新归还给容器  
优势:
1. 重复利用了已有的内存资源,提高了资源利用效率,相比纯粹的JDBC更加节约资源
2. 由于使用已有的内存资源创建连接对象,而不是重新创建,因此访问效率相对更高,尤其是在面对短时间内数千万的用户访问需求(即高并发)  
实现:连接池技术一般不需要由开发者手动实现,因为已经有厂商提供了连接池技术  
   - 一代(已经很少使用)
     - C3P0:一个开源的JDBC连接池,但是过于古老且代码复杂也存在许多bug,难以维护(实际上很久之前就已经不再维护),目前正式开发中基本已经被淘汰
     - DBCP:由Apache软件基金会开发,但是DBCP的更新也处于不活跃的状态
     - BoneCP:2013年前性能最强的连接池,之后让步于HikariCP,并停止更新维护
   - 二代(使用广泛)
     - Druid:由alibaba开发,是淘宝与支付宝专用的数据库连接池,功能全面、扩展性强,更新维护也处于活跃的状态
     - HikariCP:参考了BoneCP的设计思想,根据网络上的测试数据来看是目前性能最强的连接池,也是SpringBoot2.0版本官方的默认连接池  
   - 关于连接池技术的选择以实际需求为准

简单使用  
> 导入jar包
>
> 数据库驱动:`mysql-connector-java-5.1.37-bin.jar`
>
> c3p0:`c3p0-0.9.5.2.jar`和`mchange-commons-java-0.2.12.jar`
>
> 关于c3p0,这里就做简单的演示:[测试代码](src/com/entropy/pool/C3P0Pool.java)、[配置文件](src/c3p0-config.xml)(配置文件名、文件路径不要轻易改动,否则可能无法识别)
>
> druid:`druid-1.0.9.jar`
>
> druid示例:[测试代码](src/com/entropy/pool/DruidPool.java)、[配置文件](src/druid.properties)
>
> druid工具类制作[示例](src/com/entropy/util/JDBCUtil.java)、[测试](src/com/entropy/test/DruidTest.java)
### JdbcTemplate
概念:由Spring框架对JDBC封装而成的JdbcTemplate,简化了JDBC的开发  
步骤(相比JDBC不需要手动获取连接,不需要手动创建预处理对象,对结果集的处理也提供了很多方法等)
> 1.导入jar包(使用JdbcTemplate所需的5个必要jar包):
> `commons-logging-1.2.jar`
> `spring-beans-5.0.0.RELEASE.jar`
> `spring-core-5.0.0.RELEASE.jar`
> `spring-jdbc-5.0.0.RELEASE.jar`
> `spring-tx-5.0.0.RELEASE.jar`
>
> 2.创建JdbcTemplate对象
>
> 3.编写SQL语句,调用JdbcTemplate对象已经封装好的方法
>
> [简易示例](src/com/entropy/test/JdbcTemplateTest.java)

JdbcTemplate结合实体类实现各种数据操作  
示例:[实体类](src/com/entropy/pojo/Emp.java)、[测试代码](src/com/entropy/test/JdbcTemplateDemo.java)、[原始测试数据](task.sql)
