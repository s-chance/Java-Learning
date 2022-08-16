### MySQL高级

---

#### 一、distinct关键字

distinct能够去除查询结果中重复的记录

注意：数据表中的数据并没有被修改，实际上所有的DQL查询语句都不会修改原始数据，只是对查询结果进行处理

```mysql
# 准备工作
create database if not exists task;
use task;
create table emp (
	id int,
    name varchar(20),
    age int,
    sex char(20),
    salary double
);
alter table emp modify sex char(20) character set gbk;
insert into emp values
(1,'a',19,'男',3500),
(2,'b',22,'男',5600),
(3,'c',34,'女',7700),
(4,'d',16,'男',4300),
(5,'e',51,'女',4300),
(6,'f',23,'女',4300);

# 格式: select distinct 字段名 from 数据表名;
# distinct关键字写在所有字段前面
# 查询salary的值有哪几种情况,不重复列出相同的情况
select distinct salary from emp;
# 对于多个字段,则需要在多个字段的值均重复的条件下才会去重
# 查询数据表中存在的不重复的sex和salary的组合有哪几种情况
select distinct salary,sex from emp;
```

#### 二、连接查询

##### 连接查询的概念

针对一张数据表进行查询，称为单表查询。**join关键字**

将两张及以上的数据表联合起来进行查询，获取到多张数据表组合出来的数据，称为连接查询。

##### 连接查询的分类

```
根据表连接的方式分类
├── 内连接
│   ├── 等值连接
│   ├── 非等值连接
│   └── 自连接
|
├── 外连接
│   ├── 左外连接
│   └── 右外连接
```

##### 笛卡尔积现象

一般是由于没有加任何限制条件直接联合多张表进行查询。查询结果的数量是多张表的乘积，但一般这样的查询没有太大意义，要避免这种情况需要设计好限制条件。

##### 内连接

```mysql
# 准备数据
create database if not exists data;
use data;
create table employee(
	id int,
    name varchar(20),
    salary double,
    department_id int
);
insert into employee values
(1,'apple',5469,101),
(2,'grape',4465,101),
(3,'orange',6544,102),
(4,'mango',4987,102),
(5,'banana',5323,102),
(6,'peach',6743,103);
create table department(
	id int,
    name varchar(20)
);
insert into department values
(101,'develop'),
(102,'operate'),
(103,'loaf');
create table salary_level(
	grade varchar(20),
    min int,
    max int
);
insert into salary_level values
('A',5501,7000),
('B',4001,5500),
('C',2500,4000);
# 等值连接,where后的条件是等值判断
# 查询enployee表中每条记录所对应的department的name
# join前加inner关键字能直接表明这是内连接,当然inner本身可以省略不写
# on关键字类似于where,但on是表示多表的连接条件,而where是表示对连接结果进一步筛选的条件,where写在on的后面
select e.name,d.name from employee e join department d on e.department_id=d.id;

# 非等值连接,where后的条件一般是在某个范围内判断
# 查询employee表中每条记录所对应的salary_level的grade
select e.name,e.salary,s.grade from employee e inner join salary_level s on e.salary between s.min and s.max;

# 自连接,本质上是一张表,但进行了重复使用
# 新增数据
insert into employee (id,name) values
(101,'leader_jackson'),
(102,'leader_vim'),
(103,'leader_fish');
# 查询employee表中department_id对应leader_name和name记录
select e1.name 'emp',e2.name 'leader' from employee e1 join employee e2 on e1.department_id=e2.id;
# 一般需要使用自连接查询的话,说明表的设计还能进一步优化
```

##### 外连接

```mysql
# 内连接的多张表并没有主次关系,也就是说不需要考虑查询语句书写的先后顺序
# 外连接分左外连接left join和右外连接right join,left或right关键字不可省略,表示将join关键字左右的数据表视为主表,当然也可以通过调整语句书写的先后顺序改变主次关系
# 主表指定的数据会全部被查询,在此基础上再查询部分相关的次表的数据,也就是说指定查询的主表数据不会因为on的连接条件而有所缺失,但会受到where筛选条件的影响

# 以employee为主表查询所有记录数
select * from employee e left join department d on e.department_id=d.id;
# 以department为主表查询所有记录数
select * from employee e right join department d on e.department_id=d.id;

# 通过对比相同的数据表在内外连接两种情况下的不同查询结果,可以找到主表中还未与次表建立逻辑关系的单独的数据
```

