package com.functionref;

import java.util.function.Function;
import java.util.function.Supplier;

//静态方法引用
public class Test1 {

    static String put() {
        System.out.println("bangdi");
        return "cc";
    }

    static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        Supplier<String> s1 = () -> Test1.put();
        Supplier<String> s2 = Test1::put;
        System.out.println(s1.get());
        System.out.println(s2.get());

        Function<String, String> f1 = (s) -> Test1.toUpperCase(s);
        Function<String, String> f2 = Test1::toUpperCase;
        System.out.println(f1.apply("bangdi"));
        System.out.println(f2.apply("bang-di"));


    }
}
