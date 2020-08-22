package me.mineva22c.java8to11;

public class DefaultBoo implements Boo, Bar{

    String name;

    public DefaultBoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

//    @Override
//    public void printNameUpperCase() {
//        System.out.println("(o)" + this.name.toUpperCase());
//    }

    @Override
    public String getName() {
        return this.name;
    }
}
