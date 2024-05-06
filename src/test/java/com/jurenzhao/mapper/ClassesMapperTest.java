package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Classes;
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
 * @Author: JuRenZhao
 * @Date: 2024/5/6 13:57
 * @Description: TODO
 */
public class ClassesMapperTest {

    @Test
    public void findAllClasses() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
        List<Classes> allClasses = mapper.findAllClasses();
        allClasses.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }
}