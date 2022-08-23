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
为了提高开发效率,开发经常重复使用的代码会封装成[工具类](src/com/entropy/util/JDBCUtil.java)。在需要使用的地方只需调用工具类即可,而不必重复写代码。  
[示例](src/com/entropy/test/JDBCUtilTest.java)
#### DAO开发模式
位于业务逻辑和持久化数据之间,实现对持久化数据的访问  
**DAO模式组成部分**
- DAO接口
- DAO实现类
- 实体类
- 工具类  
**实体类特征**
1. 属性一般使用private修饰
2. public修饰的getter/setter方法
3. 提供无参构造方法，根据业务提供有参构造
4. 实现java.io.Serializable接口，支持序列化机制
#### IDEA集成MySQL
需要提前准备好jar包驱动或者在集成MySQL时由IDEA自动下载驱动
[演示](IDEA集成MySQL.mp4)