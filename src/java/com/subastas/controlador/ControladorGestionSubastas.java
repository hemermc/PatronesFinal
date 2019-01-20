
package com.subastas.controlador;

import com.subastas.modelo.GestionBBDD;
import com.subastas.modelo.Subasta;
import com.subastas.patrones.adapter.AdapterFechaESToUS;
import com.subastas.patrones.adapter.AdapterFechaUSToES;
import com.subastas.patrones.adapter.FechaES;
import com.subastas.patrones.adapter.FechaUS;
import com.subastas.patrones.factory.CRUDSubasta;
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
            GestionBBDD gestionDB = GestionBBDD.getInstance();
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
        GestionBBDD gestionDB = GestionBBDD.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        HttpSession session = request.getSession(true);
        String accion = request.getParameter("accion");

        CRUDSubasta usoSubasta = new CRUDSubasta(conexion);
        
        switch (accion) {
            case "insertar": {
            
                AdapterFechaESToUS adapterCierre = new AdapterFechaESToUS(new FechaES(request.getParameter("FechaCierre")));
                
                usoSubasta.insertar(new Subasta(
                        request.getParameter("Nombre"),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        Float.parseFloat(request.getParameter("PrecioFinal")),
                        adapterCierre.obtenerFechaString(),
                        request.getParameter("Estado"),
                        Integer.parseInt(request.getParameter("id_articulo"))));
                break;
            }
            case "actualizar": {
               
                AdapterFechaESToUS adapterCierre = new AdapterFechaESToUS(new FechaES(request.getParameter("FechaCierre")));
                
                usoSubasta.insertar(new Subasta(
                        request.getParameter("Nombre"),
                        Float.parseFloat(request.getParameter("PrecioInicial")),
                        Float.parseFloat(request.getParameter("PrecioFinal")),
                        adapterCierre.obtenerFechaString(),
                        request.getParameter("estado"),
                        Integer.parseInt(request.getParameter("Lote"))));
                break;
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
