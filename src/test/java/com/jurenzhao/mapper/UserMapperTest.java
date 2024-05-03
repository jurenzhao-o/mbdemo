package com.jurenzhao.mapper;

import com.jurenzhao.pojo.User;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * @Author:     JuRenZhao
 * @Date:    2024/4/29 15:50
 * @Description:  TODO  
 */
public class UserMapperTest {

    @Test
    public void findAll() throws IOException {
        //1）读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2）创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3) 获取SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //4)获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5）获取代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6) 代理对象执行方法
        List<User> all = mapper.findAll();
        all.forEach(System.out::println);
        //7）释放资源
        sqlSession.close();
        resourceAsStream.close();

    }

    @Test
    public void addUser() throws IOException {
        //1）读取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2）创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3) 获取SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //4)获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5）获取代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6) 代理对象执行方法
        User user = new User();
        user.setAddress("苏州");
        user.setSex("男");
        user.setUsername("小吴");
        mapper.addUser(user);
        //TODO 一定要提交事物
        sqlSession.commit();
        //7）释放资源
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void updateUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setUsername("大悟");
        user.setSex("女");
        user.setAddress("北京");
        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void deleteUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(8);
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.findUserById(4);
        System.out.println(userById);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByName() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //List<User> userByName = mapper.findUserByName("%百%");
        List<User> userByName = mapper.findUserByName("百");
        userByName.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByPage() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByPage = mapper.findUserByPage(0, 2);
        userByPage.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByMap()throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("startPage",0);
        map.put("pageSize",2);
        List<User> userByMap = mapper.findUserByMap(map);
        userByMap.forEach(System.out::println);

    }

}