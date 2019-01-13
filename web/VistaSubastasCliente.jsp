<%-- 
    Document   : VistaSubastasCliente
    Created on : 09-ene-2019, 12:29:18
    Author     : amunguia
--%>

<%@page import="com.subastas.modelo.Articulo"%>
<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.modelo.Subasta"%>
<%@page import="com.subastas.commons.Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="Página de subastas - Práctica final Multimedia" content="">
        <meta name="Grupo11" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numismática UAH</title>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor-index">
            <main>
                <div class="contenedor-pujas">
                    <%
                        ArrayList<Subasta> listaSubastas = (ArrayList) session.getAttribute("lista-subastas");
                        String categoriaSubasta = (String) session.getAttribute("categoria-subasta");
                       
                        if (listaSubastas != null) {//Si hay subastas activas de ese tipo
                            out.println("<h1> Subastas de " + categoriaSubasta + "</h1>");
                            out.println("<h3>Número de subastas activas:" + listaSubastas.size() + "</h3>");
                            
                            for (int i = 0; i < listaSubastas.size(); i++) {
                                out.println("<div class=\"subasta-elemento\">");
                                out.println("<p>Nombre subasta: " + listaSubastas.get(i).getNombre() + "</p>"
                                        + "<p>Precio: " + listaSubastas.get(i).getPrecio_final()+ "</p>"
                                        + "<p>Fecha Cierre: " + listaSubastas.get(i).getFecha_cierre()+ "</p>");
                                out.println(" <form action=\"ControladorDetalleSubasta\" method=\"Post\" class=\"formulario\">"
                                        + "<input type=\"hidden\" name=\"id_subasta\" value=\"" + listaSubastas.get(i).getId_subasta() + "\" class=\"btn-input\">"                                       
                                        + "<input type=\"submit\" value=\"Detalle\" class=\"btn-input\">"
                                        + "</form>"
                                        + "</div>");
                            }
                        } else {
                            out.println("<h3>No existe subastas de este tipo");
                        }
                    %>  
                </div>
            </main>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
    </body>
</html>
