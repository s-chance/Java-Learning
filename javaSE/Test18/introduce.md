### 注解
#### 三个内置注解
@Override 重写方法  
@Deprecated 表示某个元素(类、方法等)已过时  
@SuppressWarnings 用于抑制编译器产生警告信息
#### 元注解
@Target 指定一个注解的使用范围  
@Retention 描述注解的生命周期,也就是该注解被保留的时间长短  
@Documented 表示是否将我们的注解生成在java文档中  
@Inherited 指定该注解可以被继承
#### 自定义注解
@interface  
定义注解的关键字是@interface  
自定义注解中可以定义多个配置参数,说明参数的名称,以及参数值的类型  
如果只有一个配置参数,一般命名为value  
如果配置参数是value,并且只有一个配置参数,value可以省略