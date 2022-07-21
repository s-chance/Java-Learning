public class RunnableTest {
    public static void main(String[] args) {

        RThread rThread = new RThread();
        Thread thread = new Thread(rThread);

        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                //Thread.currentThread().getName()获取当前Thread线程的默认名字
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


//多线程创建
//方式二:实现Runnable接口,需要Thread类的构造器
class RThread implements Runnable {

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