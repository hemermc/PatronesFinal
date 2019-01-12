<%-- 
    Document   : VistaRegistroCliente
    Created on : 09-ene-2019, 12:28:40
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
        <link rel="stylesheet" href="./css/styles.css"/>
        <title>Numimástica UAH</title>
    </head>
    <body style="overflow-x:hidden; overflow-y:scroll;" >
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor">
            <div class="bloque-grid"> 
                    <form action="ControladorInicio" method="post" class ="formulario-inicio">
                        <h2>Nueva Cuenta</h2>
                        <input type="hidden" name="llamada" value="registro">
                        <input type="text" name="nombre_usuario"  placeholder="Nombre de usuario">
                        <input type="password" name="clave" placeholder="Contraseña">
                        <input type="email" name="email" placeholder="Correo electrónico">
                        <input type="text" name="nombre"placeholder="Nombre">
                        <input type="text" name="apellidos"  placeholder="Apellidos">
                        <input type="text" name="dni"  placeholder="DNI">
                        <input type="text" name="direccion_entrega" placeholder="Dirección">
                        <input type="number" name="telefono" placeholder="Teléfono">
                        <input type="submit" value="Registrar">
                    </form>	
               
            </div>
            
        </div>
        <div id="footer">
            <p id="links">
                <a href="#">Politica de privacidad</a>
                <a href="#">Terminos de uso</a>
            </p>
            <p>
                <a href="#">Inicio</a>
                <a href="#">Subastas</a>
                <a href="#">Productos subastados</a>
                <a href="#">Contactanos</a>
                <a href="#">acerca de nosotros</a>

            </p>
            <p>Copyright &copy; 2019 &minus; Subastas&amp;Antiguedades &middot; Diseñadores: Alexander y Juan Antonio</p>
        </div>
    </body>
</html>
