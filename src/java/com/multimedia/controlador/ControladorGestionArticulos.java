
package com.multimedia.controlador;

import com.multimedia.modelo.Articulo;
import com.multimedia.modelo.GestionBBDDLocalhost;
import com.multimedia.modelo.crud.CRUDArticulo;
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
 * @author Grupo_12
 */
@WebServlet(name = "ControladorGestionArticulos", urlPatterns = {"/ControladorGestionArticulos"})
public class ControladorGestionArticulos extends HttpServlet {


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
        CRUDArticulo usoBilletes = new CRUDArticulo(conexion);
        session.setAttribute("articulos", usoBilletes.obtenerTodos());
        response.sendRedirect("VistaArticulosAdmin.jsp");
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
        CRUDArticulo gestionArticulos = new CRUDArticulo(conexion);

        switch (accion) {
            case "insertar": {
                gestionArticulos.insertar(new Articulo(
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("estado_conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto"),
                        request.getParameter("categoria")));
                break;
            }
            case "actualizar": {
                gestionArticulos.actualizar(new Articulo(
                        Integer.parseInt(request.getParameter("id_articulo")),
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        Integer.parseInt(request.getParameter("anio")),
                        request.getParameter("estado_conservacion"),
                        Float.parseFloat(request.getParameter("precio")),
                        request.getParameter("foto"),
                        request.getParameter("categoria")));
                break;
            }
            case "eliminar":{
                gestionArticulos.eliminar(request.getParameter("id_articulo"));
                break;
            }
        }
        ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>)gestionArticulos.obtenerTodos();
        session.setAttribute("articulos", listaArticulos);
        response.sendRedirect("VistaArticulosAdmin.jsp");
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
