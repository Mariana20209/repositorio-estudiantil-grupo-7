package com.studentsrepo.studentsrepo.controller;

import com.studentsrepo.studentsrepo.model.entity.Student;
import com.studentsrepo.studentsrepo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET para listar: http://localhost:8081/api/students
    @GetMapping
    public List<Student> getAll() {
        return studentService.listarTodos();
    }

    // POST para crear
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.guardar(student);
    }
}