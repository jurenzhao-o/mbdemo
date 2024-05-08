package com.jurenzhao.mapper;

import com.jurenzhao.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: JuRenZhao
 * @Date: 2024/5/6 0:55
 * @Description: TODO
 */
public interface StudentMapper {

    /**
     * 查询所有学生
      * @return
     */
    List<Student> findAllStudent();

    /**
     * 查询所有学生(注解开发）
     * @return
     */
    @Select("select * from student")
    List<Student> findAllStudentNote();

    /**
     * 查询特定班级下学生
     * @param classId
     * @return
     */
    List<Student> findStudentByClassId(Integer classId);

    /**
     * 查询所有学生不连表查询（拆解式一对一）
     * @return
     */
    List<Student> findAllOnlyStudent();

}