##### 更多表连接（三张表）

```mysql
# 三张及以上数据表连接查询,多个连接条件一般都与第一张表相关联,内外连接可以混合使用
# 查询employee、department、salary_level的联合数据
# 查询employee中department_id对应的department表数据,salary对应的salary_level表数据
select e.name,e.salary,d.name,s.grade from employee e join department d on e.department_id=d.id join salary_level s on e.salary between s.min and s.max;
```

#### 三、子查询

##### 子查询的概念

DQL语句中嵌套DQL语句，被嵌套的DQL语句称为子查询。

##### 子查询的使用

子查询可写在**select**、**from**、**where**关键字后面。

```mysql
# where子句中的子查询,一般子查询结果是某个值
# 查询employee表中大于平均值的salary记录,先查询出avg(salary)的值
select salary from employee where salary>(select avg(salary) from employee);

# from子句中的子查询,把子查询结果视为一张新的数据表
# 查询employee表中每个department_id对应的avg(salary)的grade,先查询出每个department_id的avg(salary)
select e.*,s.grade from (select department_id,avg(salary) avg from employee group by department_id) e join salary_level s on avg between s.min and s.max;

# select后的子查询,一般不经常使用,了解即可
# 该子查询只能返回一条记录
select e.name,e.salary,(select avg(salary) from employee) avg from employee e;
```

#### 四、union关键字

**union关键字**能合并结果集，将多表查询的结果直接拼接起来，但多张表必须保持字段数一致。字段值在没有特殊逻辑关系下也要对应起来。

```mysql
# union和join
# 将employee中salary大于5000的结果集和department_id为101的结果集合并起来,会自动去重
select name from employee where salary > 5000 union select name from employee where department_id=101;

# 关于union和or关键字的区别
# union能够实现多表查询(前提多张表的字段能够对应),而or只能在一张表里使用
# union会自动去重,or不会去重而是直接取查询结果的并集(实际大部分情况下两者结果区别不大)
# union能够使用不同的索引查询,索引即where后面所用到的字段,而or因为是针对一张表所以只能使用一个索引,一个where后仅能有一个索引,有多个字段时取其一作为索引

# 一般情况下,数据量较大时(包括单表的数据量和数据表的数量)推荐使用union,多个查询条件涉及到的是同一个字段时推荐使用or
```

#### 五、limit关键字

##### limit的作用

将结果集的部分数据展示出来，常用于网页开发分页查询中

##### 关键字执行优先级

执行优先级：from$\rarr$where$\rarr$group by$\rarr$having$\rarr$select$\rarr$order by$\rarr$**limit**

##### limit的使用

```mysql
# 格式:limit 开始下标(缺省的话,默认从0开始),长度(即数据条数)
# 查询employee表前2条数据
select * from employee limit 2; # 简写,实际上是limit 0,2;
select * from employee limit 0,2;
# 查询employee表第2-4条数据,下标从1开始起的3条数据
select * from employee limit 1,3;

# limit在order by之后执行,所以order by的依据和排序方式会一定程度上影响limit的结果集
# 查询以name升序排序之后的结果集的前2条数据
select * from employee order by name asc limit 2;
# 查询以salary降序排序之后的结果集的前2条数据
select * from employee order by salary desc limit 2;

# 分页查询的公式:limit (pageNum-1)*pageSize,pageSize
```

#### 六、约束

##### 约束的概念

约束（constraint）是用于保证数据完整性、有效性的一种规则。

##### 多种约束规则

非空：not null

唯一：unique

主键：primary key（PK）

外键：foreign key（FK）

检查：check（MySQL不支持，Oracle支持）

##### 约束的使用

