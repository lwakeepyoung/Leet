package code.nio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    static class BackendA{
        public static Integer getCount(){
            int i = new Random().nextInt(10);
            System.out.println(BackendA.class.getName()+":"+Thread.currentThread().getName()+"生产"+i);
            return i;
        }
    }

    static class BackendB{
        public static Integer getCount(){
            int i = new Random().nextInt(10);
            System.out.println(BackendB.class.getName()+":"+Thread.currentThread().getName()+"生产"+i);
            return i;
        }
    }

    static class BackendC{
        public static Integer getCount(){
            int i = new Random().nextInt(10);
            System.out.println(BackendC.class.getName()+":"+Thread.currentThread().getName()+"生产"+i);
            return i;
        }
    }

    public static void testCount() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> BackendA.getCount());
        CompletableFuture<Integer> f2 = f1.thenApplyAsync((a)->{
            Integer b = BackendB.getCount();
            return a+b;
        });
        System.out.println(f2.get());
        Thread.sleep(2000);
    }




    public static void test1(){
        CompletableFuture<String> completableFuture = new CompletableFuture();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行.....");
            completableFuture.complete("success");
        });
    }

    public static void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync " + Thread.currentThread().getName());
            return "hello";
        }, executorService).thenApplyAsync(s -> {
            System.out.println(Thread.currentThread());
            System.out.println(s + "world");
            return "hhh";
        }, executorService);
        cf.thenRunAsync(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("ddddd");
        });
        cf.thenRun(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("ddddsd");
        });
        cf.thenRun(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("dddaewdd");
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //testCount();

//        List<Integer> a = new ArrayList();
//        a.add(1);
//        List<Integer> b = new ArrayList<>();
//        b.add(3);
//
//        System.out.println(a.containsAll(b));

        //test1();
    }
}
