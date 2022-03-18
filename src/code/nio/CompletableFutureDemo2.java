package code.nio;

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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // thenApplyAsyncTest();
        System.out.println(1<<32);
        //thenComposeAsync();
    }
}
