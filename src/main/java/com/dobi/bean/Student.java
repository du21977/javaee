package com.dobi.bean;

public class Student {

    private String name;
    private int  age;
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", phone='" + phone + '\'' +
//                '}';

        return name +"#"+age+"#"+phone+"\r\n";
    }
}
