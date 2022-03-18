package code.nio;

import java.util.Random;
import java.util.concurrent.*;

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

    public static void futureTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors()));
        Future<String> future = executorService.submit(() -> {
                // 模拟接口调用，耗时200ms
                Thread.sleep(200);
                return "hello world";
            }
        );

        // 在输出下面异步结果时主线程可以不阻塞的做其他事情
        // TODO 其他业务逻辑

        //System.out.println(future.get());
        while (!future.isDone()){
            Thread.sleep(1000);
        }
        System.out.println("异步结果"+future.get());
        //future.get(1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureTest();
    }

}
