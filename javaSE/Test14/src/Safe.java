public class Safe {
    public static void main(String[] args) {
        //线程安全问题(待解决)

        //假设有100元,每次一元地分给三个人

        //目前存在的问题是一共只有100元,但是三个线程同时执行会出现混乱,
        //即金额最后分完应该为零,但最后的结果并不为零,这时候无法判断金额是否分完

        MyThread00 myThread1 = new MyThread00();
        MyThread00 myThread2 = new MyThread00();
        MyThread00 myThread3 = new MyThread00();

        myThread1.setName("A");
        myThread2.setName("B");
        myThread3.setName("C");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}


class MyThread00 extends Thread {

    private static int money = 100;
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {

            System.out.println(Thread.currentThread().getName()+":"+money);
            if (money == 0) {
                break;
            }
            money--;
        }
    }
}