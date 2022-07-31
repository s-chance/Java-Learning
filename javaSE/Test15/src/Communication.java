public class Communication {
    public static void main(String[] args) {
        //线程通信
        //常用方法(需要在同步代码块或同步方法中才能使用)
        //wait等待,使线程进入阻塞状态,与sleep不同,wait会释放同步监视器
        //notify唤醒wait中的线程
        //notifyAll唤醒所有

        //通过wait和notify的组合可以实现线程一次交替执行,而不会出现一个线程连续执行的情况,除非只有一个线程
        CommunicationThread communicationThread = new CommunicationThread();
        Thread thread = new Thread(communicationThread);
        Thread thread1 = new Thread(communicationThread);
        Thread thread2 = new Thread(communicationThread);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class CommunicationThread implements Runnable {

    private static int num = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                //唤醒线程
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num--;
                    try {
                        //这边如果只用wait那么所有线程都会进入阻塞,形成变相的“死锁”
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}