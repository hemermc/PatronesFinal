<%-- 
    Document   : VistaSubastasCliente
    Created on : 09-ene-2019, 12:29:18
    Author     : amunguia
--%>

<%@page import="com.subastas.patrones.iterator.*"%>
<%@page import="com.subastas.modelo.Articulo"%>
<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.modelo.Subasta"%>
<%@page import="com.subastas.commons.Constantes"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="./css/jumbotron.css"/>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <%
            ArrayList<Subasta> listaSubastas = (ArrayList) session.getAttribute("lista-subastas");
            String categoriaSubasta = (String) session.getAttribute("categoria-subasta");%>
        <main role="main">
            <section class="jumbotron text-center">
                <div class="container">
                    <%out.println("<h1 class=\"jumbotron-heading\"> Subastas de " + categoriaSubasta + "</h1>");%>
                    <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
                    <p><a href="#" class="btn btn-primary my-2">Página  de Inicio</a></p>
                </div>
            </section>
            <div class="album py-5 bg-light">
                <div class="container">
                    <div class="row">
                        <%
                            if (listaSubastas != null) {//Si hay subastas activas de ese tipo
                                Agregado agregado = new AgregadoConcreto(listaSubastas);
                                Iterador ite = agregado.crearIterador();
                                while (ite.hayMas()) {
                                    Subasta actual = (Subasta) ite.elementoActual();
                        %>
                        <div class="col-md-4">
                            <div class="card mb-4 shadow-sm">
                                <img class="bd-placeholder-img card-img-top box-shadow" src="./res/billete.jpg" height="200">
                                <div class="card-body">
                                    <%out.println("<p class=\"card-text\">" + actual.getNombre() + "</p>");%>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <form action="ControladorDetalleSubasta" method="post" class="formulario" id="myform">
                                                <%out.println("<input type=\"hidden\" name=\"id_subasta\" value=\"" + actual.getId_subasta() + "\" class=\"btn-input\">");%>
                                                <button type="button" class="btn btn-sm btn-secondary" onclick="document.getElementById('myform').submit()">Detalles</button>
                                                <button type="button" class="btn btn-sm btn-success" onclick="document.getElementById('myform').submit()">Pujar</button>
                                            </form>
                                        </div>
                                        <div class="alert alert-info" role="alert">
                                            <%out.println("<strong>" + actual.getPrecio_final() + " &euro;</strong>");%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%ite.siguiente();
                                }
                            } else {
                                out.println("<h3>No existe subastas de este tipo");
                            }
                        %>  
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="ComponenteFooter.jsp"/>
    </div>
</body>
</html>
