package com.studentsrepo.studentsrepo.repository;

import com.studentsrepo.studentsrepo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Esto nos servirá para validar el correo institucional más adelante
    Optional<Student> findByCorreoInstitucional(String correo);
    // JpaRepository ya trae los métodos save(), findAll(), delete(), etc.
}