```mysql
# 非空 not null
# 非空约束的字段不能为null
drop table if exists con;
create table con(
	id int,
    name varchar(20) not null
);

insert into con(id,name) values (1,'a');
insert into con(id,name) values (2,null); # 出错,name不能为null
insert into con(id) values (3); # 出错,name没有默认值

# 唯一性 unique
# 唯一性约束的字段不能重复
drop table if exists con;
create table con(
	id int,
    name varchar(20) unique
);

insert into con(id,name) values (1,'a');
insert into con(id,name) values (2,'a'); # name不能出现重复的值
insert into con(id) values (3,null); # name可以为null,且null不属于值重复

# 多字段各自唯一(列级约束,每个约束仅对单个字段有效)
# name不能重复且email也不能重复
drop table if exists con;
create table con(
	id int,
    name varchar(20) unique,
    email varchar(20) unique
);
# 测试数据可以直接用下面的

# 多字段组合唯一(表级约束,每个约束对整张表有效,多用于给多个字段添加联合约束)
# name和email的组合不能重复
drop table if exists con;
create table con(
	id int,
    name varchar(20),
    email varchar(20),
    unique(name,email)
);

insert into con(id,name,email) values (1,'a','a@123.com');
insert into con(id,name,email) values (2,'a','a@456.com');
insert into con(id,name,email) values (3,'b','b@123.com');
insert into con(id,name,email) values (4,'a','a@456.com');

# not null和unique联合
drop table if exists con;
create table con(
	id int,
    name varchar(20) not null unique
);
desc con;
insert into con(id,name) values (1,'abc');
insert into con(id,name) values (2,'abc'); # 出错,name不能重复
insert into con(id,name) values (3,null); # 出错,name不能为null

# 主键 primary key
# 主键字段不能重复且不能为null,类似于unique联合not null但不完全相同
# 根据设计规范,一张表应该存在且只能存在一个主键,主键通常是int、bigint、char等类型的字段,不建议使用varchar类型字段作为主键
# 单一主键,列级约束,一般开发中经常使用
drop table if exists con;
create table con(
	id int primary key,
    name varchar(20)
);
desc con;
# 测试数据可以直接用下面的

# 复合主键,表级约束,由于复合主键涉及多字段,逻辑比较复杂,一般开发中不会使用
drop table if exists con;
create table con(
	id int,
    name varchar(20),
    primary key(id,name)
);
desc con;

insert into con(id,name) values (1,'a');
insert into con(id,name) values (1,'a'); 
insert into con(id,name) values (1,'b'); 
insert into con(id,name) values (2,'a'); 
insert into con(id,name) values (3,null);
insert into con(name) values (null,'a');

# 主键自动递增,这里主键值默认从1开始,按1递增
# 如果insert中途指定了主键值,则从该主键值开始按1递增,如果指定了较小的主键值,会自动升序排序
drop table if exists con;
create table con( 
	id int primary key auto_increment,
    name varchar(20)
);
desc con;
insert into con(name) values ('a');
insert into con(name) values ('b');
insert into con(name) values ('c');
# 此外,主键还能分为自然主键和业务主键,自然主键使用较多,业务主键较少

# 外键 foreign key
# 外键涉及到两张相互有逻辑关系的数据表,主要是为了保证两张表的逻辑关系有效
# 外键关联的两张表有父表和子表之分
# 删除数据时先子表后父表,新增数据时先父表后子表,删除表时先子表后父表,创建表时先父表后子表
drop table if exists son;
drop table if exists dad;
create table dad(
	no int primary key,
    name varchar(20)
);
create table son(
	id int primary key auto_increment,
    name varchar(20),
    dad_no int,
    foreign key(dad_no) references dad(no)
);
insert into dad(no,name) values (001,'fruit');
insert into dad(no,name) values (002,'animal');

insert into son(name,dad_no) values ('apple',001);
insert into son(name,dad_no) values ('pear',001);
insert into son(name,dad_no) values ('cat',002);
insert into son(name,dad_no) values ('rabbit',002);
# 另外被子表references的父表字段不一定是主键,但至少具有unique的约束
```

#### 七、存储引擎

##### 存储引擎的概念

存储引擎是MySQL中特有的术语，表示一个数据表存储、组织数据的方式。不同的存储引擎，数据表存储数据的方式不同。

##### 存储引擎的使用

