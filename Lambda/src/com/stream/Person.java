package com.stream;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public static Person build(String str) {
        Person person = new Person(str);
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
