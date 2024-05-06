package com.jurenzhao.pojo;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 0:52
 * @Description: TODO
 */
public class Classes {
    private int id;
    private String className;
    //学生集合 班级学生一对多
    private List<Student> studentList;
    //老师集合 班级老师多对多
    private List<Teacher> teacherList;




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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