```mysql
# 准备工作
drop table if exists engine;
create table if not exists engine(
	id int primary key auto_increment,
    name varchar(20)
);
# 查看存储引擎,MySQL默认存储引擎为InnoDB
show create table engine;

# 在创建表时指定存储引擎
drop table if exists engine;
create table engine(
	id int primary key auto_increment,
    name varchar(20)
)engine=innodb default charset=gbk;
show create table engine;

# 查看MySQL版本
select version();
# 查看支持的存储引擎,不同的MySQL版本支持的存储引擎可能不一样
show engines;
```

##### 常用存储引擎介绍

###### MyISAM存储引擎

使用三种文件来表示每个数据表：

- 格式文件(.frm)：存储表结构的定义
- 数据文件(.myd)：存储表行的内容
- 索引文件(.myi)：存储表上索引（主键或unique约束字段会自动创建索引）

特点：可以被转换为压缩，只读表里节省空间，但不支持事务，安全性低

###### InnoDB存储引擎

**一般开发中最优先考虑的存储引擎**，重量级的存储引擎，管理的数据表有以下特征：

- 每个数据表在数据库目录中以.frm格式的文件表示
- 提供一组用于记录事务性获得的日志文件
- 通过commit、savepoint和rollback支持事务处理
- 提供全ACID兼容
- 在MySQL服务器崩溃后能够自动恢复
- 多版本MVCC和行级锁定
- 支持外键级引用的完整性，包括级联删除和更新

特点：支持事务，以保证数据的安全性，但效率不高，不能压缩不能转换为只读，比较占存储空间

###### MEMORY存储引擎

MEMORY存储引擎以前称为heap存储引擎，管理数据库有以下特征：

- 在数据库目录内，每个数据表均以.frm格式的文件表示
- 表的数据以及索引被存储在内存中（这显著提升了查询速度）
- 表级锁机制
- 不支持text和blob字段

特点：字段长度固定，数据存储在内存，这使得它的数据处理效率非常高，但同时一旦MySQL服务重启，存储数据就会丢失，**一般开发中只用于临时存储数据**。

#### 八、事务、视图、数据库设计

##### 事务(transaction)

1. 事务的概念：一个事务就是一个完整的业务逻辑，是一个不可再分的最小的工作单元。例如，银行转账，A向B转账1000，A扣除1000，B增加1000。可以用两个update语句实现，但它们必须同时成功或者失败，而不能单独拆分，否则就不构成一个完整的业务逻辑，这就是一个最小的工作单元。
2. 只有在使用DML语句时才会涉及到事务，因为只有DML语句会增加、删除、修改数据表的数据，这就离不开事务安全性的考虑。
3. 简单理解事务：就是要使多条DML语句同时成功或失败的一种规则。

4. 如何实现事务

   ```mysql
   # InnoDB存储引擎提供了一组用来记录事务性活动的日志文件
   # 在事务的执行过程中,每一条DML的操作都会记录到“事务性活动的日志文件”中
   # 在事务的执行过程通过提交事务或者回滚事务就能实现事务要求的规则
   
   # MySQL默认是自动提交事务,即每执行一条DML语句就提交一次,但这不符合开发习惯
   # 关闭自动提交机制 start transaction(仅对一次事务有效)
   # 或者直接设置开启或关闭自动提交(对所有事务有效)
   set autocommit=0; # 关闭自动提交
   set autocommit=1; # 开启自动提交
   # 提交事务commit,回滚事务rollback
   # 准备工作
   drop table if exists test;
   create table test(
   	id int primary key auto_increment,
       name varchar(20)
   );
   select * from test;
   
   start transaction; # 关闭自动提交机制,commit之后需要重新执行
   insert into test(name) values ('a');
   insert into test(name) values ('b');
   insert into test(name) values ('c');
   select * from test;
   
   rollback; # 回滚事务
   select * from test; # 未提交的事务消失
   
   insert into test(name) values ('d');
   commit; # 提交事务
   select * from test;
   
   rollback;
   select * from test; # 已经提交的事务,无法回滚
   ```

