/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.Subasta;
import com.multimedia.modelo.crud.CRUDBillete;
import com.multimedia.modelo.crud.CRUDMoneda;
import com.multimedia.modelo.crud.CRUDSubasta;
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

@WebServlet(name = "ControladorAccesoSubasta", urlPatterns = {"/ControladorAccesoSubasta"})
public class ControladorAccesoSubasta extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

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
            String tipo = request.getParameter("tipo");
            CRUDSubasta subastas = new CRUDSubasta(conexion);
            CRUDMoneda monedas = new CRUDMoneda(conexion);
            CRUDBillete billetes = new CRUDBillete(conexion);

            session.setAttribute("lista-subastas", subastas.obtenerTipo(tipo));
            ArrayList<Subasta> lassubastas= subastas.obtenerTipo(tipo);
            ArrayList<Object> listalote =new ArrayList();
            
            if (tipo.equalsIgnoreCase("Monedas")) {//Se accede a una subasta de Monedas
                session.setAttribute("tipo-subasta", "Monedas");
                for (Subasta subasta: lassubastas){
                   listalote.add(monedas.obtenerEspecifico(String.valueOf(subasta.getLote()))); 
                    }
            } else if (tipo.equalsIgnoreCase("Billetes")) {//Se acceder a una subasta de Billetes
                session.setAttribute("tipo-subasta", "Billetes");
                for (Subasta subasta: lassubastas){
                    listalote.add(billetes.obtenerEspecifico(String.valueOf(subasta.getLote())));  
                 }
            }
            
            session.setAttribute("listalote", listalote);
            response.sendRedirect("./VistaSubastasCliente.jsp");
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

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}

