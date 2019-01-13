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
                        Subasta subasta = (Subasta)session.getAttribute("subasta-detalle");
                        Articulo articulo = (Articulo)session.getAttribute("articulo-detalle");

                        out.println("<h1>Detalle de la subasta</h1>");
                        out.println("<div class=\"subasta-elemento\">");
                        out.println("<p>Nombre subasta: " + subasta.getNombre() + "</p>"
                                + "<p>Precio Actual: " + subasta.getPrecio_final()+ "</p>"
                                + "<p>Fecha Cierre: " + subasta.getFecha_cierre()+ "</p>");
                        out.println("<p>Nombre: " + articulo.getNombre()+ " </p>");
                        out.println("<p>Descripción: " + articulo.getDescripcion()+ " </p>");
                        out.println("<p>Año: " + articulo.getAnio()+ " </p>");
                        out.println("<p>Estado de conservación: " + articulo.getEstado_conservacion()+ " </p>");
                        out.println("<p>Foto: " + articulo.getFoto()+ " </p>");
                        
                        if(articulo.getCategoria().equalsIgnoreCase(Constantes.MOBILIARIO)){
                            out.println("<p>Dimensiones: " + articulo.getDimensiones()+ " </p>");
                        } else if(articulo.getCategoria().equalsIgnoreCase(Constantes.ARTE)){
                            out.println("<p>Autor: " + articulo.getAutor()+ " </p>");
                        } else if(articulo.getCategoria().equalsIgnoreCase(Constantes.NUMISMATICA)){                           
                            out.println("<p>Procedencia: " + articulo.getProcedencia()+ " </p>");
                        }
                        
                        out.println(" <form action=\"ControladorSubastas\" method=\"Post\" class=\"formulario\">"
                                + "<input type=\"hidden\" name=\"id-subasta\" value=\"" + subasta.getId_subasta() + "\" class=\"btn-input\">"
                                + "<input type=\"text\" name=\"puja\" class=\"btn-input\" placeholder=\"Precio\" required>"
                                + "<input type=\"submit\" value=\"Pujar\" class=\"btn-input\">"
                                + "</form>"
                                + "</div>");
                    %>  
                </div>
            </main>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
    </body>
</html>
