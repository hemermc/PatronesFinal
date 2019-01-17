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
            <div class="content">
                <div class="contenedor-centrado">
                    <%
                        Subasta subasta = (Subasta) session.getAttribute("subasta-detalle");
                        Articulo articulo = (Articulo) session.getAttribute("articulo-detalle");

                        out.println("<h2>Detalle de la subasta</h2>");
                        out.println("<div class=\"col col-detalle\">");
                        out.println("<p>Nombre subasta: " + subasta.getNombre() + "</p>"
                                + "<p>Precio Actual: " + subasta.getPrecio_final() + "</p>"
                                + "<p>Fecha Cierre: " + subasta.getFecha_cierre() + "</p>");
                        out.println("<p>Nombre: " + articulo.getNombre() + " </p>");
                        out.println("<p>Descripción: " + articulo.getDescripcion() + " </p>");
                        out.println("<p>Año: " + articulo.getAnio() + " </p>");
                        out.println("<p>Estado de conservación: " + articulo.getEstado_conservacion() + " </p>");
                        out.println("<p>Foto: " + articulo.getFoto() + " </p>");

                        if (articulo.getCategoria().equalsIgnoreCase(Constantes.MOBILIARIO)) {
                            out.println("<p>Dimensiones: " + articulo.getDimensiones() + " </p>");
                        } else if (articulo.getCategoria().equalsIgnoreCase(Constantes.ARTE)) {
                            out.println("<p>Autor: " + articulo.getAutor() + " </p>");
                        } else if (articulo.getCategoria().equalsIgnoreCase(Constantes.NUMISMATICA)) {
                            out.println("<p>Procedencia: " + articulo.getProcedencia() + " </p>");
                        }

                        out.println(" <form action=\"ControladorSubastas\" method=\"Post\" class=\"formulario\">"
                                + "<input type=\"hidden\" name=\"id-subasta\" value=\"" + subasta.getId_subasta() + "\" class=\"btn-input\">"
                                + "<input type=\"text\" name=\"puja\" class=\"btn-input\" placeholder=\"Precio\" required>"
                                + "<input type=\"submit\" value=\"Pujar\" class=\"btn-input\">"
                                + "</form>"
                                + "</div>");
                    %>  
                </div>
            </div>
        </div>
        <jsp:include page="ComponenteFooter.jsp"/>
    </body>
</html>
