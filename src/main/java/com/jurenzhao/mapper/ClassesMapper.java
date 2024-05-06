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
}
