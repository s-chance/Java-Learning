import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        //锁Lock
        //Lock在java中是一个接口,其实现类为ReentrantLock
        //加锁lock 解锁unlock

        //同步监视器实际上也是一种锁
        //这边演示一下用原生的锁实现同步


        lockThread lockThread = new lockThread();
        Thread thread = new Thread(lockThread);
        Thread thread1 = new Thread(lockThread);
        Thread thread2 = new Thread(lockThread);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class lockThread implements Runnable {

    private static int num = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {


        try {
            lock.lock();
            while (true) {
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num--;
                } else {
                    break;
                }
            }
        } finally {
            //synchronized与lock都用于解决线程安全问题
            //不同的是synchronized在执行完之后自动释放同步监视器,
            //而lock需要手动实现
            lock.unlock();
        }
    }
}