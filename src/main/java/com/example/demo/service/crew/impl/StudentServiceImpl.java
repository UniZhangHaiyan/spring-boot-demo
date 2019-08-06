package com.example.demo.service.crew.impl;

import com.example.demo.dao.IStudentMapperMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.crew.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapperMapper studentMapperMapper;

    @Override
    public int saveStudent(Student student) {
        return studentMapperMapper.insertStudent(student);
    }

    @Override
    public int removeStudent(Long studentId) {
        return studentMapperMapper.delete(studentId);
    }

    @Override
    public int modify(Student student) {
        return studentMapperMapper.updateStudent(student);
    }

    @Override
    public List<Student> findStudentList(Student student) {
        return studentMapperMapper.queryStudent(student);
    }

    @Override
    public Student findStudent(Student student) {
        return studentMapperMapper.queryStudentLimit1(student);
    }
}
