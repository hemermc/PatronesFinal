<%-- 
    Document   :    VistaPanelAdmin
    Author     :    Juan Antonio Moscoso Chacaltana
                    Alexander Munguia Clemente
--%>

<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.commons.*"%>
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
        <!-- Custom styles for this template <link href="jumbotron.css" rel="stylesheet">-->
        <link rel="stylesheet" href="./css/jumbotron.css"/>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <main role="main">
            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-5">Somos una empresa seria de subastas y antiguedades</h1>
                    <p>Sabemos que necesitas algo más, el servicio atento de la compañia, conócenos</p>
                </div>
            </div>
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-4">
                        <img class="logo-section" src="./res/mobiliario.jpg">
                        <h2>Gestión Artículos</h2>
                        <%out.println("<p>Acceso al panel de administración de artículos</p>");%>
                        <form action="ControladorGestionArticulos" method="get" id="form-articulos">
                            <p><a class="btn btn-success" href="#" onclick="document.getElementById('form-articulos').submit()" role="button">Acceder&raquo;</a></p>
                        </form>
                    </div>
                    <div class="col-md-4">
                        <img class="logo-section" src="./res/arte.jpeg">
                        <h2>Gestión Subastas</h2>
                        <%out.println("<p>Acceso al panel de gestión de subastas</p>");%>
                        <form action="ControladorGestionSubastas" method="get" id="form-subastas">
                            <p><a class="btn btn-success" href="#" onclick="document.getElementById('form-subastas').submit()" role="button">Acceder&raquo;</a></p>
                        </form>
                    </div>
                </div>
                <hr>
            </div> <!-- /container -->
        </main>
        <jsp:include page="ComponenteFooter.jsp"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="/docs/4.2/assets/js/vendor/jquery-slim.min.js"><\/script>');</script>
    </body>
</html>
