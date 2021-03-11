package com.LambdaDemo;

public class TeacherLambda {
    public static void main(String[] args) {
        System.out.println(new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        }.get(new Teacher()));

        TeacherDao td2 = (t) -> {return 2;};
        System.out.println(td2.get(new Teacher()));
        TeacherDao td3 = t -> {return 3;};
        System.out.println(td3.get(new Teacher()));
        TeacherDao td4 = (t) -> 4;
        System.out.println(td4.get(new Teacher()));
        TeacherDao td5 = t -> 5;
        System.out.println(td5.get(new Teacher()));
        TeacherDao td6 = (Teacher t)->6;
        System.out.println(td6.get(new Teacher()));
    }
}
