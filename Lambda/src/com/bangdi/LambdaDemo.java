package com.bangdi;

public class LambdaDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        });

        thread.start();
        new Thread(() -> {
            System.out.println("running Lambda");
        }).start();
    }
}
