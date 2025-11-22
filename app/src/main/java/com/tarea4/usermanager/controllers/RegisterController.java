/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.controllers;

import java.sql.SQLException;

import com.tarea4.usermanager.models.UserService;

/**
 *
 * @author angel
 */
public class RegisterController {
    // Instancia del servicio de usuario
    private final UserService service;

    // Constructor para inicializar el servicio
    public RegisterController() {
        this.service = new UserService();
    }

    // Metodo para registrar un nuevo usuario
    public void register(String firstname, String lastname, String email, String phoneNumber, String username,
            String password, String confirmPassword) throws SQLException, Exception {
        service.register(firstname, lastname, email, phoneNumber, username, password, confirmPassword);
    }
}
