public class SafeRunnable {
    public static void main(String[] args) {
        //线程安全问题
        //解决方法:线程的同步
        //方式一:同步代码块 synchronized+同步监视器(锁)
        //Runnable接口实现同步

        //先复现一下之前的线程安全问题,数字有重复,且出现了本来不应该出现的数字

        //使用了synchronized之后,线程安全问题得以解决
        //再来实现继承Thread的方式如何同步

        RThread rThread = new RThread();
        Thread thread = new Thread(rThread);
        Thread thread1 = new Thread(rThread);
        Thread thread2 = new Thread(rThread);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class RThread implements Runnable {

    private static int num = 100;

    @Override
    public void run() {
        while (true) {
            //方式一:同步代码块 synchronized+同步监视器(锁)
            //这里的this指代唯一的RThread对象,由它本身作为同步监视器
//            synchronized (this) {
//
//                //这里就是同步代码块
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

    public synchronized void show() {
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