package com.functionref;

import java.util.function.Supplier;

//实例方法引用
public class Test2 {
    public String put() {
        return "cc";
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        System.out.println(new Test2().put());
        Supplier<String> su1 = ()->new Test2().put();
        Supplier<String> su2 = ()->{return new Test2().put();};
        Supplier<String> su3 = new Test2()::put;
        Supplier<String> su4 = test::put;
        System.out.println(su1.get());
        System.out.println(su2.get());
        System.out.println(su3.get());
        System.out.println(su4.get());
    }
}
