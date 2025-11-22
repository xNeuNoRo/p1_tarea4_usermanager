/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.models;

/**
 *
 * @author angel
 */
abstract public class Person {
    // Atributos de la persona
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;

    // Constructor
    public Person(String firstname, String lastname, String email, String phone_number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
    }

    // Getters y Setters
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
}
