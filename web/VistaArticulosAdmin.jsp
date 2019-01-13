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
        <meta name="Página de subastas - Práctica final Multimedia" content="">
        <meta name="Grupo11" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>       
        <title>Numismática UAH</title>
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
                            out.println("<p>Nombre " + articulo.getNombre()+ " </p>");
                            out.println("<p>Descripcion " + articulo.getDescripcion()+ " </p>");
                            out.println(" <form action=\"ControladorDetalleArticulo\" method=\"Post\" class=\"formulario\">"
                                    + "<input type=\"hidden\" name=\"id-articulo\" value=\"" + articulo.getId_articulo()+ "\" class=\"btn-input\">"
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
