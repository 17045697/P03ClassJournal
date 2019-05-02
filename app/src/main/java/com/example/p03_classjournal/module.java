package com.example.p03_classjournal;

public class module {
    private int week;
    private String grade;
    public module(int week, String grade){
        this.week = week;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
