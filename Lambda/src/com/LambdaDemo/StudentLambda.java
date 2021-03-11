package com.LambdaDemo;

public class StudentLambda {
    public static void main(String[] args) {
        new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("匿名内部类");
            }
        }.insert(new Student());

        StudentDao sd1 = s -> System.out.println("Lambda实现");
        sd1.insert(new Student());
        StudentDao sd2 = (Student s) -> System.out.println("Lambad实现2");
        sd2.insert(new Student());
    }
}
