package com.bangdi;

import java.util.ArrayList;

public class Test {
    //Student的测试类

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("bangdi", 23, 80));
        list.add(new Student("xiaoming", 19, 70));
        list.add(new Student("xiaoxue", 25, 85));
        list.add(new Student("nini", 20, 90));
        //查找年龄大于20的学生
        findByAge(list);
        System.out.println("--------------");
        //查找分数大于80的学生
        findByScore(list);
    }

    public static void findByAge(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (stu.getAge() > 20) {
                list.add(stu);
            }
        }
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    public static void findByScore(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (stu.getScore() > 80) {
                list.add(stu);
            }
        }
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
}
