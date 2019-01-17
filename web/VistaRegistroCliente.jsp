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
        <jsp:include page="ComponenteFooter.jsp"/>
    </body>
</html>