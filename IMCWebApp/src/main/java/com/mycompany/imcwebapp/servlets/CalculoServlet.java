/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imcwebapp.servlets;

import com.mycompany.imcwebapp.dao.CalculoIMCDAO;
import com.mycompany.imcwebapp.model.CalculoIMC;
import com.mycompany.imcwebapp.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author jos9
 */
@WebServlet("/calcular")
public class CalculoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession(false);
        if (sesion == null || sesion.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Usuario u = (Usuario) sesion.getAttribute("usuario");
        double masa = Double.parseDouble(request.getParameter("masa"));

        if (masa <= 0) {
            request.setAttribute("error", "La masa debe ser mayor que 0.");
            request.getRequestDispatcher("calcular.jsp").forward(request, response);
            return;
        }

        double imc = masa / (u.getEstatura() * u.getEstatura());
        String interpretacion = interpretar(imc);

        CalculoIMC c = new CalculoIMC();
        c.setIdUsuario(u.getIdUsuario());
        c.setMasa(masa);
        c.setResultadoIMC(imc);
        c.setInterpretacion(interpretacion);

        CalculoIMCDAO dao = new CalculoIMCDAO();
        dao.guardar(c);

        request.setAttribute("resultado", imc);
        request.setAttribute("interpretacion", interpretacion);
        request.getRequestDispatcher("calcular.jsp").forward(request, response);
    }

    private String interpretar(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obesidad";
    }
}