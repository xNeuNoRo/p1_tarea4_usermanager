/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea4.usermanager.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

/**
 *
 * @author angel
 */
public class PasswordUtils {
    // Crear instancia de argon2
    private static final Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);

    /**************************************************************************************************************/
    // REFACTOR: Usar Argon2 en lugar de SHA-256 para mas seguridad en password (mas
    // moderno y resistente q bcrypt)
    /**************************************************************************************************************/

    // Parametros de seguridad de Argon2

    // iteraciones - Aumentar este valor incrementa el tiempo necesario para generar
    // la password haciendola mas segura
    // Pero tiene su costo en rendimiento
    private static final int AR2_ITERATIONS = 2;

    // memoria - Cantidad de memoria (en KB) que se usara para hashear la password
    // Mientras mas memoria, mas seguro pero obviamente mas costoso en rendimiento
    private static final int AR2_MEMORY = 65536; // 64 MB en KB

    // paralelismo - Cantidad de hilos que se usaran para hashear la password
    // Mientras mas hilos, mas seguro pero obvio mas costoso en rendimiento
    private static final int AR2_PARALLELISM = 1; // Usamos 1 solo hilo

    // Metodo para hashear una contraseña usando Argon2
    public static String hash(String password) {
        try {
            String hash = argon2.hash(AR2_ITERATIONS, AR2_MEMORY, AR2_PARALLELISM, password.toCharArray());
            return hash;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error hasheando la contraseña: " + e.getMessage());
            return null;
        } finally {
            // Limpiar el array de caracteres de argon2 que contiene la contraseña
            argon2.wipeArray(password.toCharArray()); // Asi no se queda en memoria la pass
        }
    }

    // Metodo para comparar una contraseña plana con una hasheada
    public static boolean compare(String plain, String hash) {
        // Recibo la password plana (sin hashear) y la hasheada para comparar
        // Argon2 se encargaria de hashearla internamente y comparar
        return argon2.verify(hash, plain.toCharArray());
    }
}
