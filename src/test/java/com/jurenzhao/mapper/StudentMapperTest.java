package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Student;
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
 * @Date: 2024/5/6 1:02
 * @Description: TODO
 */
public class StudentMapperTest {

    @Test
    public void findAllStudent() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.findAllStudent();
        allStudent.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findStudentByClassId() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentByClassId = mapper.findStudentByClassId(1);
        studentByClassId.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findAllOnlyStudent() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allOnlyStudent = mapper.findAllOnlyStudent();
        //allOnlyStudent.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }
}