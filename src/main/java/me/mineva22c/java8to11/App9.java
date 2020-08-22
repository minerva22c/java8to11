package me.mineva22c.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L );
            return "Hello";
        };
        Callable<String> java = () -> {
            Thread.sleep(3000L );
            return "java";
        };
        Callable<String> charles = () -> {
            Thread.sleep(1000L );
            return "charles";
        };
        // 3개 thread가 다 끝날 때까지 기다린다.
//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, charles));
//        for( Future<String> f : futures ){
//            System.out.println(f.get());
//        }
        // 먼저 끝나는 대상으로 가져 온다.
        String s = executorService.invokeAny(Arrays.asList(hello, java, charles));
        System.out.println(s);

        executorService.shutdown();
    }
}
/*
*
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(2000L );
            return "Hello";
        };
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        helloFuture.cancel(true);
//        helloFuture.get(); // 블로킹

        System.out.println(helloFuture.isDone());
        System.out.println("Ended!");
        executorService.shutdown();

/////////////////////////////////////////////////

* */