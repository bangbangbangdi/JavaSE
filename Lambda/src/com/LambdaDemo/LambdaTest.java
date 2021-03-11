package com.LambdaDemo;

import java.util.concurrent.Callable;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现");
            }
        }.run();

        Runnable runnable1 = () -> System.out.println("Lambda表达式实现接口");
        runnable1.run();

        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "bangdi";
            }
        };
        System.out.println(c1.call());
        Callable<String> c2 = () -> {
            return "Lambda bangdi";
        };
        System.out.println(c2.call());
        Callable<String> c3 = () -> "Lambda bangdi2";
        System.out.println(c3.call());

        //以下是Java提供的函数式接口
        //代表一个输出
        Supplier<Integer> s1 = () -> 1;
        System.out.println(s1.get());

        //代表一个输入
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("bangdi");

        //代表两个输入
        BiConsumer<String, Integer> bi = (s, i) -> System.out.println(s + i);
        bi.accept("bangdi", 1);

        //代表一个输入一个输出，一般输入和输出是不同类型
        Function<String, Integer> f1 = (str) -> str.length();
        System.out.println(f1.apply("bangdi"));

        //代表一个输入一个输出，输入和输出是相同类型
        UnaryOperator<Integer> u1 = (i) -> i + 10;
        System.out.println(u1.apply(100));

    }
}
