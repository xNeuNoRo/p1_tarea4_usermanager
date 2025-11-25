/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.repository;

import com.tarea4.usermanager.config.DatabaseConnection;
import com.tarea4.usermanager.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */

// TODO: adaptar las querys del repositorio para que sea compatible con la bd que proporcionaron en clase

// Repositorio de funciones que consumira el servicio
public class UserRepository {
    private final Connection db;

    // Constructor para obtener la db
    public UserRepository() {
        db = DatabaseConnection.getDb();
    }

    // Guardar un usuario en la bd
    public void save(User user) throws SQLException {
        // Establezco la query con variables "?"
        String sql = "INSERT INTO usuarios (Nombre, Apellido, Email, Telefono, UserName, Password) VALUES (?, ?, ?, ?, ?, ?)";

        // Utilizo PreparedStatement para prevenir Inyeccion SQL
        PreparedStatement preparedQuery = db.prepareStatement(sql);

        // Asigno los valores a las variables "?"
        preparedQuery.setString(1, user.getFirstname());
        preparedQuery.setString(2, user.getLastname());
        preparedQuery.setString(3, user.getEmail());
        preparedQuery.setString(4, user.getPhoneNumber());
        preparedQuery.setString(5, user.getUsername());
        preparedQuery.setString(6, user.getPassword());

        // Ejecuto la query
        preparedQuery.executeUpdate();
    }

    // Obtener todos los usuarios de la bd
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        // Establezco la query
        String sql = "SELECT * FROM usuarios";

        // Utilizo PreparedStatement para prevenir Inyeccion SQL
        PreparedStatement preparedQuery = db.prepareStatement(sql);
        ResultSet result = preparedQuery.executeQuery();

        // Recorro todas las filas de los resultados y los agrego a la lista
        while (result.next()) {
            // Creo un nuevo usuario en memoria instanciando la clase y lo agrego a la lista
            users.add(
                    new User(
                            result.getString("Nombre"),
                            result.getString("Apellido"),
                            result.getString("Email"),
                            result.getString("Telefono"),
                            result.getString("UserName"),
                            result.getString("Password")));
        }

        // Retorno la lista de usuarios
        return users;
    }

    // Buscar un usuario por su username
    public User findByUsername(String username) throws SQLException {
        // Establezco la query
        String sql = "SELECT * FROM usuarios WHERE UserName = ?";

        // Utilizo PreparedStatement para prevenir Inyeccion SQL
        PreparedStatement preparedQuery = db.prepareStatement(sql);

        // Asigno el valor a la variable "?"
        preparedQuery.setString(1, username);

        ResultSet result = preparedQuery.executeQuery();

        // Si encontro un usuario con ese username
        if (result.next()) {
            return new User(
                    result.getString("Nombre"),
                    result.getString("Apellido"),
                    result.getString("Email"),
                    result.getString("Telefono"),
                    result.getString("UserName"),
                    result.getString("Password"));
        }

        // Si no encontro ningun usuario, retorno null
        return null;
    }

    // Actualizar un usuario (mediante su username) en la bd
    public void update(User user, String username) throws SQLException {
        String sql = "UPDATE usuarios SET UserName = ?, Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, Password = ? WHERE UserName = ?";

        // Utilizo PreparedStatement para prevenir Inyeccion SQL
        PreparedStatement preparedQuery = db.prepareStatement(sql);

        // Asigno los valores a las variables "?"
        preparedQuery.setString(1, user.getUsername());
        preparedQuery.setString(2, user.getFirstname());
        preparedQuery.setString(3, user.getLastname());
        preparedQuery.setString(4, user.getEmail());
        preparedQuery.setString(5, user.getPhoneNumber());
        preparedQuery.setString(6, user.getPassword());
        preparedQuery.setString(7, username);

        // Ejecuto la query
        preparedQuery.executeUpdate();
    }

    // Eliminar un usuario (por username) de la bd
    public void delete(String username) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE UserName = ?";

        // Utilizo PreparedStatement para prevenir Inyeccion SQL
        PreparedStatement preparedQuery = db.prepareStatement(sql);

        // Asigno el valor a la variable "?"
        preparedQuery.setString(1, username);

        // Ejecuto la query
        preparedQuery.executeUpdate();
    }
}
