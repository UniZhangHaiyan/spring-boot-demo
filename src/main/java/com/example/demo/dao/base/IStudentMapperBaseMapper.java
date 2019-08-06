package com.example.demo.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.example.demo.entity.Student;
/**
*  @author zhanghaiyan
*/
public interface IStudentMapperBaseMapper {

    int insertStudent(Student object);

    int updateStudent(Student object);

    int update(Student.UpdateBuilder object);

    List<Student> queryStudent(Student object);

    Student queryStudentLimit1(Student object);

}