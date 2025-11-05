/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.dao;
import com.mycompany.imcwebapp.model.CalculoIMC;
import com.mycompany.imcwebapp.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jos9
 */
public class CalculoIMCDAO {
    public boolean guardar(CalculoIMC c) {
        String sql = "INSERT INTO CalculoIMC(id_usuario, masa, resultado_imc, interpretacion) VALUES (?,?,?,?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getIdUsuario());
            ps.setDouble(2, c.getMasa());
            ps.setDouble(3, c.getResultadoIMC());
            ps.setString(4, c.getInterpretacion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CalculoIMC> listarPorUsuario(int idUsuario) {
        List<CalculoIMC> lista = new ArrayList<>();
        String sql = "SELECT * FROM CalculoIMC WHERE id_usuario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CalculoIMC c = new CalculoIMC();
                c.setIdCalculo(rs.getInt("id_calculo"));
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setMasa(rs.getDouble("masa"));
                c.setResultadoIMC(rs.getDouble("resultado_imc"));
                c.setInterpretacion(rs.getString("interpretacion"));
                c.setFechaCalculo(rs.getTimestamp("fecha_calculo"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
