package juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static int a;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        new Thread(()->{
            for (int i = 0; i < 10_0000; i++) {
                lock.lock();
                a++;
                lock.unlock();
            }

        },"thread1").start();

        new Thread(()->{
            for (int i = 0; i < 10_0000; i++) {
                lock.lock();
                a--;
                lock.unlock();
            }
        },"thread2").start();
        Thread.sleep(1000);
        System.out.println(a);
    }
}
