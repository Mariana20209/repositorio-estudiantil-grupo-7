package com.studentsrepo.studentsrepo.model.entity;

import com.studentsrepo.studentsrepo.model.enums.ProjectState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private String archivoPdfPath; // Guardaremos la ruta del archivo en el servidor

    @Enumerated(EnumType.STRING)
    private ProjectState estado = ProjectState.PENDIENTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Student autor;

    // Campos de auditoría adicionales si lo deseas (opcional)
    private String observacionesAdmin;
}
