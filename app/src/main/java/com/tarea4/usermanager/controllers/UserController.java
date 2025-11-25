/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.controllers;

import java.sql.SQLException;
import java.util.List;

import com.tarea4.usermanager.models.User;
import com.tarea4.usermanager.services.UserService;

/**
 *
 * @author angel
 */
public class UserController {
    // Instancia del servicio de usuario
    private final UserService service;

    // Constructor para inicializar el servicio
    public UserController() {
        this.service = new UserService();
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() throws SQLException {
        return service.getAllUsers();
    }

    // Crear un nuevo usuario
    public void createUser(String firstname, String lastname, String email, String phoneNumber, String username,
            String password, String confirmPassword) throws SQLException, Exception {
        service.register(firstname, lastname, email, phoneNumber, username, password, confirmPassword);
    }

    // Actualizar un usuario existente
    public void updateUser(String username, String firstname, String lastname, String email, String phoneNumber, String newUsername,
            String password) throws SQLException, Exception {
        service.update(username, firstname, lastname, email, phoneNumber, newUsername, password);
    }

    // Eliminar un usuario
    public void deleteUser(String username) throws SQLException {
        service.delete(username);
    }

    // Obtener un usuario por su username
    public User getUser(String username) throws SQLException {
        return service.getUserByUsername(username);
    }
}
