<%-- 
    Document   : VistaBilletesAdmin
    Created on : 09-ene-2019, 12:18:18
    Author     : amunguia
--%>

<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="Página de subastas" content="">
        <meta name="Grupo12" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numismática UAH</title>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor-index">
            <h1>Gestión de artículos</h1>
            <h2>Artículos registrados</h2>	
            <div id ="contenedor-panel">
                <%
                    Articulo articulo = (Articulo) session.getAttribute("articulo-detalle");
                    out.println("<div class =\"bloque-grid\">");
                    if (articulo != null) {
                        out.println("<div class =\"bloque\">");
                        out.println("<div class=\"informacion-subasta\">");
                        out.println("<img src=\"./res/monedas.jpg\" alt=\"monedas\" width=\"150px\" height=\"100px\">");
                        out.println("</div>");
                        out.println("<div class=\"puja\">");
                        out.println("<p>Nombre " + articulo.getNombre()+ " </p>");
                        out.println("<p>Descripcion " + articulo.getDescripcion()+ " </p>");
                        out.println("<p>Año: " + articulo.getAnio()+ " </p>");
                        out.println("<p>Estado de Conservación: " + articulo.getEstado_conservacion()+ " </p>");
                        out.println("<p>Categoria: " + articulo.getCategoria()+ " </p>");
                        out.println("<p>Foto: " + articulo.getFoto()+ " </p>");
                        out.println("<p>Dimensiones: " + articulo.getDimensiones()+ " </p>");
                        out.println("<p>Autor " + articulo.getAutor()+ " </p>");
                        out.println("<p>Procendecia " + articulo.getProcedencia()+ " </p>");
                        out.println("</div>");
                        out.println("</div>");
                    }
                    out.println("</div>");
                %>
            </div>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
    </body>
</html>
