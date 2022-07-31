public class ThreadTest03 {
    public static void main(String[] args) {
        //线程优先级
        //线程调度
        //调度方式:分时调度模型  抢占式调度模型(java所使用的模型)
        //随机性
        //相关方法
        //getPriority
        //setPriority


        ThreadTest threadTest = new ThreadTest();
        //getPriority获取当前线程优先级,默认为5    优先级范围:1-10
        int priority = threadTest.getPriority();
        System.out.println("priority = " + priority);
        //setPriority设置当前线程优先级
        //不过即使设置优先级最大,也不一定最先执行,即仍存在随机性
        threadTest.setPriority(Thread.MAX_PRIORITY);

        threadTest.start();


        ThreadTest threadTest1 = new ThreadTest();
        threadTest1.setPriority(Thread.MIN_PRIORITY);
        threadTest1.start();

        System.out.println("after setting:"+threadTest.getPriority());
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}