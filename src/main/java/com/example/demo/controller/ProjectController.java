package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.project.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProjectController
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ICourseService courseService;

    @PostMapping
    public int add(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return courseService.removeCourse(id);
    }

    @PutMapping
    public int put(@RequestBody Course course) {
        return courseService.modify(course);
    }

    @GetMapping
    public List<Course> get(Course course) {
        return courseService.findCourseList(course);
    }
}
