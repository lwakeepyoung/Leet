package code.nio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

    public static void thenApplyAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->"hello ");
        // f2依赖f1的结果做转换
        CompletableFuture<String> f2 = f1.thenApplyAsync(
                t -> t + "world"
        );
        System.out.println("异步结果:" + f2.get());
    }

    public static void thenComposeAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->"hello");

        // f2虽然依赖f1的结果，但不会等待f1结果返回，而是再包装成一个future返回
        CompletableFuture<String> f2 = f1.thenComposeAsync(t->
                CompletableFuture.supplyAsync(()->
                        t+"world")
        );

        // 等到真正调用的时候再执行f2里的逻辑
        System.out.println("异步结果:" + f2.get());

    }

    public static void thenCombineAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });

        CompletableFuture<String> f3 = f1.thenCombineAsync(f2, (t1, t2) -> t1 + t2);
        long time = System.currentTimeMillis();
        System.out.println("异步结果:" + f3.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }

    public static void applyToEitherAsync() throws ExecutionException, InterruptedException {
        Random rand = new Random();
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000)); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000)); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        CompletableFuture<String> f3 = f1.applyToEitherAsync(f2, t -> t);
        long time = System.currentTimeMillis();
        System.out.println("异步结果:" + f3.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }

    public static void testAllof() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "java";
        });
        List<CompletableFuture<String>> list = new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);

        CompletableFuture<Void> f4 = CompletableFuture.allOf(list.toArray(new CompletableFuture[]{}));
        long time = System.currentTimeMillis();
        f4.thenRunAsync(() ->
                list.forEach(f -> {
                    try {
                        System.out.println("异步结果:" + f.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        f4.get();
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }

    public static void testAnyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "java";
        });
        List<CompletableFuture<String>> list = new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);

        CompletableFuture<Object> f4 = CompletableFuture.anyOf(list.toArray(new CompletableFuture[]{}));
        long time = System.currentTimeMillis();
        f4.thenRunAsync(() ->
                list.forEach(f -> {
                    try {
                        System.out.println("异步结果:" + f.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        f4.get();
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // thenApplyAsyncTest();
        //thenComposeAsync();
        //thenCombineAsync();
        //applyToEitherAsync();
        //testAllof();
        testAnyOf();
    }
}
