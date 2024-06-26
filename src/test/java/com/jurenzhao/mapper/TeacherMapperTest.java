package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Teacher;
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
 * @Date: 2024/5/3 13:11
 * @Description: TODO
 */
public class TeacherMapperTest {

    @Test
    public void findAllTeacher() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher =
                mapper.findAllTeacher();
        allTeacher.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }


    @Test
    public void findAllTeacher2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher2 = mapper.findAllTeacher2();
        allTeacher2.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findAllTeacher3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher2 = mapper.findAllTeacher3();
        allTeacher2.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }
}