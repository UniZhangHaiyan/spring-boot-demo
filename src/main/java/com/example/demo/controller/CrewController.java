package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.crew.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CrewController
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@RestController
@RequestMapping("crew")
public class CrewController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public int add(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return studentService.removeStudent(id);
    }

    @PutMapping
    public int put(@RequestBody Student student) {
        return studentService.modify(student);
    }

    @GetMapping
    public List<Student> get(Student student) {
        return studentService.findStudentList(student);
    }
}
