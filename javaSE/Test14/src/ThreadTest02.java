public class ThreadTest02 {
    public static void main(String[] args) {
        //常用方法
        //start启动线程
        //run线程内部定义的内容
        //getName获取线程名
        //setName设置线程名
        //currentThread当前线程
        //yield暂时释放指定线程的执行权
        //join另一个线程加入使当前线程暂停执行
        //sleep指定时间线程暂停执行
        //isAlive当前线程是否存活

        MThread mThread = new MThread();
        mThread.setName("线程一");
        mThread.start();

        MThread mThread1 = new MThread();
        mThread1.setName("线程二");
        mThread1.start();

        //线程还未执行完时为true
        System.out.println("before:"+mThread.isAlive());

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

            //join另一个线程加入使当前线程暂停执行
            if (i == 17) {
                try {
                    //在执行完mThread之前main不会执行
                    mThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //线程执行完后变为false
        System.out.println("after:"+mThread.isAlive());

    }
}

class MThread extends Thread {
    @Override
    public void run() {


        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

            //sleep指定时间线程暂停执行
//            if (i == 19) {
//                try {
//                    //当前线程暂停5秒
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            //yield暂时释放指定线程的执行权
            //需要注意的是yield释放的当前线程仍可能再次选中执行,即存在随机性
            if (i == 19) {
                yield();
            }
        }
    }
}