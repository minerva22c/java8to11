package me.mineva22c.java8to11;

import java.util.concurrent.*;

public class App10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("1 : " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(()->{
            System.out.println("2 : " + Thread.currentThread().getName());
        });
        future.get();
        executorService.shutdown();
    }
}
/*
        CompletableFuture<String> future = CompletableFuture.completedFuture("charles2");
        System.out.println(future.get());
//////////////////////
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        future.get();
/////////////////////
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future.get());
/////////////////////
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s)->{
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future.get());
/////////////////////
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s)->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
/////////////////////
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName());
        });
        future.get();
/////////////////////
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello";
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName());
        });
        future.get();
/////////////////////
/////////////////////
*/