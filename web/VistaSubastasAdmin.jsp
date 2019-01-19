<%-- 
    Document   : VistaSubastasAdmin
    Created on : 09-ene-2019, 12:29:05
    Author     : amunguia
--%>

<%@page import="java.util.HashMap"%>
<%@page import="com.subastas.patrones.iterator.*"%>
<%@page import="com.subastas.modelo.Subasta"%>
<%@page import="java.util.ArrayList"%>
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
        <!-- Custom styles for this template <link href="jumbotron.css" rel="stylesheet">-->
        <link rel="stylesheet" href="./css/jumbotron.css"/>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <main role="main">
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-5">Gestión de subastas</h1>
                    <p>Sabemos que necesitas algo más, el servicio atento de la compañia, conócenos</p>
                </div>
            </div>
            <div>
                <h3>Seleccione la categoría de la subasta que desea gestionar:</h3>
                <select name="categoria" class="registro-input" required>
                    <option value="" selected disabled>Categoría</option> 
                    <option value="Arte">Arte</option>
                    <option value="Mobiliario">Mobiliario</option>
                    <option value="Numismatica">Numismática</option>
                </select>
            </div>
            <div>
                <h3>Seleccione la acción que desea gestionar:</h3>
                <select name="accion" id="selector-accion" class="registro-input" required>
                    <option value="" selected disabled>Acción</option> 
                    <option value="insertar">Insertar</option>
                    <option value="actualizar">Actualizar</option>
                    <option value="eliminar">Eliminar</option>
                </select>
            </div>
            <div class="contenedor-index">
                <div class="accion oculto" id="insertar">
                    <h3>Añadir Subasta</h3>
                    <form action="ControladorGestionSubastas" method="post" class ="formulario">
                        <input type="text" name="Lote" class="registro-input" placeholder="Lote" required>
                        <input type="text" name="Nombre" class="registro-input" placeholder="Nombre" required>
                        <input type="text" name="PrecioInicial" class="registro-input" placeholder="Precio Inicial" required>
                        <input type="date" name="Fecha" class="registro-input" placeholder="Fecha" required>
                        <input type="submit" value="Insertar" class="btn-input">
                    </form>
                </div>
                <div class="accion oculto" id="actualizar">
                    <h3>Modificar Subasta</h3>
                    <form action="ControladorGestionSubastas" method="post" class ="formulario">
                        <input type="text" name="Lote" class="registro-input" placeholder="Lote" required>
                        <input type="text" name="Nombre" class="registro-input" placeholder="Nombre" required>
                        <input type="text" name="PrecioInicial" class="registro-input" placeholder="Precio Inicial" required>
                        <input type="date" name="Fecha" class="registro-input" placeholder="Fecha" required>
                        <input type="submit" value="Actualizar" class="btn-input">
                    </form>
                </div>
                <div class="accion oculto" id="eliminar">
                    <h3>Eliminar Subasta</h3>
                    <form action="ControladorGestionSubastas" method="post" class ="formulario">
                        <input type="hidden" name="accion" value="eliminar" class="registro-input">
                        <input type="text" name="id_subasta" class="registro-input" placeholder="id subasta" required>
                        <input type="submit" value="Eliminar" class="btn-input">
                    </form>
                </div>
                <%
                    ArrayList<Subasta> listaSubastas = (ArrayList) session.getAttribute("subastas");
                %>
                <div class="album py-5 bg-light">
                    <%out.println("<h3>Subastas registradas: <span class=\"badge badge-primary badge-pill\">" + listaSubastas.size() + "</span></h3>");%>
                    <div class="container">
                        <div class="row scroll">
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
                                        <div class="alert alert-danger estado-align" role="alert">
                                            <%out.println("<strong>" + actual.getEstado() + "</strong>");%>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">  
                                                <%out.println("<button class=\"btn btn-sm btn-secondary\" value=\"Submit\" onclick=\"setDetalleSubastaAdmin('" + actual.datosSubasta() + "')\" data-toggle=\"modal\" data-target=\"#modalDetalle\">Detalle</button>");%>
                                                <button type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#modalEstado">Estado</button>                                      
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
                        <!-- MODAL DE VISTA DETALLE DE LA SUBASTA -->
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
                                            <div class="card-body">                                               
                                                <div class="d-flex justify-content-center align-items-center" id="detalle-subasta-admin">
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
                        <!-- MODAL DE VISTA ESTADO DE LA SUBASTA -->
                        <div class="modal fade" id="modalEstado" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Confirmar</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ¿Desea confirmar el cambio de estado?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <button type="button" class="btn btn-success" data-dismiss="modal">Aceptar</button>
                                    </div>
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
    </body>
</html>
