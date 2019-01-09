/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.Billete;
import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.crud.CRUDBillete;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorGestionBilletes", urlPatterns = {"/ControladorGestionBilletes"})
public class ControladorGestionBilletes extends HttpServlet {


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
        GestionBBDDLocalhost gestionDB = GestionBBDDLocalhost.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        HttpSession session = request.getSession(true);
        CRUDBillete usoBilletes = new CRUDBillete(conexion);
        session.setAttribute("billetes", usoBilletes.obtenerTodos());
        response.sendRedirect("VistaBilletesAdmin.jsp");
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
        CRUDBillete usoBillete = new CRUDBillete(conexion);

        switch (accion) {
            case "insertar": {
                usoBillete.insertar(new Billete(
                        request.getParameter("valor"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("lugar_emision"),
                        LocalDate.parse(request.getParameter("fecha")),
                        request.getParameter("serie"),
                        request.getParameter("conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto")));
                break;
            }
            case "actualizar": {
                usoBillete.actualizar(new Billete(
                        request.getParameter("valor"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("lugar_emision"),
                        LocalDate.parse(request.getParameter("fecha")),
                        request.getParameter("serie"),
                        request.getParameter("conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto")));
                break;
            }
            case "eliminar":{
                usoBillete.eliminar(request.getParameter("lote"));
                break;
            }
        }
        ArrayList<Billete> billetes = usoBillete.obtenerTodos();
        session.setAttribute("billetes", billetes);
        response.sendRedirect("VistaBilletesAdmin.jsp");
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
