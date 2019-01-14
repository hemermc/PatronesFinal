
package com.subastas.controlador;

import com.subastas.commons.Constantes;
import com.subastas.modelo.Articulo;
import com.subastas.modelo.GestionBBDDLocalhost;
import com.subastas.modelo.Subasta;
import com.subastas.patrones.factory.CRUDArticulo;
import com.subastas.patrones.factory.CRUDSubasta;
import com.subastas.patrones.factory.CRUDFactory;
import com.subastas.patrones.factory.ICRUDGeneral;
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
 * @author Grupo_12
 */

@WebServlet(name = "ControladorAccesoSubasta", urlPatterns = {"/ControladorAccesoSubasta"})
public class ControladorAccesoSubasta extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
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
        GestionBBDDLocalhost gestionDB = GestionBBDDLocalhost.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        String categoria = request.getParameter(Constantes.CATEGORIA);
        CRUDFactory factory = new CRUDFactory();
        
        ICRUDGeneral general = factory.getCRUD(Constantes.CRUD_ARTICULO, conexion); 
        CRUDSubasta subastas = new CRUDSubasta(conexion);

        ArrayList<Subasta> listaSubastas = subastas.obtenerCategoria(categoria);
        ArrayList<Object> listaArticulos = new ArrayList();

        if (categoria.equals(Constantes.MOBILIARIO) || categoria.equals(Constantes.ARTE) || categoria.equals(Constantes.NUMISMATICA)) {
            for (Subasta subasta: listaSubastas){
               listaArticulos.add(general.obtenerEspecifico(String.valueOf(subasta.getId_articulo()))); 
            }
        }

        session.setAttribute("categoria-subasta", categoria);
        session.setAttribute("lista-subastas", listaSubastas);
        session.setAttribute("lista-articulos", listaArticulos);
        response.sendRedirect("./VistaSubastasCliente.jsp");
        
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

