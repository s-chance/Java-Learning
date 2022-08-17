### JDBC
#### Java DataBase Connectivity(java语言连接数据库)
- 在java语言中使用sql语句,实现对mysql数据库的数据操作
- JDBC相关库 java.sql.*
- 重要jar包 mysql-connector-java 可从mysql官网下载zip包  
#### 准备工作
jar包引入:在IDEA的Module下新建一个name为lib的Directory,将下载的.jar文件粘贴到该Directory下,右键该文件选择add as libraries
#### 开发步骤
1. 注册驱动
2. 获取连接
3. 获取数据库操作对象
4. 执行sql语句
5. 处理查询结果集
6. 释放资源,避免占用进程
#### 多种方式注册驱动
1. 原生代码实现
2. 类加载反射实现
3. 配置文件实现  
[示例](src/com/entropy/test/JDBCTest.java)
#### 模拟用户登录以及应对sql注入
- sql注入指通过原始字符串直接拼接造成的漏洞非法实现数据操作。
- 应对sql注入的一种思路是PreparedStatement预处理字符串,将需要拼接的内容先用占位符做预处理,
之后再对预处理之后的sql语句进行传值。这样能够防止针对字符串拼接漏洞的sql注入。
- 实际开发中,主要使用PreparedStatement来处理sql语句,而不是Statement。  
[示例](src/com/entropy/demo/JDBCDef.java)