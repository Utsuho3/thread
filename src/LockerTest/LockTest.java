package LockerTest;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyn on 2016/7/8.
 */
public class LockTest {
    private int count = 0;
    ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
    private Lock lock = new ReentrantLock();

    public void addCount(Thread thread) {
        try {
            thread.sleep(1000);
//            map.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        lock.lock();
//        try {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(thread.getName() + ":执行累加操作" + count++);
//                thread.sleep(100);
//            }
//        } catch (InterruptedException e) {
//        } finally {
//            lock.unlock();
//        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LockTest lt = new LockTest();
        ExecutorService ex = Executors.newCachedThreadPool();


        ex.shutdown();
    }
}
