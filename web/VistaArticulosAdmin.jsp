<%-- 
    Document   : VistaBilletesAdmin
    Created on : 09-ene-2019, 12:18:18
    Author     : amunguia
--%>

<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.modelo.Articulo"%>
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
        <link href="jumbotron.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor-index">
            <h2>Gestión de artículos</h2>
            <div>
                <h3>Seleccione la categoría del artículo que desea gestionar:</h3>
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
            <div class="accion oculto" id="insertar">
                <h3>Añadir Artículo</h3>
                <form action="ControladorGestionArticulos" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="insertar" class="registro-input" required>
                    <input type="text" name="nombre" class="registro-input" placeholder="Nombre" required>
                    <input type="text" name="descripcion" class="registro-input" placeholder="Descripción" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="date" name="categoria" class="registro-input" placeholder="Categoria" required>
                    <input type="date" name="precio" class="registro-input" placeholder="Precio" required>
                    <select name="estado_conservacion" class="registro-input" required>
                        <option value="" selected disabled>Estado Conservación</option> 
                        <option value="*">Mal estado</option>
                        <option value="**">Buena conservación</option>
                        <option value="***">Muy buena conservación</option>
                        <option value="****">Excelente conservación</option>
                        <option value="*****">Sin uso</option>
                    </select>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="accion oculto" id="actualizar">
                <h3>Modificar Artículo</h3>
                <form action="ControladorGestionArticulos" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="actualizar" class="registro-input" required>
                    <input type="text" name="nombre" class="registro-input" placeholder="Nombre" required>
                    <input type="text" name="descripcion" class="registro-input" placeholder="Descripción" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="date" name="categoria" class="registro-input" placeholder="Categoria" required>
                    <input type="date" name="precio" class="registro-input" placeholder="Precio" required>
                    <select name="estado_conservacion" class="registro-input" required>
                        <option value="" selected disabled>Estado Conservación</option> 
                        <option value="*">Mal estado</option>
                        <option value="**">Buena conservación</option>
                        <option value="***">Muy buena conservación</option>
                        <option value="****">Excelente conservación</option>
                        <option value="*****">Sin uso</option>
                    </select>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="accion oculto" id="eliminar">
                <h3>Eliminar Artículo</h3>
                <form action="ControladorGestionArticulos" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="eliminar" class="registro-input">
                    <input type="text" name="id_articulo" class="registro-input" placeholder="Articulo" required>

                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div id ="content">
                <h3>Artículos registrados</h3>	
                <%
                    ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>) session.getAttribute("articulos");
                    out.println("<div class =\"bloque-grid\">");
                    if (listaArticulos != null) {
                        for (Articulo articulo : listaArticulos) {
                            out.println("<div class =\"bloque\">");
                            out.println("<div class=\"informacion-subasta\">");
                            out.println("<img src=\"./res/monedas.jpg\" alt=\"monedas\" width=\"150px\" height=\"100px\">");
                            out.println("</div>");
                            out.println("<div class=\"puja\">");
                            out.println("<p>Nombre " + articulo.getNombre() + " </p>");
                            out.println("<p>Descripcion " + articulo.getDescripcion() + " </p>");
                            out.println(" <form action=\"ControladorDetalleArticulo\" method=\"Post\" class=\"formulario\">"
                                    + "<input type=\"hidden\" name=\"id-articulo\" value=\"" + articulo.getId_articulo() + "\" class=\"btn-input\">"
                                    + "<input type=\"submit\" value=\"Detalle\" class=\"btn-input\">"
                                    + "</form>"
                                    + "</div>");
                        }
                    } else {
                        out.println("<h2>No hay artículos registrados</h2>");
                    }
                    out.println("</div>");
                %>
            </div>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
        <script src="./js/jquery-1.4.1.min.js" type="text/javascript"></script>
        <script src="./js/main.js" type="text/javascript"></script>
    </body>
</html>
