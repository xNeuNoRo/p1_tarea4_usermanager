/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.models;

/**
 *
 * @author angel
 */
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;
    private String username;
    private String password;

    // Constructor
    public User(String firstname, String lastname, String email, String phone_number, String username,
            String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    // Getters Y Setters
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String newFirstname) {
        this.firstname = newFirstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String newLastname) {
        this.lastname = newLastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String newPhone_number) {
        this.phone_number = newPhone_number;
    }

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
