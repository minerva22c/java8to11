package me.mineva22c.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {

        // Static Method 참조
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("There"));

        // 특정객체의 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("Charles"));

        // 생성자 참조1
        Supplier<Greeting> greetingSupplier = Greeting::new; // public Greeting(){
        Greeting greeting1 = greetingSupplier.get();
        System.out.println(greeting1.hello("James"));

        // 생성자 참조2
        Function<String, Greeting> argGreeting = Greeting::new; // public Greeting(String name){
        Greeting myGreeting = argGreeting.apply("Args");
        System.out.println( myGreeting.getName());

        // 임의객체의 인스턴스 메소드 참조
        String[] names = {"James", "charles", "Minerva"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        ///////////////////////////////////////////
        // 인터페이스의 기본(Default) 메소드와 Static 메소드
        Boo boo = new DefaultBoo("Charles");
        boo.printName();
        boo.printNameUpperCase();

        Boo.printAnything();
    }
}
