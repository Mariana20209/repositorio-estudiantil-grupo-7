package com.studentsrepo.studentsrepo.repository;

import com.studentsrepo.studentsrepo.model.entity.Project;
import com.studentsrepo.studentsrepo.model.enums.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Este método está súper bien para filtrar proyectos por PENDIENTE, APROBADO, etc.
    List<Project> findByEstado(ProjectState estado);
}
