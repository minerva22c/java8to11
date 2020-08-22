package me.mineva22c.java8to11;

import java.util.*;
import java.util.stream.Collectors;

public class App2 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        name.add("LeeSunShin");
        name.add("Minerva");
        name.add("KangKamChan");
        name.add("Charles");

        name.forEach( System.out::println ); // Static Method Reference

        System.out.println("=============================================");
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("===============================");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("=============================================");
        long m = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("M"))
                .count();
        System.out.println(m);
        Set<String> m1 = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("M"))
                .collect(Collectors.toSet());
        System.out.println(m1);

        System.out.println("=============================================");
        name.removeIf(s -> s.startsWith("K"));
        name.forEach(System.out::println);

        System.out.println("=============================================");
        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);

        System.out.println("=============================================");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
