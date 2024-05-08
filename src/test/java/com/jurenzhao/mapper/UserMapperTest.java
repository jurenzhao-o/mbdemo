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
import java.lang.reflect.Array;
import java.util.*;

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
    public void addUserNote() throws IOException {
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
        user.setUsername("小李");
        mapper.addUserNote(user);
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
        user.setId(10);
        user.setUsername("大悟");
        user.setSex("女");
        user.setAddress("北京");
        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void updateUserNote() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setUsername("大悟1");
        user.setSex("女");
        user.setAddress("北京");
        mapper.updateUserNote(user);

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


    @Test
    public void findUserCount()throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userCount = mapper.findUserCount();
        System.out.println(userCount);
    }

    @Test
    public void addUserReturnPrimaryKey()throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAddress("苏州");
        user.setUsername("胖猫");
        user.setSex("男");
        mapper.addUserReturnPrimaryKey(user);
        System.out.println("id:"+user.getId());
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }


    @Test
    public void findListUseById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> listUseById = mapper.findListUseById(10);
        listUseById.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByCondition() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("%百战%");
        user.setSex("男");
        user.setAddress("上海");
        List<User> userByCondition = mapper.findUserByCondition(user);
        userByCondition.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByChooseWhenCondition() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("百战");
        List<User> userByChooseWhenCondition = mapper.findUserByChooseWhenCondition(user);
        userByChooseWhenCondition.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void findUserByIds() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //数组
        //int [] array = {1,2,3};
        //List<User> userByIds = mapper.findUserByIds(array);
        //集合
        List<User> userByIds = mapper.findUserByIds(Arrays.asList(1,2,3));
        userByIds.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }


    @Test
    public void insertBatch() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        users.add(new User("胖猫","男","四川"));
        users.add(new User("梦琪","男","深圳"));
        users.add(new User("谭竹铁出生","女","重庆"));
        mapper.insertBatch(users);
        sqlSession.commit();
        sqlSession.commit();
        resourceAsStream.close();
    }
    @Test
    public void findUsersByMap() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("sex","男");
        map.put("address","北京");
        List<User> usersByMap = mapper.findUsersByMap(map);
        usersByMap.forEach(System.out::println);
        sqlSession.close();
        resourceAsStream.close();
    }

    /*一级缓存默认开启，使用同一个SqlSession才能共享一级缓存*/
    @Test
    public void testCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        System.out.println(user1.hashCode());
        User user2 = mapper2.findUserById(1);
        System.out.println(user2.hashCode());
    }

    @Test
    public void testCache2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        System.out.println(user1.hashCode());
        User user2 = mapper2.findUserById(1);
        System.out.println(user2.hashCode());
    }


    /**
     * SqlSession调用close()：操作后SqlSession对象不可用，该对象的缓存数据也不可用
     * SqlSession调用clearCache()/commint()：操作可清空一级缓存数据
     * SqlSession调用增删改方法：操作会清空一级缓存数据
     * @throws IOException
     */
    @Test
    public void testCache3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper1.findUserById(1);
        System.out.println(user1.hashCode());

        sqlSession.clearCache();
//        sqlSession.close();
//        sqlSession = factory.openSession();
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);
        User user2 = mapper2.findUserById(1);
        System.out.println(user2.hashCode());
    }

    @Test
    public void testCache4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        System.out.println(user1.hashCode());
        sqlSession1.commit();

        User user2 = mapper2.findUserById(1);
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));

    }



}