package com.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StramTest {
    static void g1() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    static void g2(){
        for (int i=0;i<10;i++)
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());
        //查找任意一个流元素；如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个
        System.out.println(IntStream.range(0, 100).parallel().findAny().getAsInt());
    }

    static void g3(){
        Arrays.asList(1,2,3,4,5,6).stream().filter(x->{
            System.out.println("这里是是中间代码");
            return x==5;
        }).findFirst();
    }

    public static void main(String[] args) {
        g3();
    }
}
