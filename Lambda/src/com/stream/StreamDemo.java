package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    //通过数组创建流对象
    static void gen1() {
        String[] strs = {"a", "b", "c", "d"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    //通过集合创建流对象
    static void gen2() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //通过Stream.generate方法来创建
    static void gen3() {
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
    }

    //使用iterator
    static void gen4() {
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    //其他方式,返回值为Stream的时候
    static void gen5() {
        String str = "bangdi";
        IntStream intStream = str.chars();
        intStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //流的创建操作
//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();
        //中间操作：如果调用方法之后的结果是Stream对象就意味着是一个中间操作
        Arrays.asList(1, 2, 3, 4, 5).stream().filter((x) -> x % 2 == 0).forEach(System.out::println);
        //求出结果集中所有偶数的和
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum());
        //求集合的最大值
        System.out.println("元素最大值为" + Arrays.asList(1, 2, 3, 4, 5, 6).stream().max((a, b) -> a - b).get());
        //求集合的最小值
        System.out.println("元素最小值为" + Arrays.asList(-100, 1, 2, 3, 4, 5, 6).stream().min((a, b) -> a - b).get());
        //求集合的元素总数
        System.out.println("元素的总数为：" + Arrays.asList(1, 2, 3, 4, 5).stream().count());
        //求元素的平均数
        System.out.println("元素的平均数为：" + Arrays.asList(1, 2, 3, 4, 5).stream().mapToInt(x -> x).average().getAsDouble());


        //求stream的任意一个值
        List<Integer> list = Arrays.asList(-2, 1, 2, 3, 4, 5, 6);
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());

        //验证流内容是否会执行
        Stream<Integer> integerStream = list.stream().filter(i -> {
            System.out.println("运行代码");
            return i % 2 == 0;
        });
        System.out.println(integerStream.findFirst().get());

        //获取最大值和最小值但是不使用min和max方法
        Optional<Integer> first = list.stream().sorted().findFirst();
        System.out.println(first.get());
        Optional<Integer> first1 = list.stream().sorted((a, b) -> b - a).findFirst();
        System.out.println(first1.get());

        //对字符串进行排序
        Arrays.asList("java", "C#", "python", "scala", "bangdi").stream().sorted().forEach(System.out::println);
        Arrays.asList("java", "C#", "python", "scala", "bangdi").stream().sorted((a, b) -> b.length() - a.length()).forEach(System.out::println);

        //将集合中对元素进行过滤同时返回一个集合对象
        System.out.println("----------------");
        Set<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        collect.forEach(System.out::println);

        //将流变成Array
        Object[] objects = Arrays.asList(4, 3, 2, 1).stream().toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println("将Stream转成Array" + (int) objects[i]);
        }


        //去重操作
        System.out.println("-----------");
        Arrays.asList(1, 2, 3, 3, 3, 2, 4, 4, 4, 52, 1, 3).stream().distinct().forEach(System.out::println);
        System.out.println("-----------");
        Arrays.asList(1, 2, 3, 3, 3, 2, 4, 4, 4, 52, 1, 3).stream().collect(Collectors.toSet()).forEach(System.out::println);

        //打印20-30这样的集合数据
        System.out.println("---------");
        Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);

        //对字符串进行求和
        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());

        //创建一组自定义对象
        String str2 = "Java,Scala,Python";
        Stream.of(str2.split(",")).map(x -> new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //
    }
}
