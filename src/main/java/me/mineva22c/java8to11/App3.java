package me.mineva22c.java8to11;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App3 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("LeeSunShin");
        names.add("Minerva");
        names.add("KangKamChan");
        names.add("Charles");

        List<String> collect = names.parallelStream().map( (s) -> {
            System.out.println( String.format("[%1$15s][%2$40s]", s, Thread.currentThread().getName()) );
            return s.toUpperCase();
        } ).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }
    static void printx(){
        System.out.println("----------------------------------");
    }
}
