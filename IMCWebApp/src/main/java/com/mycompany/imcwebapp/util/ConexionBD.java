/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jos9
 */
public class ConexionBD {

    // 🔗 URL de conexión a MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/imc_app?useSSL=false&serverTimezone=UTC";

    // 👤 Usuario y contraseña de tu base de datos
    private static final String USUARIO = "system";
    private static final String CONTRASENA = "iloveBBQ";

    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar conexión
            Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conectado exitosamente a MySQL: " + conn.getMetaData().getURL());
            return conn;

        } catch (ClassNotFoundException e) {
            System.err.println("❌ No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return null;
    }
}
