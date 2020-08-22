package me.mineva22c.java8to11;

public interface Bar extends Boo{

//    void printNameUpperCase();
    default void printNameUpperCase(){
        System.out.println("BAR");
    }
}
