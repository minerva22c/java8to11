package me.mineva22c.java8to11;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class App12 {
    public static void main(String[] args) {
        ChickenContainer annotation = App12.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(c->{
            System.out.println(c.value());
        });
    }
}
/*
@Target(ElementType.TYPE_USE) <= Annotaion을 넣을 수 있는 모든 곳에 넣어도 에러가 나지 않는다.
Target(ElementType.TYPE_PARAMETER) <= Type Parameter 에만 붙일수 있다.

@Chicken
public class App12 {
    public static void main(@Chicken String[] args) throws @Chicken Exception{
        List<@Chicken String> names = Arrays.asList("charles");
    }
    static class FeelsLikeChicken<@Chicken T>{
        public static <@Chicken C> void print(@Chicken C c){  // (앞)C:Type Parameter (뒤)C:Type
            System.out.println(c);
        }
    }

///////////////////////////////////////////
        Chicken[] chickens = App12.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach( c-> {
            System.out.println(c.value());
        });

///////////////////////////////////////////
        ChickenContainer annotation = App12.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(c->{
            System.out.println(c.value());
        });
 */