
package com.subastas.controlador;

import com.subastas.modelo.Articulo;
import com.subastas.modelo.GestionBBDDLocalhost;
import com.subastas.patrones.factory.CRUDArticulo;
import com.subastas.patrones.builder.BuilderArte;
import com.subastas.patrones.builder.BuilderArticulo;
import com.subastas.patrones.builder.BuilderMobiliario;
import com.subastas.patrones.builder.BuilderNumismatica;
import com.subastas.patrones.builder.Director;
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
        String categoria = request.getParameter("categoria");
        CRUDArticulo gestionArticulos = new CRUDArticulo(conexion);
        Director director = new Director();
        BuilderArticulo bArticulo = null; 
        Articulo articulo;
        
        switch (categoria) {
            case "Mobiliario":
                bArticulo = new BuilderMobiliario();
                break;
            case "Arte":
                bArticulo = new BuilderArte();
                break;
            case "Numismatica":
                bArticulo = new BuilderNumismatica();
                break;
            default:
                break;
        }
        
        director.setBuilderArticulo(bArticulo);
        director.crearArticulo(
                Integer.parseInt(request.getParameter("id-articulo")),
                request.getParameter("nombre"),
                request.getParameter("descripcion"),
                Integer.parseInt(request.getParameter("anio")),
                request.getParameter("estado_conservacion"),
                Float.parseFloat(request.getParameter("precio")),
                request.getParameter("foto"),
                request.getParameter("dimensiones"),
                request.getParameter("autor"),
                request.getParameter("procedencia"));
        articulo = director.getArticulo();
        
        switch (accion) {
            case "insertar": {                           
                gestionArticulos.insertar(articulo);
                break;
            }
            case "actualizar": {
                gestionArticulos.actualizar(articulo);
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
