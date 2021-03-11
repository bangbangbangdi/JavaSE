package com.functionref;

import com.bangdi.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test4 {
    public static void main(String[] args) {
        Supplier<Test4> su1 = () -> new Test4();
        Supplier<Test4> su2 = Test4::new;
        su1.get();
        su2.get();
        Consumer<String> co1 = (str) -> new Test4(str);
        Consumer<Integer> co2 = Test4::new;
        co1.accept("bangdi");
        co2.accept(22);
    }

    public Test4() {
        System.out.println("这里是Test4的无参构造");
    }

    public Test4(String str) {
        System.out.println("这里是Test4的String构造" + str);
    }

    public Test4(Integer integer) {
        System.out.println("这里是Test4的Integer构造" + integer);
    }
}
