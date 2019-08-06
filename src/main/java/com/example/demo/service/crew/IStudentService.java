package com.example.demo.service.crew;

import com.example.demo.entity.Student;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * @ClassName IStudentService
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@DataSourceType
public interface IStudentService {

    /**
     * 增
     *
     * @param student
     * @return
     */
    int saveStudent(Student student);

    /**
     * 删
     *
     * @param studentId
     * @return
     */
    int removeStudent(Long studentId);

    /**
     * 改
     *
     * @param student
     * @return
     */
    int modify(Student student);

    /**
     * 查询列表
     *
     * @param student
     * @return
     */
    List<Student> findStudentList(Student student);

    /**
     * 查询一个
     *
     * @param student
     * @return
     */
    Student findStudent(Student student);
}
