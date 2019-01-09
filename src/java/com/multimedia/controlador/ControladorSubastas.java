/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.Puja;
import com.multimedia.modelo.Subasta;
import com.multimedia.modelo.Usuario;
import com.multimedia.modelo.crud.CRUDPujas;
import com.multimedia.modelo.crud.CRUDSubasta;
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet(name = "ControladorSubastas", urlPatterns = {"/ControladorSubastas"})
public class ControladorSubastas extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        Usuario user = (Usuario) session.getAttribute("usuario");
        CRUDSubasta usoSubasta = new CRUDSubasta(conexion);
        String idsubasta = request.getParameter("id-subasta");
        Subasta subasta = usoSubasta.obtenerEspecifico(idsubasta);
        String tipo = request.getParameter("tipo");

        if (Float.parseFloat(request.getParameter("puja")) > subasta.getPrecioFinal()) {
            CRUDPujas usoPuja = new CRUDPujas(conexion);
            Puja puja = new Puja(
                    Integer.parseInt(request.getParameter("id-subasta")),
                    user.getNombre_usuario(),
                    Float.parseFloat(request.getParameter("puja")));

            if (usoPuja.obtenerEspecifico(idsubasta, user.getNombre_usuario()) != null) {//Si exite la puja la actualiza
                usoPuja.actualizar(puja);
            } else {//Si no existe la puja se crea
                usoPuja.insertar(puja);
            }
            subasta.setPrecioFinal(Float.parseFloat(request.getParameter("puja")));
            usoSubasta.actualizar(subasta);//Se actualiza la puja más alta
        }
        
       
        session.setAttribute("lista-subastas", usoSubasta.obtenerTipo(tipo));
        /*DEVUELVE TAMBIEN LOS DATOS DEL ARTICULO
        if (tipo.equalsIgnoreCase("Monedas")) {
            CRUDMoneda usoMoneda = new CRUDMoneda(conexion);
            session.setAttribute("lista-articulos", usoMoneda);
        } else if (tipo.equalsIgnoreCase("Billetes")) {
            CRUDBillete usoBillete = new CRUDBillete(conexion);
            session.setAttribute("lista-articulos", usoBillete);
        }*/
        response.sendRedirect("./VistaSubastasCliente.jsp");
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