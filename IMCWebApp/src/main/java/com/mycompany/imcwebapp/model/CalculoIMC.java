/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.model;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jos9
 */
public class CalculoIMC {
private int id;
private int idUsuario;
private double masa;
private double resultadoIMC;
private String interpretacion;
private Date fecha;


// getters y setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public int getIdUsuario() { return idUsuario; }
public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
public double getMasa() { return masa; }
public void setMasa(double masa) { this.masa = masa; }
public double getResultadoIMC() { return resultadoIMC; }
public void setResultadoIMC(double resultadoIMC) { this.resultadoIMC = resultadoIMC; }
public String getInterpretacion() { return interpretacion; }
public void setInterpretacion(String interpretacion) { this.interpretacion = interpretacion; }
public Date getFecha() { return fecha; }
public void setFecha(Date fecha) { this.fecha = fecha; }

    public void setIdCalculo(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFechaCalculo(Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
