package com.jurenzhao.pojo;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 0:50
 * @Description: 学生实体类
 */
public class Student {

    private int id;
    private String name;
    private int age;
    private String sex;
    //班级信息实体
    private Classes classes;


    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
