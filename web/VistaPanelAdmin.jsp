<%-- 
    Author: Grupo_12
--%>

<%@page import="com.subastas.modelo.Usuario"%>
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
            <div id ="contenedor-panel">
                <div class ="bloque" id ="gestion_articulos">
                    <%out.println("<a href =\"" + request.getContextPath() + "/ControladorGestionArticulos\"> Gestión Artículos</a>");%>
                </div>
                <div class ="bloque" id ="gestion_Subastas">
                    <%out.println("<a href =\"" + request.getContextPath() + "/ControladorGestionSubastas\"> Gestión Subastas</a>");%>
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
