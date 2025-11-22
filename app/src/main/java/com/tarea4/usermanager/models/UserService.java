/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.models;

import com.tarea4.usermanager.utils.PasswordUtils;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author angel
 */

// Servicio que consume el Repositorio y sera utilizado por el controlador
public class UserService {
    private final UserRepository repository;

    // Constructor para inicializar el repositorio
    public UserService() {
        this.repository = new UserRepository();
    }

    // Registrar un nuevo usuario
    public void register(String firstname, String lastname, String email, String phoneNumber, String username,
            String password, String confirmPassword) throws SQLException, Exception {
        // Validaciones
        if (firstname.isBlank() || lastname.isBlank() || email.isBlank() || phoneNumber.isBlank() || username.isBlank()
                || password.isBlank() || confirmPassword.isBlank()) {
            throw new Exception("Todos los campos son obligatorios.");
        }

        if (!password.equals(confirmPassword)) {
            throw new Exception("Las contraseñas no coinciden.");
        }

        // Verificar si el usuario ya existe
        User existingUser = repository.findByUsername(username);
        if (existingUser != null) {
            throw new Exception("El nombre de usuario ya está en uso.");
        }

        // Hasheamos la contraseña
        String hashedPassword = PasswordUtils.hash(password);

        // Crear el usuario y guardarlo en la bd
        User user = new User(firstname, lastname, email, phoneNumber, username, hashedPassword);
        repository.save(user);
    }

    // Login de un usuario
    public boolean login(String username, String password) throws SQLException, Exception {
        // Validaciones
        if (username.isBlank() || password.isBlank()) {
            throw new Exception("El nombre de usuario y la contraseña son obligatorios.");
        }

        // Buscar el usuario en la bd
        User user = repository.findByUsername(username);
        // Si no existe, lanzar error
        if (user == null) {
            throw new Exception("Usuario no encontrado.");
        }

        // Verificar la contraseña comparado hashes
        // password seria la contraseña plana y user.getPassword() la hasheada
        return PasswordUtils.compare(password, user.getPassword());
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() throws SQLException {
        // Simplemente llamamos la funcion findAll del repositorio
        return repository.findAll();
    }

    // Obtener un usuario por su username
    public User getUserByUsername(String username) throws SQLException {
        // Simplemente llamamos la funcion findByUsername del repositorio
        return repository.findByUsername(username);
    }

    // Actualizar un usuario
    public void update(String firstname, String lastname, String email, String phoneNumber, String username,
            String password)
            throws SQLException, Exception {
        // Validaciones
        if (firstname.isBlank() || lastname.isBlank() || email.isBlank() || phoneNumber.isBlank()
                || username.isBlank()) {
            throw new Exception("Todos los campos son obligatorios.");
        }

        // Buscar el usuario en la bd
        User user = repository.findByUsername(username);

        // Si no existe, lanzar error
        if (user == null) {
            throw new SQLException("Usuario no encontrado.");
        }

        // Actualizar los datos del usuario
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        // Si la contraseña no esta vacia, actualizarla (hasheandola)
        if (password != null && !password.isBlank()) {
            user.setPassword(PasswordUtils.hash(password));
        }

        // Guardar los cambios en la bd
        repository.update(user);
    }

    // Eliminar un usuario
    public void delete(String username) throws SQLException {
        // Simplemente llamamos la funcion delete del repositorio y le pasamos el
        // username
        repository.delete(username);
    }
}
