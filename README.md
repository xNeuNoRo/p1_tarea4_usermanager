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

## Nota

Debes crear en la carpeta de "resources" el archivo de "application.properties"
Y agregar las siguientes variables para el correcto funcionamiento del programa:

```
# Aqui pones el url de tu base de datos MySQL incluyendo el prefijo 'jdbc'
db.url=jdbc:mysql://localhost:3306/p1tarea4

# Aqui pasas las credenciales de tu base de datos
db.user=root
db.pass=neunoro_dev
```

Basicamente sigue la estructura del "application.example.properties".
> Ojo: Esta base de datos de ejemplo corre en un contenedor Docker local, por lo que el usuario y contraseña usados en este archivo NO te funcionarán y existen únicamente para fines prácticos del proyecto.