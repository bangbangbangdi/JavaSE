package com.bangdi02;

import com.bangdi.Student;

@FunctionalInterface
public interface StudentFilter {
    boolean compare(Student student);
}
