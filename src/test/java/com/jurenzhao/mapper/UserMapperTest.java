package com.jurenzhao.mapper;

import com.jurenzhao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        resourceAsStream.close();

    }
}