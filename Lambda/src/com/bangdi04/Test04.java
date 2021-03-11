package com.bangdi04;

import com.bangdi.Student;
import com.bangdi02.StudentFilter;

import java.util.ArrayList;

public class Test04 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("bangdi", 23, 80));
        list.add(new Student("xiaoming", 19, 70));
        list.add(new Student("xiaoxue", 25, 85));
        list.add(new Student("nini", 20, 90));

        getByFilter(list, (e) -> e.getAge() > 18);
        getByFilter(list, (e) -> e.getScore() > 80);
        System.out.println("---------------");
        getByFilter(list, (e) -> e.getAge() > 20 && e.getScore() > 83);
    }

    public static void getByFilter(ArrayList<Student> students, StudentFilter filter) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (filter.compare(stu)) {
                list.add(stu);
            }
        }
        printStudent(list);
    }

    public static void printStudent(ArrayList<Student> list) {
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
}
