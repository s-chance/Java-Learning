### Jedis
#### 概念
jedis是一款java操作redis数据库的工具, 关于redis的下载和redis的基本使用可以访问[相关文章](https://s-chance.github.io/2022/09/14/Redis%E5%9F%BA%E7%A1%80/#more)  
#### 简单使用
注意: 请在下载完redis后并确保redis服务器已经启动的情况下, 执行代码进行测试  
redis默认端口号: 6379
> 1.在WEB-INF目录下导入jar包: `jedis-2.7.0.jar`
>
> 2.编写代码[示例](src/com/entropy/test/JedisTest.java)

### JedisPool
#### 概念
Jedis连接池, 类似关系型数据库连接池, 能够提高资源利用效率和访问速度, 应对高并发  
#### 简单使用
> 1.导入jar包: `commons-pool2-2.3.jar`
>
> 2.测试代码[示例](src/com/entropy/test/JedisPoolTest.java)
#### 工具类制作
> 1.准备[配置文件](src/jedis.properties)
>
> 2.编写工具类[代码](src/com/entropy/util/JedisPoolUtil.java)
>
> 3.测试
### 案例
#### 准备工作  
配置文件: `druid.properties`、`jedis.properties`  
sql测试数据文件: [province.sql](province.sql)  
js文件: `jquery-3.3.1.min.js`、`jquery-migrate-1.0.0.js`  
jar包: 
> jedis以及jedis连接池:  
> `jedis-2.7.0.jar`  
> `commons-pool2-2.3.jar`
>
> MySQL以及druid连接池:  
> `mysql-connector-java-5.1.37-bin.jar`  
> `druid-1.0.9.jar`
>
> JdbcTemplate:  
> `commons-logging-1.2.jar`  
> `spring-beans-5.0.0.RELEASE.jar`  
> `spring-core-5.0.0.RELEASE.jar`  
> `spring-jdbc-5.0.0.RELEASE.jar`  
> `spring-tx-5.0.0.RELEASE.jar`
> 
> Jstl:  
> `javax.servlet.jsp.jstl.jar`  
> `jstl-impl.jar`
>
> BeanUtils:  
> `commons-beanutils-1.8.3.jar`
>
> Json:  
> `jackson-annotations-2.2.3.jar`  
> `jackson-core-2.2.3.jar`  
> `jackson-databind-2.2.3.jar`
#### 编写一个简易的javaWeb项目
只需包含一个查询功能即可
#### 用Jedis进行改造
主要针对service层、web层的servlet进行改造
### 补充
- redis缓存的一般是一些不会频繁更新的数据, 例如归档的博客文章等
- MySQL数据库的数据一旦发生变化, 则redis也需要相应地更新缓存
- 对MySQL数据库的数据进行非查询的操作, 即增删改, 则需要清空redis缓存, 重新存储
- 涉及到数据本身改动的操作, 一般会在service层执行删除redis数据的操作以保证redis数据的时效性

### 再次提醒: 在测试代码之前请确保redis服务器端已经启动