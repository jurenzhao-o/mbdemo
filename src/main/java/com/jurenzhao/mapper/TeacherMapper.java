package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Teacher;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/3 13:10
 * @Description: TODO
 */
public interface TeacherMapper {
    /**
     * 查询所有老师
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 查询所有老师 使用<sql></sql>
     * @return
     */
    List<Teacher> findAllTeacher2();
}
