<%-- 
    Document   : VistaBilletesAdmin
    Created on : 09-ene-2019, 12:18:18
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<%@page import="com.multimedia.modelo.Billete"%>
<%@page import="com.multimedia.modelo.Billete"%>
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
        <div class="contenedor-index">
            <jsp:include page="ComponenteHeaderNav.jsp"/>
            <h1>Gestión de billetes</h1>
            <div class="insertar">
                <h2>Añadir Billete</h2>
                <form action="ControladorGestionBilletes" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="insertar" class="registro-input" required>
                    <input type="text" name="valor" class="registro-input" placeholder="Valor" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="text" name="lugar_emision" class="registro-input" placeholder="Lugar Emisión" required>
                    <input type="date" name="fecha" class="registro-input" placeholder="Fecha" required>
                    <input type="text" name="serie" class="registro-input" placeholder="Serie" required>
                    <select name="conservacion" class="registro-input" required>
                        <option value="" selected disabled>Estado Conservación</option> 
                        <option value="BC">Buena conservación</option>
                        <option value="MBC">Muy buena conservación</option>
                        <option value="EBC">Excelente buena conservación</option>
                        <option value="SC">Sin circular</option>
                    </select>
                    <input type="text" name="precio" class="registro-input" placeholder="Precio" required>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Modificar Billete</h2>
                <form action="ControladorGestionBilletes" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="actualizar" class="registro-input" required>
                    <input type="text" name="valor" class="registro-input" placeholder="Valor" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="text" name="lugar_emision" class="registro-input" placeholder="Lugar Emisión" required>
                    <input type="date" name="fecha" class="registro-input" placeholder="Fecha" required>
                    <input type="text" name="serie" class="registro-input" placeholder="Serie" required>
                    <select name="conservacion" class="registro-input" required>
                        <option value="" selected disabled>Estado Conservación</option> 
                        <option value="BC">Buena conservación</option>
                        <option value="MBC">Muy buena conservación</option>
                        <option value="EBC">Excelente buena conservación</option>
                        <option value="SC">Sin circular</option>
                    </select>
                    <input type="text" name="precio" class="registro-input" placeholder="Precio" required>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Eliminar Billete</h2>
                <form action="ControladorGestionBilletes" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="eliminar" class="registro-input">
                    <input type="text" name="lote" class="registro-input" placeholder="lote" required>

                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <h2>Billetes registrados</h2>	
            <div id ="contenedor-panel">
                <%
                    ArrayList<Billete> billetes = (ArrayList<Billete>) session.getAttribute("billetes");
                    out.println("<div class =\"bloque-grid\">");
                    if (billetes != null) {
                        for (Billete billete : billetes) {
                            out.println("<div class =\"bloque\">");
                            out.println("<div class=\"informacion-subasta\">");
                            out.println("<img src=\"./res/monedas.jpg\" alt=\"monedas\" width=\"150px\" height=\"100px\">");
                            out.println("</div>");
                            out.println("<div class=\"puja\">");
                            out.println("<p>Lote: " + billete.getLote() + " </p>");
                            out.println("<p>Conservación: " + billete.getConservacion() + " </p>");
                            out.println("<p>Valor: " + billete.getValor() + " </p>");
                            out.println("<p>Emisión: " + billete.getLugar_emision() + " </p>");
                            out.println("<p>Año: " + billete.getAnio() + " </p>");
                            out.println("</div>");
                            out.println("</div>");
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
