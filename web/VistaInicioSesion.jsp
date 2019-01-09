<%-- 
    Document   : VistaInicioSesion
    Created on : 09-ene-2019, 12:21:20
    Author     : amunguia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
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
            <div class="contenedor-acceso">
                <div class="acceso">
                    <form action="ControladorInicio" method="post" class="formulario">
                        <h1>Inicio de Sesión</h1>
                        <input type="hidden" name="llamada" value="acceso" class="registro-input">
                        <input type="text" name="nombre_usuario" class="registro-input" placeholder="Nombre de usuario">
                        <input type="password" name="clave" class="registro-input" placeholder="Contraseña">
                        <input type="submit" value="Acceder" class="btn-input">
                    </form>	
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
