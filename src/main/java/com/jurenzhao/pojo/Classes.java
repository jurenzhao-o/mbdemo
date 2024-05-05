package com.jurenzhao.pojo;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 0:52
 * @Description: TODO
 */
public class Classes {
    private int id;
    private String className;


    public Classes() {
    }

    public Classes(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
