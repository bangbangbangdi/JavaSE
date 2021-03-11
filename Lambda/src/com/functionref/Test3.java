package com.functionref;

import java.util.function.BiConsumer;

//对象方法引用
public class Test3 {
    public static void main(String[] args) {
        BiConsumer<Too,String> bi = (Too,str)->new Too().show(str);
        bi.accept(new Too(),"bangdi");
    }
}

class Too {
    public void show(String str) {
        System.out.println("这里是Too方法--参数为"+str);
    }
}