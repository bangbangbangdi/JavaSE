package com.bangdi02;

import com.bangdi.Student;

public class AgeFilter implements StudentFilter {

    @Override
    public boolean compare(Student student) {
        return student.getAge() > 20;
    }
}
