package com.bangdi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "javascript", "scala", "python");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("---------------苗条的分割线-------------------");
        Collections.sort(list,(a,b)->a.length()-b.length());
        list.forEach(System.out::println);
    }
}
