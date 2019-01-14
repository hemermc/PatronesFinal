
package com.subastas.controlador;

import com.subastas.modelo.Articulo;
import com.subastas.modelo.GestionBBDDLocalhost;
import com.subastas.modelo.Subasta;
import com.subastas.patrones.factory.CRUDArticulo;
import com.subastas.patrones.factory.CRUDSubasta;
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
 * @author Grupo_12
 */
@WebServlet(name = "ControladorDetalleSubasta", urlPatterns = {"/ControladorDetalleSubasta"})
public class ControladorDetalleSubasta extends HttpServlet{
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
        String id_subasta = request.getParameter("id_subasta");
        
        CRUDSubasta gestionSubasta = new CRUDSubasta(conexion);
        Subasta subasta = gestionSubasta.obtenerEspecifico(id_subasta);
        
        CRUDArticulo gestionArticulo = new CRUDArticulo(conexion);
        Articulo articulo = gestionArticulo.obtenerEspecifico(subasta.getId_articulo().toString());

        session.setAttribute("subasta-detalle", subasta);
        session.setAttribute("articulo-detalle", articulo);
        response.sendRedirect("VistaDetalleSubasta.jsp");
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
