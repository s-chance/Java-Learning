### MySQL基础

---

#### <span id="head">快速导航</span>

提醒：Typora内无法进行快速导航跳转建议用Typora自带的功能导出为html文件；另外各个示例之间有一定数据关联性，建议先把预先准备的测试数据代码执行好。

[DDL](#ddl)

[DML](#dml)

[DQL](#dql)

[条件查询](#ysf)

[排序](#px)

[聚合函数](#juhe)

[ 分组查询](#fz)

#### 一、数据库管理系统

1. 数据库管理系统：DataBaseManagement，简称DBMS。
2. 数据库管理系统是专门用来管理数据库中的数据，数据库管理系统可以对数据库中的数据进行增删改查的操作。
3. 常见的数据库管理系统：MySQL，Oracle，SqlServer，MS，DB2等。

#### 二、SQL

1. SQL是一种结构化查询语言。
2. 通过SQL可以实现对数据库中数据的操作。
3. SQL是一套标准，基本能在大部分数据库管理系统中使用。

#### 三、工作流程

​	数据库管理系统SQL$\rarr$执行SQL$\rarr$操作数据库

​	先安装数据库管理系统MySQL，然后编写SQL语句，之后DBMS对SQL语句	进行执行来完成对数据库的数据管理。

#### 四、准备工作

1. MySQL官网[下载]( [MySQL :: Download MySQL Installer (Archived Versions)](https://downloads.mysql.com/archives/installer/) )，Windows推荐下载[Mysql5.7社区版本](https://downloads.mysql.com/archives/get/p/25/file/mysql-installer-community-5.7.30.0.msi)，使用较多的版本。简易配置推荐Server only，也可以选择Custom自定义安装路径，后面填写好root用户的密码即可。其余默认下一步。MySQL环境变量配置可配可不配，需要命令行运行MySQL的相关命令可参考jdk的环境变量配置过程配置好。

   ```bash
   # 基本命令
   mysql -uroot -p  //登录MySQL,-p后面需要输入之前设置的密码
   # 登录MySQL之后所有命令结尾必须要加英文分号;
   mysql> exit;   //退出MySQL
   mysql> mysqladmin -uroot newpassword;  //root密码为空时,设置新密码
   mysql> mysqladmin -uroot -pxxx password yyy; //xxx为旧密码,yyy为新密码
   mysql> set password for 用户名@localhost = password('新密码');  //修改密码的另一种方式,用户名一般是root
   
   mysql> show databases; //查看全部的数据库
   mysql> create database 数据库名; //创建数据库
   mysql> use 数据库名; //指定需要操作的数据库
   mysql> show tables; //展示指定数据库里面所有的数据表
   
   # 后面的数据操作相关命令可以直接套用navicat中编写的SQL语句,记得结尾加分号;
   ```

2. 数据库管理工具Navicat[下载]( [Navicat | Download Navicat for MySQL 14-day trial versions for Windows, macOS and Linux](https://www.navicat.com/en/download/navicat-for-mysql) )，原生的MySQL数据库管理系统缺乏管理工具比较难以使用，通过第三方数据库管理工具可以更方便地管理数据库。

3. Navicat连接MySQL时需要确保MySQL服务开启，一般安装时默认开机自启动。**以管理员身份运行**命令提示符，输入命令。

   ```bash
   net start mysql57  //运行MySQL服务
   ```

   MySQL服务的端口号为3306，输入用户名和密码后，完成连接。

#### 五、正式开始

##### 1.SQL语句分类

- DQL:数据查询语言，一般以**select**关键字开头，查询数据
- DML:数据操作语言，**insert**、**delete**、**update**关键字，**增删改数据表中的数据**
- DDL:数据定义语言，**create**、**drop**、**alter**关键字，**增删改数据表的结构**
- TCL:事务控制语言，**commit**、**rollback**关键字，事务回滚和事务提交
- DCL:数据控制语言，**grant**、**revoke**关键字，定义访问权限和安全级别及创建用户

##### 2.DDL数据定义语言的使用

- 首先明确MySQL中的数据类型大致分为：**数值、日期/时间、字符串(字符)**三类。

- 数值类型

  |     类型     |                   大小                   |                        范围（有符号）                        |                        范围（无符号）                        |      用途       |
  | :----------: | :--------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :-------------: |
  |   TINYINT    |                 1 Bytes                  |                          (-128,127)                          |                           (0,255)                            |    小整数值     |
  |   SMALLINT   |                 2 Bytes                  |                        (-32768,32767)                        |                          (0,65535)                           |    大整数值     |
  |  MEDIUMINT   |                 3 Bytes                  |                      (-8388608,8388607)                      |                         (0,16777215)                         |    大整数值     |
  | INT或INTEGER |                 4 Bytes                  |                   (-2147483648,2147483647)                   |                        (0,4294967295)                        |    大整数值     |
  |    BIGINT    |                 8 Bytes                  |                        (-2^63,2^63-1)                        |                          (0,2^64-1)                          |   极大整数值    |
  |    FLOAT     |                 4 Bytes                  | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0， (1.175 494 351 E-38，3.402 823 466 351 E+38) |         0，(1.175 494 351 E-38，3.402 823 466 E+38)          | 单精度 浮点数值 |
  |    DOUBLE    |                 8 Bytes                  | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度 浮点数值 |
  |   DECIMAL    | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 |                        依赖于M和D的值                        |                        依赖于M和D的值                        |     小数值      |

- 日期和时间类型

  TIMESTAMP类型有专有的自动更新特性，将在后面描述。

  |   类型    | 大小 (Bytes) |                             范围                             |        格式         |           用途           |
  | :-------: | :----------: | :----------------------------------------------------------: | :-----------------: | :----------------------: |
  |   DATE    |      3       |                    1000-01-01/9999-12-31                     |     YYYY-MM-DD      |          日期值          |
  |   TIME    |      3       |                   '-838:59:59'/'838:59:59'                   |      HH:MM:SS       |     时间值或持续时间     |
  |   YEAR    |      1       |                          1901/2155                           |        YYYY         |          年份值          |
  | DATETIME  |      8       |           1000-01-01 00:00:00/9999-12-31 23:59:59            | YYYY-MM-DD HH:MM:SS |     混合日期和时间值     |
  | TIMESTAMP |      4       | 1970-01-01 00:00:00/2038结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 |   YYYYMMDD HHMMSS   | 混合日期和时间值，时间戳 |


- 字符串类型

  | 类型       | 大小                  | 用途                            |
  | :--------- | :-------------------- | :------------------------------ |
  | CHAR       | 0-255 bytes           | 定长字符串                      |
  | VARCHAR    | 0-65535 bytes         | 变长字符串                      |
  | TINYBLOB   | 0-255 bytes           | 不超过 255 个字符的二进制字符串 |
  | TINYTEXT   | 0-255 bytes           | 短文本字符串                    |
  | BLOB       | 0-65 535 bytes        | 二进制形式的长文本数据          |
  | TEXT       | 0-65 535 bytes        | 长文本数据                      |
  | MEDIUMBLOB | 0-16 777 215 bytes    | 二进制形式的中等长度文本数据    |
  | MEDIUMTEXT | 0-16 777 215 bytes    | 中等长度文本数据                |
  | LONGBLOB   | 0-4 294 967 295 bytes | 二进制形式的极大文本数据        |
  | LONGTEXT   | 0-4 294 967 295 bytes | 极大文本数据                    |
  
  <span id="ddl">[返回快速导航](#head)</span>
  
- DDL语句示例一：对数据表的管理操作以及对字段的增删改操作（在Navicat中新建查询输入SQL语句或在命令行中输入SQL语句）

  ```mysql
  create database test;
  use test;
  # 创建一张拥有一个int类型的t1字段的test_int数据表
  # 默认为有符号
  # 多个字段用英文逗号,隔开
  create table test_int(
  	t1 int
  );
  # 这里的desc作用是查看数据表的结构信息
  desc test_int;
  # 增加一条t1字段值为-11111的记录
  insert into test_int values (-11111); # 默认有符号
  
  # 增加一个t2无符号字段
  alter table test_int add column t2 int unsigned;
  # 这时候增加一条t2字段值为负数的记录,就会出现out of range的错误
  insert into test_int (t2) value (-1111); # 报错
  # 修改t2字段类型
  alter table test_int modify column t2 int;
  # 删除t2字段
  alter table test_int drop column t2;
  
  # 删除test_int数据表
  drop table if exists test_int;
  
  create table test_int(
  	t1 int,
      t2 int unsigned
  );
  
  select * from test_int;
  ```


- 示例二：对数据库的管理操作

  ```mysql
  语法 create database [if not exists] 数据库名; #[]中的内容选填
      drop database [if exists] 数据库名;
  # 创建数据库book
  create database book;
  # 更改数据库的字符集
  alter database book character set utf8;
  # 查看字符集
  show create database book;
  # 删除数据库(判断该数据库是否存在,存在则进行删除)
  drop database if exists book;
  ```
  
- 示例三：对数据表结构的操作
  
  ```mysql
  create table books(
  	id int,
      name varchar(20),
      price double,
      author varchar(20),
      publish_date datetime
  );
  desc books;
  # 表的修改
  # alter table 数据表名 add/drop/modify/change column ...
  # 修改字段名publish_date为date
  alter table books change column publish_date date datetime;
  # 修改字段的类型或约束
  alter table books modify column date timestamp;
  
  # 关于alter中change和modify的使用区别
  # change的修改范围大于modify,change一般用于修改字段名
  # modify一般用于修改数据类型或约束,但modify不能修改字段名
  
  # 添加新的字段inventory,添加字段需要指明数据类型
  alter table books add column inventory int;
  # 删除字段inventory,删除字段只需要提供字段名
  alter table books drop column inventory;
  # 修改数据表名
  alter table books rename to works;
  desc works;
  ```
  
- 示例四：复制数据表

  ```mysql
  # 增加记录
  insert into works values
  (1,'《java》',132.9,'詹姆斯·高斯林','2001-12-01'),
  (2,'《linux》',156.9,'linus','1999-01-01');
  
  # 仅复制数据表的结构
  create table copy like works;
  # 复制结构和数据
  create table clone select * from works;
  # 复制部分结构
  create table remake select id,name from works;
  # 仅复制部分字段,利用where进行条件判断,恒为0则只保留字段
  create table redo select id,name from works where 0;
  ```


##### 3.DML数据操作语言的使用

<span id="dml">[返回快速导航](#head)</span>

- **insert语句**

  ```mysql
  # 语法
  # insert into 数据表名(字段名1,字段名2,...) values (字段值1,字段值2,...);
  create table product(
  	id int,
  	name varchar(20),
  	price double
  );
  
  # 在product表中增加一条记录
  insert into product(id,name,price) values (1,'phone',500.0);
  # 在product表中指定的字段增加记录
  insert into product(id,price) values (2,399.9);
  
  select * from product;
  
  # 默认给全部字段增加记录
  # insert into 数据表名 values (字段值1,字段值2,...);
  
  insert into product values (3,'mac',21499.9);
  select * from product;
  
  # 批量增加记录
  # insert into 数据表名 values (字段值1,字段值2,...),(字段值1,字段值2,...);
  
  insert into product values (4,'a',1.1),(5,'b',2.2),(6,'c',3.3);
  select * from product;
  ```

  注意字段名和字段值的类型对应，以及日期时间、字符字符串类型数据需要加上引号（单双引号均可）

- **update语句**

  ```mysql
  # 语法
  #update 数据表名 set 字段1 = 值1,字段2 = 值2,...[where 条件];
  
  # 修改phone的price为9999
  update product set price = 9999 where name='phone';
  select * from product;
  
  # 修改mac的price为39999.9,id为0
  update product set price = 39999.9,id=0 where name='mac';
  
  # 修改id为2记录的name为switch
  update product set name = 'switch' where id=2;
  ```

  注意一般情况下update语句中不能缺少条件，否则会修改所有数据。

- **delete语句**

  ```mysql
  # 语法
  # delete from 数据表名 [where 条件];
  
  # 删除product表中的switch数据
  delete from product where name='switch';
  
  # 删除product表中price为39999.9的数据
  delete from product where price=39999.9;
  
  select * from product;
  ```

  注意delete语句中必须加上条件限制，否则所有的数据将会被删除。

  基本update和delete都要配合where来使用，否则和Linux系统中`rm -rf /`命令是差不多的后果。

##### 4.DQL数据查询语言的使用

​	<span id="dql">[返回快速导航](#head)</span>

- 示例

  ```mysql
  # 语法
  # select 字段名 from 数据表名;
  
  # 单独查询name字段
  select name from product;
  # 查询多个字段
  select id,name from product;
  # 查询所有字段
  select * from product;
  # 或者把*替换成数据表中所有的字段名
  
  # as关键字取别名,不改变原有数据,改变的是显示的内容,as关键字可省略
  select name as product_name from product;
  
  # 别名中有空格,使用单引号括住别名
  select name 'product name' from product;
  ```

##### 5.SQL运算符及条件查询

1. 算术运算符

   | 运算符 |                          **说  明**                          |
   | :----: | :----------------------------------------------------------: |
   | **+**  |         **加运算，求两个数或表达式相加的和，如6+8**          |
   | **-**  |             **减运算，求两个数或表达式相减的差**             |
   | *****  |             **乘运算，求两个数或表达式相乘的积**             |
   | **/**  |      **除运算，求两个数或表达式相除的商，如5/3的值为1**      |
   | **%**  | **取模运算，求两个数或表达式相除的余数，如：5%3的值为2** |

   SQL语句也可以使用数学表达式，注意SQL没有java的自增自减等运算符。

2. where条件查询运算符

   |       运算符       |                             说明                             |
   | :----------------: | :----------------------------------------------------------: |
   |         =          |                             等于                             |
   |       <>或!=       |                            不等于                            |
   |         <          |                             小于                             |
   |         <=         |                           小于等于                           |
   |         >          |                             大于                             |
   |         >=         |                           大于等于                           |
   | between..  and.... |              两个值之间，等同于  >=   and   <=               |
   |      is  null      |               为null  （is  not  null不为空）                |
   |        and         |                             并且                             |
   |         or         |                             或者                             |
   |         in         |          包含，相当于多个or（not in不在这个范围中）          |
   |        not         |              not可以取非，主要用在is  或  in中               |
   |        like        | like称为模糊查询，支持%或下划线匹配，%匹配任意多个字符，一个下划线值匹配一个字符 |
   
   <span id="ysf">[返回快速导航](#head)</span>
   
3. 示例

   ```mysql
   create database if not exists task;
   use task;
   create table if not exists coder(
   	id int,
       name varchar(20),
       score int,
       grade varchar(10),
       project int
   );
   insert into coder values
   (1,'Mike',100,'A',1),
   (2,'Jhon',96,'A',2),
   (3,'Dram',60,'D',null),
   (4,'Lambda',100,'A',null),
   (5,'LuBen',89,'B',3),
   (6,'K',75,'C',null),
   (7,'Z',88,'C',null),
   (8,'L',75,'B',null);
   select * from coder;
   
   # 查询coder数据表中score等于100的name和id记录
   select name,id from coder where score=100;
   
   # 查询coder数据表中grade不等于A的name和id记录
   select name,id from coder where grade != 'A';
   select name,id from coder where grade <> 'A';
   
   # 查询coder数据表中score小于89的name和id记录
   select name,id from coder where score < 89;
   
   # 查询coder数据表中score小于等于89的name和id记录
   select name,id from coder where score <= 89;
   
   # 查询coder数据表中score大于75的name和id记录
   select name,id from coder where score > 75;
   
   # 查询coder数据表中score大于等于75的name和id记录
   select name,id from coder where score >= 75;
   
   # 查询coder数据表中score在75和90之间的name和id记录
   select name,id from coder where score>=75 and score<=90;
   select name,id from coder where score between 75 and 90;
   # between 较小值 and 较大值  闭区间
   
   # 查询coder数据表中project为null的记录
   select * from coder where project is null;
    
   # 查询coder数据表中project不为null的记录
   select * from coder where project is not null;
    
   # 查询coder数据表中grade为A且score为100的记录
   select * from coder where grade='A' and score=100;
    
   # 查询coder数据表中score为100或project为3的记录
   select * from coder where score=100 or project=3;
    
   # and和or同时使用时,and优先级高于or,要使or先执行,则需用()括住or关联的条件
   # 查询coder数据表中grade为A且project为1 和 score大于74的记录
   select * from coder where grade='A' and project=1 or score > 74;
   # 查询coder数据表中project为1或score大于74 且grade为A的记录
   select * from coder where grade='A' and (project=1 or score > 74);
   
   # in关键字相当于多个or,但in无法关联数值范围的条件,只能关联一个具体的数值条件
   # 查询coder数据表中score为100或96的记录
   select * from coder where score=100 or score=96;
   select * from coder where score in(100,96); # 这里表示两个数值
   
   # 查询coder数据表中project不为1且不为3的记录
   select * from coder where project<>1 and project<>3;
   select * from coder where project not in(3,1);
   
   # 模糊查询
   # like关键字,匹配符%和_
   # %匹配任意多个字符,_匹配任意一个字符
   # 转义字符\,用于处理包含%和_这两个特殊符号的记录
   
   # 查询coder数据表中以e结尾的name记录
   select name from coder where name like '%e';
   # 查询coder数据表中以L开头的name记录
   select name from coder where name like 'L%';
   # 查询coder数据表中包含u的name记录
   select name from coder where name like '%u%';
   # 查询coder数据表中第二个字母为h的name记录
   select name from coder where name like '_h%';
   ```

##### 6.排序

|  关键字  | 说明 |
| :------: | :--: |
| order by | 排序 |
|   desc   | 降序 |
|   asc    | 升序 |

<span id="px">[返回快速导航](#head)</span>

```mysql
# 对coder数据表中的score进行排序,默认升序
select name,score from coder order by score;
# 指定降序,这里的desc作用是指定降序排序
select name,score from coder order by score desc;
# 指定升序
select name,score from coder order by score asc;

# 多字段排序,第一字段相同时,根据第二字段排序
# 根据score升序排序,score相同则根据name升序排序
select name,score from coder order by score asc,name asc;

# 不推荐写法
select * from coder order by 1; # 这里的1表示第一个字段id
# 这种写法很容易因为字段顺序的改变而出错
```

##### 7.聚合函数

<span id="juhe">[返回快速导航](#head)</span>

**多行数据经聚合函数处理之后的结果只有一行**

**聚合函数分类**

|    函数名     |              功能              |
| :-----------: | :----------------------------: |
| count(字段名) | 统计数量(一般选用不为null的列) |
|  max(字段名)  |             最大值             |
|  min(字段名)  |             最小值             |
|  sum(字段名)  |              求和              |
|  avg(字段名)  |             平均值             |

注意：聚合函数需要配合分组来使用，先分组再用聚合函数处理。

如果不进行分组，则默认整张数据表为一组。

示例：

```mysql
# 找出coder数据表中score字段的最大值记录
select max(score) from coder;
# 找出coder数据表中score字段的最小值记录
select min(score) from coder;
# 计算score字段所有记录的总和
select sum(score) from coder;
# 计算score字段所有记录的平均值
select avg(score) from coder;
# 计算记录总条数,可以用任意非空字段做参数
select count(name) from coder;
```

注意：

1. 聚合函数会自动忽略指定字段值为null的记录
2. 在count(*)情况下，每一行数据中只要有一个字段值不为null，则该数据就会被count函数统计进去
3. 聚合函数也称分组函数，不能直接在**where子句**中使用
4. 聚合函数之间可以相互组合使用

##### 8.分组查询

<span id="fz">[返回快速导航](#head)</span>

**group by关键字**

格式：select 字段 from 数据表 where 条件 group by 分组依据字段 order by 排序依据字段 排序方式

执行优先级：from$\rarr$where$\rarr$group by$\rarr$select$\rarr$order by

由于where的优先级高于group by，因此聚合函数无法在where子句中使用。

示例：

```mysql
# 计算coder数据表中grade各组的score总和
select grade,sum(score) from coder group by grade;

# 规范:使用了group by的语句,select后面的字段只能用作为分组依据的字段及聚合函数,不允许使用其他字段,否则即使不报错,数据结果也会存在问题

# having关键字对group by之后的数据进行处理
# 不同于where,having专门与group by一起使用,而不能单独使用

# 找出coder数据表各grade组中score平均值大于80的记录
select grade,avg(score) from coder group by grade having avg(score)>80;
```







