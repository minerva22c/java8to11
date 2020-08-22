package me.mineva22c.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App5 {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProgress().get().getStudyDuration();
//        System.out.println(studyDuration);

        Optional<OnlineClass> onClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("aaa"))
                .findFirst();

//        OnlineClass onlineClass = onClass.orElse(App5::createNewClass);
//        OnlineClass onlineClass = onClass.orElseGet(App5::createNewClass);
//        OnlineClass onlineClass = onClass.orElseThrow(
//                IllegalArgumentException::new
//        );
//        ////////////
//        Optional<Optional<Progress>> progress = onClass.map(OnlineClass::getProgress);
//        Optional<Progress> progress1 = progress.orElse(Optional.empty());

        onClass.flatMap(OnlineClass::getProgress);

//        System.out.println( progress.);

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
