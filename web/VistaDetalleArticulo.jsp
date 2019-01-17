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
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>Jumbotron Template · Bootstrap</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <!-- Custom styles for this template <link href="jumbotron.css" rel="stylesheet">-->
        <link href="jumbotron.css" rel="stylesheet">
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
                        out.println("<p>Nombre " + articulo.getNombre() + " </p>");
                        out.println("<p>Descripcion " + articulo.getDescripcion() + " </p>");
                        out.println("<p>Año: " + articulo.getAnio() + " </p>");
                        out.println("<p>Estado de Conservación: " + articulo.getEstado_conservacion() + " </p>");
                        out.println("<p>Categoria: " + articulo.getCategoria() + " </p>");
                        out.println("<p>Foto: " + articulo.getFoto() + " </p>");
                        out.println("<p>Dimensiones: " + articulo.getDimensiones() + " </p>");
                        out.println("<p>Autor " + articulo.getAutor() + " </p>");
                        out.println("<p>Procendecia " + articulo.getProcedencia() + " </p>");
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
