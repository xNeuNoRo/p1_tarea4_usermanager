# Programacion I Tarea 4 - User Manager

[![Estado](https://img.shields.io/badge/status-completed-brightgreen)](https://github.com/xNeuNoRo/p1_tarea4_usermanager/)
[![Gradle Groovy](https://img.shields.io/badge/bundler-gradle%20groovy-blue)](https://vitejs.dev/)
[![License: MIT](https://img.shields.io/badge/license-MIT-green)](./LICENSE)

> Proyecto de práctica: CRUD de Usuarios en Java Swing
> Aplicación creada con Netbeans Apache.  

## Contenido

- Arquitectura MVC (Model-View-Controller)
- Patrones de diseño (Singleton)
- Medidas de seguridad como Hashear la contraseña
- Detalles extra como el rellenar los campos al editar un usuario

## Screenshots

<div style="display: grid; grid-template-columns: repeat(3, 1fr); column-gap: 1rem" align="center">
  <img src="assets/Register.png" width="400" />
  <img src="assets/Login.png" width="400" />
  <img src="assets/UserManagement.png" width="400" />
</div>

## Como ejecutarlo

1. Clonar el repositorio  
2. Crear la base de datos con el script SQL [(Leer nota)](#nota)
3. Crear `application.properties` con tus credenciales [(Leer nota)](#nota)
4. Ejecutar el proyecto desde NetBeans o usando:
```bash
gradle run
```

## Nota

Deberas crear la tabla "users" en tu base de datos MySQL con el siguiente query:
```sql
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

Tambien, debes crear en la carpeta de "resources" el archivo de "application.properties"
Y agregar las siguientes variables para el correcto funcionamiento del programa:

```properties
# Aqui pones el url de tu base de datos MySQL incluyendo el prefijo 'jdbc'
db.url=jdbc:mysql://localhost:3306/p1tarea4

# Aqui pasas las credenciales de tu base de datos
db.user=root
db.pass=neunoro_dev
```

Basicamente sigue la estructura del "application.example.properties".
> Ojo: Esta base de datos de ejemplo corre en un contenedor Docker local, por lo que el usuario y contraseña usados en este archivo NO te funcionarán y existen únicamente para fines prácticos del proyecto.