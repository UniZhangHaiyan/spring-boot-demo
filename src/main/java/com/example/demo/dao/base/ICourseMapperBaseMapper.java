package com.example.demo.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.example.demo.entity.Course;
/**
*  @author zhanghaiyan
*/
public interface ICourseMapperBaseMapper {

    int insertCourse(Course object);

    int updateCourse(Course object);

    int update(Course.UpdateBuilder object);

    List<Course> queryCourse(Course object);

    Course queryCourseLimit1(Course object);

}