package com.jurenzhao.mapper;

import com.jurenzhao.pojo.User;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/4/29 15:46
 * @Description: TODO
 */
public interface UserMapper {
    /**
     * 查询所有人员记录
     * @return
     */
    List<User> findAll();

    /**
     * 新增人员
     * @param user
     */
    void addUser(User user);
}