5. 事务的4个特性（ACID）

   A：原子性，事务是最小的工作单元，不可再分。

   C：一致性，在同一个事务中，所有操作必须同时成功或者失败，保证数据的一致性。

   I：隔离性，A事务与B事务之间存在一定的隔离，根据隔离性可分成4个隔离级别。

   - 读未提交：read uncommitted（隔离级别最低）

     事务A能够读取事务B**未提交的数据**，这种隔离级别存在读取到脏数据的问题，即读取到并不需要的数据。一般开发中不会使用这个隔离级别。

   - 读已提交：read committed

     事务A只能读取事务B**已提交的数据**，这种隔离级别避免了脏读问题，但存在不可重复读取数据的问题，事务B再做任何提交操作之后，事务A读取的数据就会相应地发生改变。读取的数据是比较真实的数据，这是**Oracle数据库默认的隔离级别**。

   - 可重复读：repeatable read

     事务B开启后，每次从事务B读取的数据都是一致的，即使事务B的数据修改并提交，事务A所**读取到的数据都是事务B刚开始事务时的数据**。这种隔离级别避免了不可重复读的问题，但出现了幻影读的问题，即每次读取到的数据都不是当前的真实数据，这是**MySQL默认的隔离级别**。

   - 序列化/串行化：serializable（最高隔离级别）

     效率最低，但解决了上面存在的所有问题。这种隔离级别的事务需要排队，不能并发。synchronized线程同步（事务同步），每次读取到的数据都是最真实的，效率也是最低的。

   D：持久性，事务完成的保障，事务提交之后，数据就被持久地保存下来。

6. 隔离级别验证

   ```mysql
   # 在同一个命令行或同一个查询下可能无法展示出隔离级别的效果,建议事务A和事务B各打开一个命令行或者在navicat下各新建一个查询
   # 建议每次重新设置隔离级别之后重启命令行或navicat刷新
   # 查看隔离级别
   select @@tx_isolation;
   
   # 准备工作
   create table isolation_level(
   	name varchar(20)
   );
   
   # read uncommitted 读未提交
   # 设置全局隔离级别为read uncommitted
   set global transaction isolation level read uncommitted;
   # 事务A
   start transaction;
   select * from isolation_level;
   # 事务B
   start transaction;
   insert into isolation_level values ('hello');
   # 事务A
   select * from isolation_level; # 读取到了未提交的数据
   
   # read committed 读已提交
   # 设置全局隔离级别为read committed
   set global transaction isolation level read committed;
   # 事务A
   start transaction;
   select * from isolation_level;
   # 事务B
   start transaction;
   insert into isolation_level values ('world');
   # 事务A
   select * from isolation_level; # 未读取到事务B的数据
   # 事务B
   commit;
   # 事务A
   select * from isolation_level; # 读取到了事务B提交的数据
   
   # repeatable read 可重复读
   # 设置全局隔离级别为repeatable read
   set global transaction isolation level repeatable read;
   # 事务A
   start transaction;
   select * from isolation_level;
   # 事务B
   start transaction; # 第一次开启事务
   insert into isolation_level values ('read');
   # 事务A
   select * from isolation_level;
   # 事务B
   insert into isolation_level values ('repeat');
   # 事务A
   select * from isolation_level;
   # 事务B
   commit;
   # 事务A
   select * from isolation_level; # 事务A读取到的始终是事务B第一次开启事务时的数据
   # 事务A
   commit;
   select * from isolation_level; # 事务A也提交后再查询,就能获取事务B的最近一次事务提交的数据
   # 补充说明:事务B第一次开启事务这个概念是以事务A开启事务后事务B第一次执行start transaction为准,也就是当事务A提交之后再次开启事务,重新计算事务B第一次开启事务
   
   # serializable 序列化
   # 设置全局隔离级别为serializable
   set global transaction isolation level serializable;
   # 事务A
   start transaction;
   select * from isolation_level;
   # 事务B
   start transaction;
   insert into isolation_level values ('serializable'); # 卡住,因为事务A没有提交
   # 事务A
   commit; # 提交事务A后事务B新增数据完成
   start transaction; # 事务A重新开启事务
   select * from isolation_level; # 卡住或超时报错,因为事务B没有提交
   # 事务B
   commit; # 提交事务B后事务A查询完成视图
   ```

