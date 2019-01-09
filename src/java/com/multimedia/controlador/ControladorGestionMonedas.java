/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.Moneda;
import com.multimedia.modelo.crud.CRUDMoneda;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amunguia
 */
@WebServlet(name = "ControladorGestionMonedas", urlPatterns = {"/ControladorGestionMonedas"})
public class ControladorGestionMonedas extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Queremos mostrar las monedas 
        GestionBBDDLocalhost gestionDB = GestionBBDDLocalhost.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        HttpSession session = request.getSession(true);
        CRUDMoneda usoMoneda = new CRUDMoneda(conexion);
        session.setAttribute("monedas", usoMoneda.obtenerTodos());
        response.sendRedirect("VistaMonedasAdmin.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionBBDDLocalhost gestionDB = GestionBBDDLocalhost.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        HttpSession session = request.getSession(true);
        String accion = request.getParameter("accion");

        CRUDMoneda usoMoneda = new CRUDMoneda(conexion);
        switch (accion) {
            case "insertar": {
                usoMoneda.insertar(new Moneda(
                        request.getParameter("valor"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("estrellas"),
                        request.getParameter("lugar_emision"),
                        request.getParameter("conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto")));
                break;
            }
            case "actualizar": {
                usoMoneda.insertar(new Moneda(
                        request.getParameter("valor"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("estrellas"),
                        request.getParameter("lugar_emision"),
                        request.getParameter("conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto")));
                break;
            }
            case "eliminar": {
                usoMoneda.eliminar(request.getParameter("lote"));
                break;
            }
        }
        ArrayList<Moneda> monedas = usoMoneda.obtenerTodos();
        session.setAttribute("monedas", monedas);
        response.sendRedirect("VistaMonedasAdmin.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
