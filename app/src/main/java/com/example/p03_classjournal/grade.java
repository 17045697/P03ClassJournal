package com.example.p03_classjournal;

import java.io.Serializable;

public class grade implements Serializable {

    private String grade;
    private int week;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public grade(int week, String grade){
        this.week = week;
        this.grade = grade;
    }
}
