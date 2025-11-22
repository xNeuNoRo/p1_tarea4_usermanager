/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class DatabaseConnection {
    private static Connection db;

    // Metodo para obtener la conexion a la base de datos
    public static Connection getDb() {
        if (db == null) {
            try {
                // Instanciar AppConfig
                AppConfig config = AppConfig.getInstance();

                // Obtener el Host + Credenciales de la db
                String url = config.get("db.url");
                String user = config.get("db.user");
                String pass = config.get("db.pass");

                // Crear conexion con la BD MySQL
                db = DriverManager.getConnection(url, user, pass);

                System.out.println("Conexion a la BD de MYSQL establecida exitosamente!");
            } catch (SQLException e) {
                System.out.println("Error conectando a la base de datos: " + e.getMessage());
            }
        }
        
        // Retornamos la bd
        return db;
    }
}
