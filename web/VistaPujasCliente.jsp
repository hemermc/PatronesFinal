<%-- 
    Document   : VistaPujasCliente
    Created on : 09-ene-2019, 12:28:25
    Author     : amunguia
--%>

<%@page import="com.subastas.patrones.iterator.*"%>
<%@page import="com.subastas.modelo.Puja"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.subastas.modelo.Usuario"%>
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
            <main>
                <div class="contenedor-pujas">
                    <%
                        ArrayList<Puja> listaPujasGanadas = (ArrayList) session.getAttribute("lista-pujas-ganadas");
                        ArrayList<Puja> listaPujasPerdidas = (ArrayList) session.getAttribute("lista-pujas-perdidas");
                        out.println("<h2>Pujas sobre subastas ganadas</h2>");
                        if (listaPujasGanadas != null) {//Si el cliente ha realizado pujas
                            out.println("<h3>Número de subastas sobre las que se ha pujado: " + listaPujasGanadas.size() + "</h3>");
                            Agregado agregado = new AgregadoConcreto(listaPujasGanadas);
                            Iterador ite = agregado.crearIterador();
                            while (ite.hayMas()) {
                                Puja actual = (Puja) ite.elementoActual();
                                out.println("<div class=\"subasta-elemento\">"
                                        + "<p>Id puja: " + actual.getId_subasta() + "</p>"
                                        + "<p>Cantidad pujada: " + actual.getCantidad() + "</p>"
                                        + "</div>");
                                ite.siguiente();
                            }
                        } else {
                            out.println("<h3>No has ganado ninguna subasta</h3>");
                        }
                    %> 
                    <br>
                    <br>
                    <%
                        out.println("<h2>Pujas sobre subastas no ganadas</h2>");
                        if (listaPujasPerdidas != null) {//Si el cliente ha realizado pujas
                            out.println("<h3>Número de subastas sobre las que se ha pujado: " + listaPujasPerdidas.size() + "</h3>");
                            Agregado agregado = new AgregadoConcreto(listaPujasPerdidas);
                            Iterador ite = agregado.crearIterador();
                            while (ite.hayMas()) {
                                Puja actual = (Puja) ite.elementoActual();
                                out.println("<div class=\"subasta-elemento\">"
                                        + "<p>Id puja: " + actual.getId_subasta() + "</p>"
                                        + "<p>Cantidad pujada: " + actual.getCantidad() + "</p>"
                                        + "</div>");
                                ite.siguiente();
                            }
                        } else {
                            out.println("<h3>No has realizado ninguna puja</h3>");
                        }
                    %>
                </div>
            </main>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
    </body>
</html>
