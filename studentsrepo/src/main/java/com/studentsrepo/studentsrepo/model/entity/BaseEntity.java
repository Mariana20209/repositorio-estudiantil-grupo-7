package com.studentsrepo.studentsrepo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass // ¡IMPORTANTÍSIMO! Sin esto, Estudiante y Proyecto no verán el ID.
@EntityListeners(AuditingEntityListener.class) // Esto hace que las fechas funcionen automáticamente.
@Getter
@Setter // Para que no tengas que escribir los Getters y Setters a mano.
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime fechaModificacion;
}
