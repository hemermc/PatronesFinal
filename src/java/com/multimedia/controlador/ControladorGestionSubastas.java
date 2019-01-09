/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.Subasta;
import com.multimedia.modelo.crud.CRUDSubasta;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
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
@WebServlet(name = "ControladorGestionSubastas", urlPatterns = {"/ControladorGestionSubastas"})
public class ControladorGestionSubastas extends HttpServlet {

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
        HttpSession session = request.getSession();

        if (session.getAttribute("usuario") != null) {//Existe un usuario logueado
            GestionBBDDLocalhost gestionDB = GestionBBDDLocalhost.getInstance();
            Connection conexion = gestionDB.establecerConexion();
            CRUDSubasta subastas = new CRUDSubasta(conexion);
            session.setAttribute("subastas", subastas.obtenerTodos());
            response.sendRedirect("./VistaSubastasAdmin.jsp");
        } else {//Si el cliente no ha iniciado sesión
            response.sendRedirect("./VistaInicioSesion.jsp");
        }
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

        CRUDSubasta usoSubasta = new CRUDSubasta(conexion);
        
        switch (accion) {
            case "insertar": {
                usoSubasta.insertar(new Subasta(
                        request.getParameter("Nombre"),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        LocalDate.parse(request.getParameter("Fecha")),
                        false,
                        Integer.parseInt(request.getParameter("Lote"))));
            }
            case "actualizar": {
                usoSubasta.insertar(new Subasta(
                        request.getParameter("Nombre"),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        LocalDate.parse(request.getParameter("Fecha")),
                        false,
                        Integer.parseInt(request.getParameter("Lote"))));
            }
            case "eliminar": {
                usoSubasta.eliminar(request.getParameter("id_subasta"));
                break;
            }
        }
        ArrayList<Subasta> subastas = usoSubasta.obtenerTodos();
        session.setAttribute("subastas", subastas);
        response.sendRedirect(request.getContextPath() + "/ControladorGestionSubastas");

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
