<%-- 
    Document   : VistaPanelAdmin
    Created on : 09-ene-2019, 12:27:50
    Author     : amunguia
--%>

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
        <div class="contenedor-index">
            <jsp:include page="ComponenteHeaderNav.jsp"/>
            <div id ="contenedor-panel">
                <div class ="bloque" id ="gestion_Monedas">
                    <%
                        out.println("<a href =\"" + request.getContextPath() + "/ControladorGestionMonedas\"> Gestión Monedas</a>");
                    %>
                </div>
                <div class ="bloque" id ="gestion_Billetes"> 
                    <%
                        out.println("<a href =\"" + request.getContextPath() + "/ControladorGestionBilletes\"> Gestión Billetes</a>");
                    %>
                </div>
                <div class ="bloque" id ="gestion_Subastas">
                    <%
                        out.println("<a href =\"" + request.getContextPath() + "/ControladorGestionSubastas\"> Gestión Subastas</a>");
                    %>
                </div>
            </div>
            <footer>
                <ul>
                    <li>&copy; 2019 Patrones</li>
                </ul>
            </footer>
        </div>
    </body>
</html>
