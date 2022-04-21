package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo {

    public void print(String param){
        System.out.println(param);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(
                ()->{
                    try {
                        for (int i = 0; i < 10; i++) {
                            //semaphoreA.acquire();
                            demo.print("a");
                            //semaphoreB.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

        executorService.execute(
                ()->{
                    try {
                        for (int i = 0; i < 10; i++) {
                            //semaphoreB.acquire();
                            demo.print("b");
                            //semaphoreC.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

        executorService.execute(
                ()->{
                    try {
                        for (int i = 0; i < 10; i++) {
                            //semaphoreC.acquire();
                            demo.print("c");
                            //semaphoreA.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
