package com.example.demo.service.project.impl;

import com.example.demo.dao.ICourseMapperMapper;
import com.example.demo.entity.Course;
import com.example.demo.service.project.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseMapperMapper courseMapperMapper;

    @Override
    public int saveCourse(Course course) {
        return courseMapperMapper.insertCourse(course);
    }

    @Override
    public int removeCourse(Long courseId) {
        return courseMapperMapper.delete(courseId);
    }

    @Override
    public int modify(Course course) {
        return courseMapperMapper.updateCourse(course);
    }

    @Override
    public List<Course> findCourseList(Course course) {
        return courseMapperMapper.queryCourse(course);
    }

    @Override
    public Course findCourse(Course course) {
        return courseMapperMapper.queryCourseLimit1(course);
    }
}
