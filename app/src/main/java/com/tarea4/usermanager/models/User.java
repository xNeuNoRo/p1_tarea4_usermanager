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
    private String username;
    private String password;
    
    // Constructor
    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
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
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String newUsername) {
        this.username =  newUsername;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
