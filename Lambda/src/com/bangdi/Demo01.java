package com.bangdi;

public class Demo01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现接口");
            }
        }).start();

        new Thread(()->{
            System.out.println("Lambda表达式实现接口");
        }).start();
    }
}
