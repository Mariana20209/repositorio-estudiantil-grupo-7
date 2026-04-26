package com.studentsrepo.studentsrepo.controller;
import com.studentsrepo.studentsrepo.model.entity.Project;
import com.studentsrepo.studentsrepo.model.entity.Student;
import com.studentsrepo.studentsrepo.repository.ProjectRepository;
import com.studentsrepo.studentsrepo.repository.StudentRepository;
import com.studentsrepo.studentsrepo.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/proyectos")
public class ProjectController {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> subirProyecto(
            @RequestParam("file") MultipartFile file,
            @RequestParam("titulo") String titulo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("studentId") Long studentId
    ) {

        try {
            // 1. Buscar estudiante
            Student estudiante = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

            // 2. Guardar archivo
            String fileName = fileStorageService.save(file);

            // 3. Crear proyecto
            Project proyecto = new Project();
            proyecto.setTitulo(titulo);
            proyecto.setDescripcion(descripcion);
            proyecto.setArchivoPdfPath(fileName);
            proyecto.setAutor(estudiante);

            // 4. Guardar en BD
            projectRepository.save(proyecto);

            return ResponseEntity.ok("Proyecto subido con éxito");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
