/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.servlets;

import com.google.gson.Gson;
import com.mycompany.imcwebapp.dao.CalculoIMCDAO;
import com.mycompany.imcwebapp.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author jos9
 */
@WebServlet("/api/historial")
public class HistorialRest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession(false);
        if (sesion == null || sesion.getAttribute("usuario") == null) {
            response.setStatus(401);
            return;
        }

        Usuario u = (Usuario) sesion.getAttribute("usuario");
        CalculoIMCDAO dao = new CalculoIMCDAO();

        response.setContentType("application/json");
        new Gson().toJson(dao.listarPorUsuario(u.getIdUsuario()), response.getWriter());
    }
}
