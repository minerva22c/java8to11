package me.mineva22c.java8to11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App8 {
    public static void main(String[] args) {
        System.out.println("Start main..");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String msg) {
        return () -> {
            System.out.println(String.format("[%2$20s][%1$10s]", msg, Thread.currentThread().getName()));
        };
    }
}
/*
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService.shutdown();

        /////////////////////
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("Charles"));
        executorService.submit(getRunnable("The"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Thread"));
        executorService.shutdown();

        //////////////////
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
        //
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
    }
    private static Runnable getRunnable(String msg) {
        return () -> {
            System.out.println(String.format("[%2$20s][%1$10s]", msg, Thread.currentThread().getName()));
        };
    }

* */