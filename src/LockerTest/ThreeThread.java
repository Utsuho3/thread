package LockerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyn on 2016/7/8.
 * 轮流打印 ABCABC 10遍
 */
public class ThreeThread {
    private static int state = 0;
    private static int count = 0;
    Lock l = new ReentrantLock();

    static class PrintA implements Runnable {
        private ThreeThread threeThread = new ThreeThread();

        @Override
        public void run() {
            threeThread.printA();
        }
    }

    static class PrintB implements Runnable {
        private ThreeThread threeThread = new ThreeThread();

        @Override
        public void run() {
            threeThread.printB();
        }
    }

    static class PrintC implements Runnable {
        private ThreeThread threeThread = new ThreeThread();

        @Override
        public void run() {
            threeThread.printC();
        }
    }

    public void printA() {
        while (count < 9) {
            l.lock();
            if (state == 0) {
                System.out.printf("A");
                count++;
                state = 1;
            }
            l.unlock();
        }
    }

    public void printB() {
        while (count < 9) {
            l.lock();
            if (state == 1) {
                System.out.printf("B");
                state = 2;
            }
            l.unlock();
        }
    }

    public void printC() {
        while (count < 9) {
            l.lock();
            if (state == 2) {
                System.out.printf("C");
                state = 0;
            }
            l.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> a = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new PrintA());
        executorService.execute(new PrintB());
        executorService.execute(new PrintC());
        executorService.shutdown();
    }
}
