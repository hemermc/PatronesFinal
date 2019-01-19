
package com.subastas.controlador;

import com.subastas.modelo.*;
import com.subastas.patrones.factory.*;
import com.subastas.patrones.observer.*;
import com.subastas.patrones.proxy.ProxyProteccion;
import com.subastas.patrones.strategy.*;
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
        GestionBBDD gestionDB = GestionBBDD.getInstance();
        Connection conexion = gestionDB.establecerConexion();
        HttpSession session = request.getSession(true);
        Usuario user = (Usuario) session.getAttribute("usuario");
        ProxyProteccion proxy = new ProxyProteccion();
        if(request.getParameter("estrategia") != null){
            filtrar(request, response);
        }else{
            if (proxy.permitirAcceso(session)) {//Existe un usuario logueado
                CRUDSubasta usoSubasta = new CRUDSubasta(conexion);
                CRUDCliente usoCli = new CRUDCliente(conexion);
                String idsubasta = request.getParameter("id-subasta");
                Subasta subasta = usoSubasta.obtenerEspecifico(idsubasta);
                String categoria = request.getParameter("categoria");

                if (Float.parseFloat(request.getParameter("puja")) > subasta.getPrecio_final()) {
                    CRUDPujas usoPuja = new CRUDPujas(conexion);
                    Puja puja = new Puja(
                            Integer.parseInt(request.getParameter("id-subasta")),
                            user.getNombre_usuario(),
                            Float.parseFloat(request.getParameter("puja")));
                    Puja pujaAntigua = usoPuja.obtenerEspecifico(idsubasta, user.getNombre_usuario());
                    if (pujaAntigua != null) {//Si exite la puja la actualiza
                        Sujeto s = new Sujeto();
                    s.setPuja(pujaAntigua);
                    Cliente antiguo = usoCli.obtenerEspecifico(pujaAntigua.getNombre_usuario());
                    Observador o = new Observador("obs1",puja, antiguo,s);
                    s.notificarObservadores();

                        usoPuja.actualizar(puja);
                    } else {//Si no existe la puja se crea
                        usoPuja.insertar(puja);
                    }
                    subasta.setPrecio_final(Float.parseFloat(request.getParameter("puja")));
                    usoSubasta.actualizar(subasta);//Se actualiza la puja más alta
                    ArrayList<Subasta> listaSubastas = usoSubasta.obtenerCategoria(categoria);

                    session.setAttribute("lista-subastas", listaSubastas);
                    //request.getRequestDispatcher("/VistaSubastasCliente.jsp").forward(request, response);
                    response.sendRedirect("./VistaSubastasCliente.jsp");
                }
            }else {//Si el cliente no ha iniciado sesión
                response.sendRedirect("./VistaInicioSesion.jsp");
            }
        }
        
       
    }
   
     public void filtrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        ArrayList<Subasta> listaSubastas =(ArrayList) session.getAttribute("lista-subastas");
      
        String accion = request.getParameter("estrategia");
         switch (accion) {
            case "reciente": {
                 Estrategia est = new EstrategiaConcretaReciente();
                //El contexto
                Contexto contexto = new Contexto(est, listaSubastas);
                contexto.ejecutaEstrategia();
                break;
            }
            case "caduca": {
                Estrategia est = new EstrategiaConcretaFinalizar();
                //El contexto
                Contexto contexto = new Contexto(est, listaSubastas);
                contexto.ejecutaEstrategia();

                break;
            }

        }

        request.getRequestDispatcher("/VistaSubastasCliente.jsp").forward(request, response);
                
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
