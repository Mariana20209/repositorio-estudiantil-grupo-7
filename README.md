# Repositorio Estudiantil - Grupo 7

API REST para gestionar proyectos académicos institucionales.

---

## Introducción / Contexto

En muchas instituciones educativas, los proyectos académicos desarrollados por los estudiantes no cuentan con un sistema centralizado que permita su organización, consulta y gestión estructurada.

Actualmente, estos trabajos pueden quedar almacenados de manera dispersa, dificultando su acceso y reutilización académica.

Este proyecto busca resolver ese problema mediante el desarrollo de una API backend que permita gestionar estudiantes y sus proyectos académicos dentro de un repositorio estructurado.

La relevancia del proyecto radica en su impacto académico, ya que facilita la organización del conocimiento institucional y promueve la consulta de trabajos previos como referencia para futuros estudiantes.

El dominio del proyecto corresponde a un sistema académico institucional enfocado en la gestión de proyectos estudiantiles.

---

## Objetivos

### Objetivo General

Desarrollar una API REST con Spring Boot para gestionar estudiantes y sus proyectos académicos en un repositorio institucional.

### Objetivos Específicos

- Diseñar el modelo de dominio estableciendo la relación entre Estudiante y Proyecto.
- Implementar entidades persistentes utilizando anotaciones JPA.
- Configurar la estructura del proyecto bajo arquitectura por capas.
- Preparar la conexión a base de datos relacional.
- Documentar técnicamente el proyecto conforme a las directrices del curso Backend 2.

---

## Alcance del Proyecto (Scope)

### Qué se va a desarrollar

- Modelo de dominio con entidades Estudiante y Proyecto.
- Relación 1:N entre estudiante y proyectos.
- Persistencia con Spring Data JPA.
- Servicios para lógica de negocio.
- Controladores REST.
- Validaciones básicas.
- Documentación de API.
- Pruebas unitarias.

### Qué NO se va a desarrollar en esta versión

- Sistema completo de autenticación con JWT.
- Interfaz frontend final productiva.
- Integración con sistemas institucionales reales.
- Despliegue en entorno de producción.
- Microservicios o arquitectura distribuida.

---

## Tecnologías y Herramientas (Tech Stack)

- **Backend**: Spring Boot 3.5.11, Java 21, Spring Data JPA  
- **Frontend**: No implementado en esta versión (API únicamente)  
- **Base de datos**: PostgreSQL (configurable), modelado en DBeaver  
- **ORM**: JPA (anotaciones en entidades)  
- **Control de versiones**: Git y GitHub  
- **Herramientas adicionales**: Maven, Lombok  

---

## Integrantes del Equipo

| Nombre     | Rol principal              | Usuario GitHub        |
|------------|---------------------------|-----------------------|
| Mariana    | Backend / Modelado BD     | @[Mariana20209]       |
| Santiago   | Backend                   | @[SantiagoCalderon11] |
| Viadis     | Documentación / Soporte   | @[vcorreaga]          |

---

## Diagrama de Clases del Dominio (v1)

![Diagrama de Dominio v1](docs/diagrama-dominio-v1.png)

*Diagrama inicial del modelo de dominio – versión 1. Se actualizará en futuras entregas.*

Incluye las entidades:

- Estudiante  
- Proyecto  

Relación principal:  
Un Estudiante puede tener múltiples Proyectos (1:N).

---

## Modelo del Dominio Implementado

### Entidad Estudiante

- id (Long)  
- nombre  
- email (único)  
- carrera  
- semestre  
- universidad  
- createdAt  
- updatedAt  

Relación:

```java
@OneToMany(mappedBy = "estudiante")
private List<Proyecto> proyectos;
```

---

### Entidad Proyecto

- id (Long)  
- titulo  
- descripcion  
- area  
- fechaEntrega  
- createdAt  
- updatedAt  

Relación:

```java
@ManyToOne
@JoinColumn(name = "estudiante_id", nullable = false)
private Estudiante estudiante;
```


## Estructura del Proyecto

```text
repositorio-estudiantil-grupo-7/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── grupo7/
│   │   │           └── repositorioestudiantil/
│   │   │               ├── config/
│   │   │               │   └── .gitkeep
│   │   │               ├── controller/
│   │   │               │   └── .gitkeep
│   │   │               ├── exception/
│   │   │               │   └── .gitkeep
│   │   │               ├── model/
│   │   │               │   ├── dto/
│   │   │               │   │   └── .gitkeep
│   │   │               │   └── entity/
│   │   │               │       ├── Estudiante.java
│   │   │               │       └── Proyecto.java
│   │   │               ├── repository/
│   │   │               │   └── EstudianteRepository.java
│   │   │               ├── service/
│   │   │               │   └── .gitkeep
│   │   │               └── RepositorioestudiantilApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
│       └── java/
│           └── com/
│               └── grupo7/
│                   └── repositorioestudiantil/
│                       └── RepositorioestudiantilApplicationTests.java
├── target/
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── docs/
    └── diagrama-dominio-v1.png




## Instrucciones de Instalación y Ejecución


1. Clonar el repositorio
git clone https://github.com/Mariana20209/repositorio-estudiantil-grupo-7.git

2. Ingresar al proyecto
cd repositorio-estudiantil-grupo-7

3.Configurar base de datos
src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://db.prisma.io:5432/postgres?sslmode=require
spring.datasource.username=d829c1d01055aa0acd156d59ff8d59382898f7bd3c83d31cba9ae443cda37c61
spring.datasource.password=sk_MTMaG9gd-w1Fxfq_0iPwA
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

4. Ejecutar la aplicación
.\mvnw.cmd spring-boot:run

5. Acceder a la API en:

http://localhost:8080
