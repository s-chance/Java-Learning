public class ThreadTest01 {
    public static void main(String[] args) {
        //多线程创建
        //方式一:继承Thread类
        //重写run方法
        //使用start方法

        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

        //使用匿名内部类调用一次
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 1) {
                        //Thread.currentThread().getName()获取当前Thread线程的默认名字
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}

//继承Thread类
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
    //重写run方法   Alt insert快捷键重写方法
}