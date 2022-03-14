package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 {

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition ac = reentrantLock.newCondition();
    static Condition bc = reentrantLock.newCondition();
    static Condition cc = reentrantLock.newCondition();
    static volatile int state = 0;

    static class A extends Thread{
        @Override
        public void run() {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    while (state%3!=0){
                        ac.await();
                    }
                    System.out.print(1);
                    state++;
                    bc.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    while (state%3!=1){
                        bc.await();
                    }
                    System.out.print(2);
                    state++;
                    cc.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    static class C extends Thread{
        @Override
        public void run() {
            try {
                reentrantLock.lock();
                for (int i = 0; i < 10; i++) {
                    while (state%3!=2){
                        cc.await();
                    }
                    System.out.print(3);
                    state++;
                    ac.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.start();
        b.start();
        c.start();
    }
}
