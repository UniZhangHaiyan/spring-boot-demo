package com.example.demo.service.project;

import com.example.demo.entity.Course;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * @ClassName ICourseService
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@DataSourceType(DataSourceType.project)
public interface ICourseService {
    /**
     * 增
     *
     * @param course
     * @return
     */
    int saveCourse(Course course);

    /**
     * 删
     *
     * @param courseId
     * @return
     */
    int removeCourse(Long courseId);

    /**
     * 改
     *
     * @param course
     * @return
     */
    int modify(Course course);

    /**
     * 查询列表
     *
     * @param course
     * @return
     */
    List<Course> findCourseList(Course course);

    /**
     * 查询一个
     *
     * @param course
     * @return
     */
    Course findCourse(Course course);
}
