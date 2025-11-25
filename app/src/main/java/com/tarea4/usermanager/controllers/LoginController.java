/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.controllers;

import java.sql.SQLException;

import com.tarea4.usermanager.services.UserService;

/**
 *
 * @author angel
 */
public class LoginController {
    // Instancia del servicio de usuario
    private final UserService service;

    // Constructor para inicializar el servicio
    public LoginController() {
        this.service = new UserService();
    }

    // Metodo para el login de un usuario
    public boolean login(String username, String password) throws SQLException, Exception {
        return service.login(username, password);
    }
}
