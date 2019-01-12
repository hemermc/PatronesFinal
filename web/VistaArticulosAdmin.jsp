<%-- 
    Document   : VistaBilletesAdmin
    Created on : 09-ene-2019, 12:18:18
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<%@page import="com.multimedia.modelo.Articulo"%>
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
            <h1>Gestión de artículos</h1>
            <h2>Seleccione la categoría del artículo que desea gestionar:</h2>
            <select name="categoria" class="registro-input" required>
                <option value="" selected disabled>Categoría</option> 
                <option value="Arte">Arte</option>
                <option value="Mobiliario">Mobiliario</option>
                <option value="Numismatica">Numismática</option>
            </select>
            <div class="insertar">
                <h2>Añadir Artículo</h2>
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
            <div class="insertar">
                <h2>Modificar Artículo</h2>
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
            <div class="insertar">
                <h2>Eliminar Artículo</h2>
                <form action="ControladorGestionArticulos" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="eliminar" class="registro-input">
                    <input type="text" name="id_articulo" class="registro-input" placeholder="Articulo" required>

                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <h2>Artículos registrados</h2>	
            <div id ="contenedor-panel">
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
                        out.println("<h2>No hay billetes registrados</h2>");
                    }
                    out.println("</div>");
                %>
            </div>
            <footer>
                <ul>
                    <li>&copy; 2019 Patrones</li>
                </ul>
            </footer>
        </div>
    </body>
</html>
