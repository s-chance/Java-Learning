public class DeadLockTest {
    //死锁问题
    //不同线程占用对方的同步资源,形成死锁,所有线程均处于阻塞状态

    //这里模拟一下死锁的情景,直接使用匿名内部类
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();


        //通过运行结果发现程序一直处于运行状态而没有自动结束,说明目前所有的线程均进入了阻塞状态
        new Thread() {
            @Override
            public void run() {
                synchronized (stringBuffer) {
                    stringBuffer.append("a");
                    System.out.println("stringBuffer = " + stringBuffer);
                    stringBuffer1.append("1");
                    System.out.println("stringBuffer1 = " + stringBuffer1);
                }

                try {
                    //会增加死锁出现的几率
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (stringBuffer1) {
                    stringBuffer.append("b");
                    System.out.println("stringBuffer = " + stringBuffer);
                    stringBuffer1.append("2");
                    System.out.println("stringBuffer1 = " + stringBuffer1);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (stringBuffer1) {
                    stringBuffer.append("c");
                    System.out.println("stringBuffer = " + stringBuffer);
                    stringBuffer1.append("3");
                    System.out.println("stringBuffer1 = " + stringBuffer1);
                }

                try {
                    //会增加死锁出现的几率
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (stringBuffer) {
                    stringBuffer.append("d");
                    System.out.println("stringBuffer = " + stringBuffer);
                    stringBuffer1.append("4");
                    System.out.println("stringBuffer1 = " + stringBuffer1);
                }
            }
        }).start();
    }
}
