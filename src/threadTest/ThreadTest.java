package threadTest;

/**
 * Created by zhangyn on 2016/7/4.
 */
public class ThreadTest extends Thread{

    @Override
    public void run() {
        synchronized (ThreadTest.class) {
            System.out.println(Thread.currentThread().getName() + "线程开始执行");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    sleep((int) Math.random() * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
        }
    }


    public static void main(String[] args) {
        ThreadTest a = new ThreadTest();
        ThreadTest b = new ThreadTest();
        Thread t1 = new Thread(a,"t1");
        Thread t2 = new Thread(b,"t2");
        t1.start();
        t2.start();
    }
}
