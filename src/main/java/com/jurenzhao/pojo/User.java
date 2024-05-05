package com.jurenzhao.pojo;

import java.io.Serializable;

/**
 * @Author: JuRenZhao
 * @Date: 2024/4/29 15:43
 * @Description: 人员实体
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String sex;
    private String address;


    public User() {
    }

    public User(String username, String sex, String address) {
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
