package threadTest;

/**
 * Created by zhangyn on 2016/7/5.
 */
public class TestTwoThreads {

    private boolean flag = false;

    public synchronized void printA() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "A");
        flag = true;
        notify();
    }

    public synchronized void printB() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "B");
        flag = false;
        notify();
    }

    static class ThreadA extends Thread {
        private TestTwoThreads testTwoThreads;

        public ThreadA(TestTwoThreads testTwoThreads) {
            this.testTwoThreads = testTwoThreads;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                testTwoThreads.printA();
            }
        }
    }

    static class ThreadB extends Thread {
        private TestTwoThreads testTwoThreads;

        public ThreadB(TestTwoThreads testTwoThreads) {
            this.testTwoThreads = testTwoThreads;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                testTwoThreads.printB();
            }
        }
    }

    public static void main(String[] args) {
        TestTwoThreads test = new TestTwoThreads();
        ThreadA threadA = new ThreadA(test);
        ThreadB threadB = new ThreadB(test);
        threadA.start();
        threadB.start();
    }
}
