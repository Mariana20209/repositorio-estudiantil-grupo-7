package com.studentsrepo.studentsrepo.service;

import com.studentsrepo.studentsrepo.model.entity.Student;
import com.studentsrepo.studentsrepo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService { //<--- Es una CLASS
    @Autowired
    private StudentRepository studentRepository;

    // Para ver todos los estudiantes
    public List<Student> listarTodos() {
        return studentRepository.findAll();
    }

    // Para registrar un estudiante nuevo
    public Student guardar(Student student) {
        return studentRepository.save(student);
    }
}
