package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Classes;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 13:48
 * @Description: TODO
 */
public interface ClassesMapper {
    /**
     * 查询所有班级信息
     * @return
     */
    List<Classes> findAllClasses();

    /**
     * 查询班级信息并查询班级关联的老师信息
     * @return
     */
    List<Classes> findAllClasses2();

    /**
     * 只查询班级信息（分解式1对多）
     * @return
     */
    List<Classes> findOnlyClasses();

    /**
     * 根据id查询班级信息
     * @param id
     * @return
     */
    Classes findClassesById(int id);
}
