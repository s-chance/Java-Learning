多线程
多个线程并发执行

并发和并行
并发:同一时刻,多个指令在单个CPU上交替执行
并行:同一时刻,多个指令在多个CPU上同时执行

多线程创建
方式一:继承Thread类
重写run方法
使用start方法

使用匿名内部类调用一次

常用方法
start
run
getName
setName
currentThread
yield
join
sleep
isAlive

线程优先级
线程调度
调度方式:分时调度模型  抢占式调度模型(java所使用的模型)
随机性
相关方法
getPriority
setPriority

多线程创建
方式二:实现Runnable接口,需要Thread类的构造器

线程安全问题(待解决)





