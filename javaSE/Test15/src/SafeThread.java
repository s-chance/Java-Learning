public class SafeThread {
    public static void main(String[] args) {


        //发现直接将Runnable的同步代码块移植到Thread来会出错,且出现了更加严重的情况
        //关于Runnable和Thread的同步实现,关键在于同步监视器

        //通过Runnable接口实现多线程,只需要创建实现Runnable接口的对象一次,之后只需要Thread构造器即可
        //而通过Thread类实现多线程,需要多次创建继承Thread的对象
        //也就是说this在Runnable中只会指代唯一一个对象,而在Thread中则会指代多个对象

        //如何用同步代码块实现Thread同步,就需要用到java反射特性
        //这样就实现了Thread同步

        TThread tThread = new TThread();
        TThread tThread1 = new TThread();
        TThread tThread2 = new TThread();
        tThread.start();
        tThread1.start();
        tThread2.start();
    }
}

class TThread extends Thread {
    private static int num = 100;

    @Override
    public void run() {
        while (true) {
            //方式一:同步代码块 synchronized+同步监视器(锁)

            //通过java反射直接指向类本身
//            synchronized (TThread.class) {
//                if (num > 0) {
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+":"+num);
//                    num--;
//                } else {
//                    break;
//                }
//            }

            if (num > 0) {
                show();
            } else {
                break;
            }
        }
    }

    //方式二:同步方法
    //同步方法实现同步和用同步代码块实现同步类似地需要用到同步监视器,不过同步方法不会直接表示出来

    //同样地,Runnable的同步方法不能直接移植过来使用

    //需要把方法改为静态方法
    public static synchronized void show() {
        if (num > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + num);
            num--;
        }
    }
}