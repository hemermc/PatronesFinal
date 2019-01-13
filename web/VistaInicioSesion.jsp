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
        <meta name="Página de subastas" content="">
        <meta name="Grupo12" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numismática UAH</title>
    </head>
    <body style="overflow-x:hidden; overflow-y:scroll;">
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor">
            <div class="grid-block">
               
                    <form action="ControladorInicio" method="post" class="formulario-inicio">
                        <h2 class="titulo2">Inicio de Sesión</h2>
                        <input type="hidden" name="llamada" value="acceso" >
                        <input type="text" name="nombre_usuario"  placeholder="Nombre de usuario">
                        <input type="password" name="clave" placeholder="Contraseña">
                        <input type="submit" value="Acceder">
                    </form>	
            </div> 
        </div>
        <jsp:include page="ComponenteFooter.jsp"/>
    </body>
</html>