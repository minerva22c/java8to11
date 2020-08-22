package me.mineva22c.java8to11;

public class App7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName() );
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
            System.out.println(Thread.currentThread().getName() + " is finished.....");
        });
        thread.start();

        System.out.println("Hello");
        thread.join();
        System.out.println(thread + " is finished.");
    }

}
/*
*
*   public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
* */