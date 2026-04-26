package com.studentsrepo.studentsrepo.model.entity;

import com.studentsrepo.studentsrepo.model.embeddable.FullName;
import jakarta.persistence.*;
import lombok.*;

@Entity //Esto le dice a Spring Boot: "es una Entidad. Crea una tabla en la base de datos para ella".
@Table(name = "estudiantes") //Aqui estamos diciendo que la tabla se llama estudiantes
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Student extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String cedula;

    @Embedded
    private FullName fullName;

    private String carrera;

    @Column(unique = true, nullable = false)
    private String correoInstitucional;

}
