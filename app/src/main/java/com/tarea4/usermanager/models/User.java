/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.models;

/**
 *
 * @author angel
 */
public class User extends Person {
    // Atributos del usuario
    private String username;
    private String password;

    // Constructor
    public User(String firstname, String lastname, String email, String phone_number, String username,
            String password) {
        // Llamada al constructor de la clase padre
        super(firstname, lastname, email, phone_number);
        this.username = username;
        this.password = password;
    }

    // Getters Y Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
