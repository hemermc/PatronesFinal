
package com.subastas.controlador;

import com.subastas.commons.Constantes;
import com.subastas.modelo.Articulo;
import com.subastas.modelo.GestionBBDDLocalhost;
import com.subastas.patrones.factory.CRUDFactory;
import com.subastas.patrones.factory.ICRUDGeneral;
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
@WebServlet(name = "ControladorDetalleArticulo", urlPatterns = {"/ControladorDetalleArticulo"})
public class ControladorDetalleArticulo extends HttpServlet{
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
        String id_articulo = request.getParameter("id-articulo");
        CRUDFactory factory = new CRUDFactory();
        
        ICRUDGeneral general = factory.getCRUD(Constantes.CRUD_ARTICULO, conexion); 
        Articulo articulo = (Articulo) general.obtenerEspecifico(id_articulo);

        session.setAttribute("articulo-detalle", articulo);
        response.sendRedirect("VistaDetalleArticulo.jsp");
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
