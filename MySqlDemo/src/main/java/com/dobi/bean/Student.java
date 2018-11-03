package com.dobi.bean;

public class Student {

    private int id;
    private String name;
    private int age;
    private int class1;//班级

    public Student() {
    }

    public Student(int id, String name, int age, int class1) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.class1 = class1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClass1() {
        return class1;
    }

    public void setClass1(int class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", class1=" + class1 +
                '}';
    }
}
