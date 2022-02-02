# User API
_Proyecto demo de API para creación, autorización y autenticación de usuarios utilizando el framework Spring boot._

## Demo
![Demo](https://user-images.githubusercontent.com/20669949/152192526-fa748c00-2110-4dc6-8ff8-91e7c7a3190d.gif)

## Características
### Generales
- Registro de usuarios.
- Inicio de sesión.
### Especiales
- Consultar todos los usuarios(Se limitada la información según el rol).
- Crear roles
- Consultar uno o todos los roles
- Eliminar rol.

## Requerimientos

Para la ejecución del proyecto se requiere como mínimo:
- [Git](https://git-scm.com/downloads) - Git es un sistema de control de versiones distribuido de código abierto y gratuito, diseñado para manejar todo tipo de proyectos con velocidad y eficiencia.
- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) - Java es un lenguaje de programación y una plataforma informática.
- [Visual Studio Code](https://code.visualstudio.com/download) - Visual Studio Code es un editor de código fuente multiplataforma desarrollado por Microsoft. (Puede usarse también cualquier IDE tales como IntelliJ IDEA, Eclipse, etc...).

## Documentacion del API
Puede [descargar](https://www.getpostman.com/collections/fd43523b6af49ed596ee) e importar la colección de Postman para usar debidamente la API o utilizar Swagger el cual viene integrado al proyecto.

## Instalación

Con anterioridad conviene haber instalado los elementos requidos ya mencionados, luego:

Clone el repositorio.

```bash
git clone git@github.com:edgewl2/sb-nisum-user-api.git
git status
```

Cargar el proyecto en el editor y ejecutar el proyecto desde la clase UserapiApplication.java, haciendo
click en el botón Run y estara listo para crear usuarios.

O si desea se puede construir e instalar desde la terminal, con los siguientes pasos:

On Mac or Linux
```bash
./gradlew bootRun
```

On Windows
```bash
gradlew.bat bootRun
```

## Tecnologías

- [Spring Boot](https://spring.io/projects/spring-boot) - Una infraestructura ligera para creación de aplicaciones independientes basadas en Spring mengüando el trabajo de configurar «Simplemente se ejecutan».
- [Spring Validation](https://docs.spring.io/spring-framework/docs/4.1.x/spring-framework-reference/html/validation.html#validation-beanvalidation) - Facilita la validacion de entrada de datos.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Parte de la familia Spring Data más grande, facilita la implementación de repositorios basados en JPA, que a su vez se provisiona a través de la implementacion de Hibernate.
- [Spring Boot Starter Web](https://spring.io/projects/spring-boot) - Basta para para poder arrancar un proyecto web api en minutos.
- [H2 Database](https://www.h2database.com/html/main.html) - H2 es un sistema administrador de bases de datos relacionales programado en Java. Puede ser incorporado en aplicaciones Java o ejecutarse de modo cliente-servidor.
- [JJWT](https://github.com/jwtk/jjwt) - Es una biblioteca más fácil de usar y comprender para crear y verificar JSON Web Tokens (JWT) en JVM y Android.
- [Sprindoc OpenApi](https://springdoc.org/#Introduction) - Librería que ayuda automatizar la generación de documentación de API para proyectos Spring Boot.
- [Mockito](https://site.mockito.org/) - Sabroso:laughing: marco de referencia para realizar pruebas unitarias en Java.
