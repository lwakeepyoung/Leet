package code.nio;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(2000);
            Random random = new Random();
            int i = random.nextInt(10) * 20;
            return i;
        });
        while (!future.isDone()){
            System.out.println(Thread.currentThread().getName()+"任务未完成");
            Thread.sleep(500);
        }
        System.out.println(Thread.currentThread().getName()+":"+future.get());
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();
    }

}
