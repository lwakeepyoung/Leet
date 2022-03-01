package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo2 {
    public static void main(String[] args) {
        Lock lockA = new ReentrantLock(); // 创建锁 A
        Lock lockB = new ReentrantLock(); // 创建锁 B

        // 创建线程 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockA.lock(); // 加锁
                System.out.println("线程 1:获取到锁 A!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 1:等待获取 B...");
                    lockB.lock(); // 加锁
                    try {
                        System.out.println("线程 1:获取到锁 B!");
                    } finally {
                        lockB.unlock(); // 释放锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockA.unlock(); // 释放锁
                }
            }
        });
        t1.start(); // 运行线程

        // 创建线程 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockB.lock(); // 加锁
                System.out.println("线程 2:获取到锁 B!");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程 2:等待获取 A...");
                    lockA.lock(); // 加锁
                    try {
                        System.out.println("线程 2:获取到锁 A!");
                    } finally {
                        lockA.unlock(); // 释放锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockB.unlock(); // 释放锁
                }
            }
        });
        t2.start(); // 运行线程
    }
}
