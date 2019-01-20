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
                    <p><a href="VistaPrincipal.jsp" class="btn btn-primary my-2">Página  de Inicio</a></p>
                </div>
            </section>
            <div class="album py-5 bg-light">
                <%out.println("<h3>Subastas disponibles: <span class=\"badge badge-primary badge-pill\">" + listaSubastas.size() + "</span></h3>");%>
                <div class="container">
                    <form action="ControladorSubastas" method="post" class="formulario" id="myform">
                        <select onchange="this.form.submit()" name="estrategia">
                            <option value="">Elige filtro</option>
                            <option value="reciente">Mas Recientes</option>
                            <option value="caduca">Poco tiempo para cerrar</option>
                        </select>
                        
                    </form>
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
                                    <%out.println("<p class=\"card-text\">" + actual.getNombre()+ "</p>");%>
                                    <%out.println("<p class=\"card-text\">" + actual.getFecha_alta() + "</p>");%>
                                    <%out.println("<p class=\"card-text\">" + actual.getFecha_cierre() + "</p>");%>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">  
                                            <%out.println("<button class=\"btn btn-sm btn-secondary\" name=\"btnDetalle\" value=\"Submit\" onclick=\"setDetalleSubastaCliente('" + actual.datosSubasta() + "')\" data-toggle=\"modal\" data-target=\"#modalDetalle\">Detalle</button>");%>
                                            <%out.println("<button type=\"button\" class=\"btn btn-sm btn-success\" id=\"btnPuja\" onclick=\"setIdSubastaPuja('" + actual.getId_subasta() + "')\" data-toggle=\"modal\" data-target=\"#modalPuja\">Pujar</button>");%>                                 
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
                    <div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Detalle de la subasta</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card mb-4 shadow-sm">
                                        <img class="bd-placeholder-img card-img-top box-shadow" src="./res/billete.jpg" height="200">
                                        <div class="card-body" id="detalle-subasta">                                               
                                            <div class="d-flex justify-content-center align-items-center">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="modalPuja" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Confirmar</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Inserte la cantidad que desea pujar
                                    <div class="input-group">
                                        <form action="ControladorSubastas" method="post" id="form-puja">
                                            <%out.println("<input type=\"hidden\" name=\"categoria\" value=\"" + categoriaSubasta + "\">");%>
                                            <input type="number" class="form-control" name="puja" aria-label="Cantidad de la puja que se va a realizar">
                                            <div class="input-group-append">
                                                <span class="input-group-text">€</span>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success" onclick="document.getElementById('form-puja').submit()" data-dismiss="modal">Aceptar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="ComponenteFooter.jsp"/>
        <script src="./js/jquery-1.4.1.min.js" type="text/javascript"></script>
        <script src="./js/main.js" type="text/javascript"></script>
    </div>
</body>
</html>
