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
public class LoginController {
    private final UserService service;

    public LoginController() {
        this.service = new UserService();
    }

    public boolean login(String username, String password) throws SQLException, Exception {
        return service.login(username, password);
    }
}
