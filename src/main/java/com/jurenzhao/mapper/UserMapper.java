package com.jurenzhao.mapper;

import com.jurenzhao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 更新人员信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除人员信息
     * @param id
     */
    void deleteUser(int id);

    /**
     * 通过id查找人员信息
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findUserByName(String username);

    /**
     * 分页查询用户信息
     * @param startPage
     * @param pageSize
     * @return
     */
    List<User> findUserByPage(@Param("startPage") int startPage, @Param("pageSize") int pageSize);

    /**
     * map传参
     * @param map
     * @return
     */
    List<User> findUserByMap(Map<String, Object> map);

    /**
     * 获取用户数量
     * @return
     */
    int findUserCount();

    /**
     * 返回主键值
     * @param user
     */
    void addUserReturnPrimaryKey (User user);

    /**
     * 查询id大于某个值的用户
     * @param id
     * @return
     */
    List<User> findListUseById(int id);


    /**
     * 查询用户根据多种情况
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);


    /**
     * 查询用户 使用choosewhen标签
     * @param user
     * @return
     */
    List<User> findUserByChooseWhenCondition(User user);




}
