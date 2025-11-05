/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.dao;
import com.mycompany.imcwebapp.model.Usuario;
import com.mycompany.imcwebapp.util.ConexionBD;
import java.sql.*;

/**
 *
 * @author jos9
 */
public class UsuarioDAO {
    public boolean registrar(Usuario u) {
        String sql = "INSERT INTO Usuario(nombre_completo, edad, sexo, estatura, nombre_usuario, contrasena_hash) VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombreCompleto());
            ps.setInt(2, u.getEdad());
            ps.setString(3, u.getSexo());
            ps.setDouble(4, u.getEstatura());
            ps.setString(5, u.getNombreUsuario());
            ps.setString(6, u.getContrasenaHash());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario login(String nombreUsuario, String contrasenaHash) {
        Usuario u = null;
        String sql = "SELECT * FROM Usuario WHERE nombre_usuario=? AND contrasena_hash=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenaHash);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombreCompleto(rs.getString("nombre_completo"));
                u.setEdad(rs.getInt("edad"));
                u.setSexo(rs.getString("sexo"));
                u.setEstatura(rs.getDouble("estatura"));
                u.setNombreUsuario(rs.getString("nombre_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}