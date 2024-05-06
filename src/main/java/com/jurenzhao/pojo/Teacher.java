package com.jurenzhao.pojo;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/3 13:07
 * @Description: TODO
 */
public class Teacher {
    private int id;
    private String name;
    //班级集合
    private List<Classes> classesList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
