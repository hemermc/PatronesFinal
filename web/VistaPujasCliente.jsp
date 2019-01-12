<%-- 
    Document   : VistaPujasCliente
    Created on : 09-ene-2019, 12:28:25
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Puja"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.multimedia.modelo.Usuario"%>
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
                        ArrayList<Puja> listaPujasGanadas = (ArrayList) session.getAttribute("lista-pujas-ganadas");
                        ArrayList<Puja> listaPujasPerdidas = (ArrayList) session.getAttribute("lista-pujas-perdidas");
                        out.println("<h2>Pujas sobre subastas ganadas</h2>");
                        if (listaPujasGanadas != null) {//Si el cliente ha realizado pujas
                            out.println("<h3>Número de subastas sobre las que se ha pujado: " + listaPujasGanadas.size() + "</h3>");
                            for (int i = 0; i < listaPujasGanadas.size(); i++) {
                                out.println("<div class=\"subasta-elemento\">"
                                        + "<p>Id puja: " + listaPujasGanadas.get(i).getId_subasta() + "</p>"
                                        + "<p>Cantidad pujada: " + listaPujasGanadas.get(i).getCantidad() + "</p>"
                                        + "</div>");
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
                            for (int i = 0; i < listaPujasPerdidas.size(); i++) {
                                out.println("<div class=\"subasta-elemento\">"
                                        + "<p>Id puja: " + listaPujasPerdidas.get(i).getId_subasta() + "</p>"
                                        + "<p>Cantidad pujada: " + listaPujasPerdidas.get(i).getCantidad() + "</p>"
                                        + "</div>");
                            }
                        } else {
                            out.println("<h3>No has realizado ninguna puja</h3>");
                        }
                    %>
                </div>
            </main>
            <footer>
                <ul>
                    <li>&copy; 2019 patrones</li>
                </ul>
            </footer>
        </div>
    </body>
</html>
