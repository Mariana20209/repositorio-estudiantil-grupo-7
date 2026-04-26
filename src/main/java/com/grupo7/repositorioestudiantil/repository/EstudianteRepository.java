package com.grupo7.repositorioestudiantil.repository;

import com.grupo7.repositorioestudiantil.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // "Quiero un repositorio para la entidad Estudiante y su ID es de tipo Long, La tabla que manejaré es Estudiante, El campo @Id es tipo Long
}
