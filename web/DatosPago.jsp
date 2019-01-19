<%-- 
    Document   :    DatosPago
    Author     :    Juan Antonio Moscoso Chacaltana
                    Alexander Munguia Clemente
--%>

<%@page import="com.subastas.modelo.Cliente"%>
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
            <div class="contenedor-registro">
                <div class="registro">  
                    <%
                        Cliente user = (Cliente) session.getAttribute("seguirregistro");
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
        <jsp:include page="ComponenteFooter.jsp"/>
    </body>
</html>