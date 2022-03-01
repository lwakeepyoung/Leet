package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        synchronized (ReentrantLockDemo2.class){

        }
        synchronized (ReentrantLockDemo2.class){

        }
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
//        reentrantLock.unlock();
    }
}
