package me.mineva22c.java8to11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App4 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("< spring 으로 시작하는 수업 >");

        springClasses.stream().filter( (oc) -> oc.getTitle().startsWith("spring") )
                            .forEach( (oc) ->  System.out.println(oc.getTitle())  );

        System.out.println("\n< close 되지 않은 수업 >");
//        springClasses.stream().filter( oc -> !oc.isClosed() )
//                .forEach( oc -> System.out.println( oc.getTitle() ));
        springClasses.stream().filter( Predicate.not(OnlineClass::isClosed) )
                              .forEach( oc -> System.out.println( oc.getTitle() ));

        System.out.println("\n< 수업이름만 모아서 스트림 만들기 >");
        springClasses.stream().map(oc -> oc.getTitle())
                              .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> charlesEvents = new ArrayList<>();
        charlesEvents.add(springClasses);
        charlesEvents.add(javaClasses);

        System.out.println("\n< 두 수업 목록에 들어있는 모든 수업 아이디 출력 >");
        charlesEvents.stream()
                        .flatMap(Collection::stream)   // List<List> => List로 변환
                        .forEach( oc -> System.out.println(oc.getTitle()));

        System.out.println("\n< 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 >");
        Stream.iterate(10, i -> i+1 )
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n< 자바 수업중에 Test가 들어있는 수업이 있는지 확인 >");
//        javaClasses.stream().filter( oc -> oc.getTitle().contains("Test") )
//                            .forEach( oc -> System.out.println( oc. getTitle() ));
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println( test );

        System.out.println("\n< 스프링 수업중에 제목에 spring이 들어간 건만 모아서 List만들기 >");
//        List<OnlineClass> newClasses = new ArrayList<>();
//        springClasses.stream().filter( oc -> oc.getTitle().contains("spring") )
//                              .forEach(newClasses::add);
//        newClasses.stream().forEach( oc -> System.out.println( oc.getTitle() ));
        List<String> spring = springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
    }
}
