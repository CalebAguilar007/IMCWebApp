/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.model;

/**
 *
 * @author jos9
 */
public class Usuario {
    private int idUsuario;
    private String nombreCompleto;
    private int edad;
    private String sexo;
    private double estatura;
    private String nombreUsuario;
    private String contrasenaHash;
    private int id;
    
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getNombreCompleto() { return nombreCompleto; }
public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
public int getEdad() { return edad; }
public void setEdad(int edad) { this.edad = edad; }
public String getSexo() { return sexo; }
public void setSexo(String sexo) { this.sexo = sexo; }
public double getEstatura() { return estatura; }
public void setEstatura(double estatura) { this.estatura = estatura; }
public String getNombreUsuario() { return nombreUsuario; }
public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
public String getContrasenaHash() { return contrasenaHash; }
public void setContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }

    public void setIdUsuario(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
