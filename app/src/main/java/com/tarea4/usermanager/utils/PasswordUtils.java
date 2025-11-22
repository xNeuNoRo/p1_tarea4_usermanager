/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author angel
 */
public class PasswordUtils {
    // Metodo para hashear una contraseña usando SHA-256
    public static String hash(String password) {
        try {
            // Obtenemos una instancia de SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Obtengo los bytes del String y luego los convierto en bytes irreversibles (SHA-256)
            byte[] passBytes = md.digest(password.getBytes());
            // Luego los convierto a texto con Base64
            return Base64.getEncoder().encodeToString(passBytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Ha ocurrido un error hasheando la contraseña: " + e.getMessage());
            return null;
        }
    }
    
    // Metodo para comparar una contraseña plana con una hasheada
    public static boolean compare(String plain, String hash) {
        // Recibo la password plana (sin hashear) y la hasheo para retornar la comparacion que seria un boolean
        return hash(plain).equals(hash);
    }
}
