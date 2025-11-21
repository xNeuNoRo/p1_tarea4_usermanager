/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.config;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author angel
 */

public class AppConfig {

    private static AppConfig instance;
    private final Properties props = new Properties();

    // Constructor
    private AppConfig() {
        try {
            // Cargar las propiedades desde el archivo
            props.load(ClassLoader.getSystemResourceAsStream("application.properties")); // Cargar el archivo de propiedades
        } catch (IOException e) {
            System.out.println("Error cargando application.properties: " + e.getMessage());
        }
    }

    // Utilizar solo una instancia
    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // Obtener un valor por clave
    public String get(String key) {
        return props.getProperty(key);
    }
}
