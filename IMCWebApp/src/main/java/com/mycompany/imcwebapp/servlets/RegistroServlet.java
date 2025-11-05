/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.servlets;

import com.mycompany.imcwebapp.dao.UsuarioDAO;
import com.mycompany.imcwebapp.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
/**
 *
 * @author jos9
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        // Validaciones
        if (edad < 15 || estatura < 1.0 || estatura > 2.5) {
            request.setAttribute("error", "Edad o estatura no válidas.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        Usuario u = new Usuario();
        u.setNombreCompleto(nombre);
        u.setEdad(edad);
        u.setSexo(sexo);
        u.setEstatura(estatura);
        u.setNombreUsuario(usuario);
        u.setContrasenaHash(hashPassword(contrasena));

        UsuarioDAO dao = new UsuarioDAO();
        boolean exito = dao.registrar(u);

        if (exito) {
            request.setAttribute("mensaje", "Usuario registrado correctamente.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error al registrar. Usuario ya existe.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

    private String hashPassword(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
