<%-- 
    Document   :    VistaInicioSesion
    Author     :    Juan Antonio Moscoso Chacaltana
                    Alexander Munguia Clemente
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
        <title>Signin Template · Bootstrap</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="./css/signin.css"/>
    </head>
    <body class="text-center">
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <form action="ControladorInicio" method="post" class="form-signin">
            <img class="mb-4 logo" src="./res/signin2.png" alt="avatar">
            <h3 class="mb-3 font-weight-normal">Iniciar Sesión</h3>
            <input type="hidden" name="llamada" value="acceso">
            <label for="inputEmail" class="sr-only">Nombre de usuario</label>
            <input type="text" name="nombre_usuario" id="inputEmail" class="form-control" placeholder="Nombre de usuario" required autofocus>
            <label for="inputPassword" class="sr-only">Contraseña</label>
            <input type="password" name="clave" id="inputPassword" class="form-control" placeholder="Contraseña" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
        </form>
    </body>
</html>