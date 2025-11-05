/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.model;

/**
 *
 * @author jos9
 */
public class IMCUtil {
    public static double calcularIMC(double masa, double estatura) {
    if (estatura <= 0) return 0;
    double imc = masa / (estatura * estatura);
    return Math.round(imc * 100.0) / 100.0; // 2 decimales
}


public static String interpretar(double imc) {
 if (imc <= 0) return "Inválido";
 if (imc < 18.5) return "Bajo peso";
 if (imc < 25) return "Normal";
 if (imc < 30) return "Sobrepeso";
 return "Obesidad";
 }
}
