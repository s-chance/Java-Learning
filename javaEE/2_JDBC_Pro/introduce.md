### JDBC进阶
#### PreparedStatement
- 增删改  
由于增删改操作和查询操作不一样,不会返回查询结果集。因此增删改操作没有处理结果集的步骤。
- 实现模糊查询  
模糊查询的占位符在PreparedStatement中是写在setString中的,不能直接写在sql语句中。  
[示例](src/com/entropy/test/JDBCTest.java)
#### 模拟银行转账业务
- 准备工作  
  注意lib目录下jar包的导入以及数据库连接的参数。  
  ```mysql
  create database bank;
  use bank;
  create table account(
      id int primary key auto_increment,
      money double(10,2)  # 10位有效数字,2位小数
  );
  insert into account(money) value (3000);
  insert into account(money) value (1000);
  select * from account;
  ```
- 代码编写  
实际应用中会出现各种异常情况,如断网等会对数据造成影响,尤其对贸易来说这是非常严重的情况。因此实际开发中需要考虑到这一点。  
由于涉及到了事务安全性,需要相应地关闭事务自动提交机制以及增加事务回滚的操作步骤。
- [示例](src/com/entropy/demo/JDBCDemo.java)
#### 封装工具类
为了提高开发效率,开发经常重复使用的代码会封装成工具类。在需要使用的地方只需调用工具类即可,而不必重复写代码。