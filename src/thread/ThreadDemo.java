package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lwa
 * @Date: 2022/3/2 21:16
 */
public class ThreadDemo {
    private static volatile int state =0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (state % 3 == 0) {
                    System.out.println(1);
                    state++;
                }
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{

            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (state % 3 == 1) {
                    System.out.println(2);
                    state++;
                }
                lock.unlock();

            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (state % 3 == 2) {
                    System.out.println(3);
                    state++;
                }
                lock.unlock();
            }
        },"C").start();

        Thread.sleep(10000);

    }
}
