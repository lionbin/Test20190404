package com.sxzy.b.test_app.Test_05;

public class Student {
    private  String name;
    private  String banji;
    private  int sge;

    public Student(String name, String banji, int sge) {
        this.name = name;
        this.banji = banji;
        this.sge = sge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public int getSge() {
        return sge;
    }

    public void setSge(int sge) {
        this.sge = sge;
    }
}
