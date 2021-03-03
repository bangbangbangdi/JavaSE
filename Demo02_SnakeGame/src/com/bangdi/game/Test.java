package com.bangdi.game;


import java.net.URL;

public class Test {
    public static void main(String[] args) {
        URL bodyImg = Images.class.getResource("/images/body.jpg");
        System.out.println(bodyImg);
        System.out.println((int)( Math.random() * 29 + 1) * 25);
    }
}
