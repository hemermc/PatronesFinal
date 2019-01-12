<%-- 
    Document   : DatosPago
    Created on : 09-ene-2019, 9:45:15
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Cliente"%>
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
               <div class="contenedor-registro">
                <div class="registro">  
                    <%  
                        Cliente user = (Cliente )session.getAttribute("seguirregistro");
                        %>
                    <form action="ControladorDatosPago" method="post" class ='formulario'>
                        <h1>Tarjeta</h1>
                        <input type="hidden" name="tipo" value="tarjeta" class="registro-input">
                        <input type="text" name="numero_tarjeta" class="registro-input" placeholder="Numero Tarjeta">
                        <%out.println("<input type=\"hidden\" name=\"nombre_usuario\" value=\"" + user.getNombre_usuario() + "\"tarjeta\" class=\"registro-input\">");%>
                        <input type="text" name="tipo" class="registro-input" placeholder="Tipo">
                        <input type="text" name="titular" class="registro-input" placeholder="Titular">
                        <input type="text" name="mes" class="registro-input" placeholder="Mes">
                        <input type="text" name="ano" class="registro-input" placeholder="Año">
                        <input type="submit" value="Registrar" class="btn-input">
                    </form>	
                </div> 
            </div>
            </div>
             <footer>
                <ul>
                    <li>&copy; 2018 <span>Grupo11</span> Arquitectura y Diseño de Sistemas Web y C/S</li>
                </ul>
            </footer>
    </body>
</html>