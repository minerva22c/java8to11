package me.mineva22c.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class App11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000L); } catch (InterruptedException e) { e.printStackTrace(); }
            if ( throwError ){
                throw new IllegalArgumentException();
            }
            System.out.println("hello (1) " + Thread.currentThread().getName());
            return "hello";
        }).handle( (result, ex) -> {
            if ( ex != null ){
                System.out.println(ex);
                return "Error!!";
            }else{
                return result;
            }
        });
        System.out.println(hello.get());

    }
}
/*
///////////////////////////////////
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000L); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("hello (1) " + Thread.currentThread().getName());
            return "hello";
        });
        // 순서대로 수행
        CompletableFuture<String> future = hello.thenCompose(s -> getWorld(s));
        System.out.println( future.get() );

    private static CompletableFuture<String> getWorld(String msg) {
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500L); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(msg + " (2) " + Thread.currentThread().getName());
            return msg + " world";
        });
        return world;
    }

///////////////////////////////////
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000L); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("hello (1) " + Thread.currentThread().getName());
            return "hello";
        });
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500L); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("world (1) " + Thread.currentThread().getName());
            return "world";
        });
//////////////--------------------
        // 순차적으로 수행
        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
            return h + " " + w;
        });
        System.out.println( future.get() );

//////////////--------------------
        // (모두 수행하고 콜백)
        List<CompletableFuture<String>> futureList = Arrays.asList(hello, world);
        CompletableFuture[] futureArray = futureList.toArray(new CompletableFuture[futureList.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futureArray)
                .thenApply(v -> {
                    return futureList.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });
        results.get().forEach(System.out::println);

//////////////--------------------
        // (하나만 수행되면 콜백)
        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(s -> {
            System.out.println(s);
        });
        future.get();

///////////////////////////////////
        // Exception 처리
        boolean throwError = true;
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if ( throwError ){
                throw new IllegalArgumentException();
            }
            System.out.println("hello (1) " + Thread.currentThread().getName());
            return "hello";
        }).exceptionally( ex -> {
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(hello.get());
///////////////////////////////////
///////////////////////////////////
///////////////////////////////////
///////////////////////////////////
 */