##### 视图(view)

1. 视图的概念

   从多个角度观察处理同一份数据，每一个角度就是一种视图。  例如，对同一份数据进行不同的处理，根据不同的需求展示出相应部分的数据或者根据不同的权限展示出每个权限被允许接触到的数据。

2. 视图的使用

   ```mysql
   # 准备工作
   drop table if exists origin;
   create table origin(
   	id int primary key auto_increment,
       name varchar(20),
       age int,
       department varchar(20)
   );
   
   insert into origin(name,age,department) values
   ('apple',13,'developer'),
   ('orange',14,'operator');
   # 先备份原表,复制原表
   create table origin_backup select * from origin;
   
   # 创建视图对象,需要as关键字,且只能通过DQL语句创建
   create view origin_view as select * from origin;
   # 删除视图对象
   drop view origin_view;
   
   # 对视图对象的增删改查会映射到原表的数据上
   # 查询视图
   select * from origin_view;
   # 新增视图数据
   insert into origin_view(name,age,department) values
   ('mango',12,'manager'),
   ('banana',16,'admin');
   # 查询原表
   select * from origin;
   # 更新视图数据
   update origin_view set age=20 where name='mango';
   select * from origin;
   # 删除视图数据
   delete from origin_view;
   select * from origin;
   ```

3. 视图对象的实际开发用途

   - 视图的使用能够有效简化开发，方便维护，提高开发效率
   - 单独的SQL语句只能针对一张数据表的数据进行修改，而视图的使用将多张表的数据集中到一个视图，通过对这个视图数据的修改，就能一次性实现对多张表数据的修改，而不需要每一张数据表重复写一条SQL语句去修改
   - 另外对于后期大量数据表的维护，只需要重新修改视图对象所映射的DQL语句就能灵活地指定需要维护的数据表的数据

##### 数据库设计：三大范式

###### 三大范式的概念

范式是数据库数据表的设计依据，是一种规范和统一标准。设计数据库表时，按照以下3种范式进行，可以避免表中数据的冗余，空间的浪费。

###### 第一范式

第一范式：要求任何一张表必须有主键，每一个字段原子性不可再分。

字段原子性是指字段数据不能再拆分，例如，联系方式字段下的数据同时出现手机号和邮箱两个联系方式，说明联系方式字段还能拆分未手机号和邮箱两个字段。

###### 第二范式

第二范式：建立在第一范式的基础之上，要求所有非主键字段完全依赖主键，
不要产生部分依赖。

部分依赖通常出现在多对多逻辑关系(例如多个学生对应多个教师)的数据表中，假设把学生编号和教师编号设置为复合主键，学生依赖学生编号，教师依赖教师编号，这就产生了部分依赖(**部分依赖产生的根源就是复合主键的存在，因此设计中一般不建议使用复合主键**)。从根本上解决这个问题，就需要将这一张数据表分成学生表，教师表以及关系表三张数据表，并在关系表中设置学生表和教师表两个外键。

###### 第三范式

第三范式：建立在第二范式的基础之上，要求所有非主键字段直接依赖主键，
不要产生传递依赖。

传递依赖通常出现在一对多逻辑关系(例如一个班级对应多个学生)的数据表中，假设学生编号为主键，班级名称依赖班级编号，而一个班级编号依赖多个学生编号，这就产生了传递依赖。为了解决这个问题，就需要将这一张数据表分成学生表和班级表，外键则设置在数据相对较多的数据表中。

###### 数据表设计总结

- 一对多，两张表，数据多的加外键

- 多对多，三张表，关系表两个外键

- 另外对于一对一逻辑关系的数据表，如果字段数过多也建议进行表的拆分。一般拆分成两张表，这时只需要在其中一张表中添加一个唯一性约束(一对一逻辑关系的数据表理论上不可能出现重复的外键字段值)的外键字段即可，外键字段通常链接的是另一张表的主键字段。

最后，数据库设计三大范式也只是理想上的标准。实际开发中，结合实际需求，有必要牺牲一部分存储空间、规范等来换取更高的开发效率和更好的使用体验，这才是数据库数据表设计的最高目的。



















