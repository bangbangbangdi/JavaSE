package com.bangdi.game;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(Images.topImg);

        System.out.println(((int) (Math.random()*30+1)*25));//[25,750]
        System.out.println(((int) (Math.random()*22+7)*25));
    }
}
