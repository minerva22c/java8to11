package me.mineva22c.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10; // "Effective Final"

        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println( "LocalClass : " + baseNumber );
            }
        }

        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println( "Consumer : " + baseNumber);
            }
        };

        IntConsumer printInt = (i) -> {
            System.out.println( "IntConsumer : " + (i + baseNumber) );
        };

        printInt.accept(10);
        new LocalClass().printBaseNumber();
    }
}
