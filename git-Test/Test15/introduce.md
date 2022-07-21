多线程

线程的生命周期

新建、就绪、运行、阻塞、死亡  
新建Thread调用start方法进入就绪  
获取CPU执行权开始运行  
运行时失去CPU执行权或调用yield方法重新进入就绪  
运行时调用sleep、join等方法进入阻塞  
阻塞状态下sleep、join等方法执行完重新进入就绪  
运行完run方法最终进入线程的死亡  

线程安全问题  
解决方法:线程的同步  
方式一:同步代码块 synchronized+同步监视器(锁)  
方式二:同步方法  

锁Lock  
Lock在java中是一个接口,其实现类为ReentrantLock  
加锁lock 解锁unlock

synchronized与lock都用于解决线程安全问题  
不同的是synchronized在执行完之后自动释放同步监视器,
而lock需要手动实现

死锁问题  
不同线程占用对方的同步资源,形成死锁,所有线程均处于阻塞状态

线程通信  
常用方法(需要在同步代码块或同步方法中才能使用)  
wait
notify
notifyAll
