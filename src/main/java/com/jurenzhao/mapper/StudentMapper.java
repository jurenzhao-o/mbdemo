package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Student;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 0:55
 * @Description: TODO
 */
public interface StudentMapper {

    /**
     * 查询所有学生
      * @return
     */
    List<Student> findAllStudent();

    /**
     * 查询特定班级下学生
     * @param classId
     * @return
     */
    List<Student> findStudentByClassId(Integer classId);
}