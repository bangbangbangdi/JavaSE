package com.bangdi02;

import com.bangdi.Student;

public class ScoreFilter implements StudentFilter {

    @Override
    public boolean compare(Student student) {
        return student.getScore() > 80;
    }
}

