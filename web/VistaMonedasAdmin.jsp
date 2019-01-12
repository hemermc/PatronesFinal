<%-- 
    Document   : VistaMonedasAdmin
    Created on : 09-ene-2019, 12:27:11
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<%@page import="com.multimedia.modelo.Moneda"%>
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
            <h1>Gestión de monedas</h1>
            <div class="insertar">
                <h2>Añadir</h2>
                <form action="ControladorGestionMonedas" method="post" class ='formulario'>
                    <input type="hidden" name="tipo" value="moneda" class="registro-input">
                    <input type="hidden" name="accion" value="insertar" class="registro-input">
                    <input type="text" name="valor" class="registro-input" placeholder="Valor" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="text" name="lugar_emision" class="registro-input" placeholder="Lugar Emisión" required>
                    <input type="text" name="conservacion" class="registro-input" placeholder="Conservación" required>
                    <input type="text" name="precio" class="registro-input" placeholder="Precio" required>
                    <input type="text" name="estrellas" class="registro-input" placeholder="Estrellas" required>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <!--<input type="file" name="foto" class="registro-input" placeholder="Foto" required>-->
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Modificar</h2>
                <form action="ControladorGestionMonedas" method="post" class ='formulario'>
                    <input type="hidden" name="tipo" value="moneda" class="registro-input">
                    <input type="hidden" name="accion" value="modificar" class="registro-input">
                    <input type="text" name="valor" class="registro-input" placeholder="Valor" required>
                    <input type="text" name="anio" class="registro-input" placeholder="Año" required>
                    <input type="text" name="lugar_emision" class="registro-input" placeholder="Lugar Emisión" required>
                    <input type="text" name="conservacion" class="registro-input" placeholder="Conservación" required>
                    <input type="text" name="precio" class="registro-input" placeholder="Precio" required>
                    <input type="text" name="estrellas" class="registro-input" placeholder="Estrellas" required>
                    <input type="text" name="foto" class="registro-input" placeholder="Foto" required>
                    <!--<input type="file" name="foto" class="registro-input" placeholder="Foto" required>-->
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Eliminar Moneda</h2>
                <form action="ControladorGestionMonedas" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="eliminar" class="registro-input">
                    <input type="text" name="lote" class="registro-input" placeholder="lote" required>
                    
                    <input type="submit" value="Eliminar" class="btn-input">
                </form>
            </div>
            <h2>Monedas registradas</h2>
            <div id ="contenedor-panel">
                <%
                    ArrayList<Moneda> monedas = null;
                    monedas = (ArrayList<Moneda>) session.getAttribute("monedas");
                    out.println("<div class =\"bloque-grid\">");
                    if (monedas != null) {
                        for (Moneda moneda : monedas) {
                            out.println("<div class =\"bloque\">");
                            out.println("<div class=\"informacion-subasta\">");
                            out.println("<img src=\"./res/monedas.jpg\" alt=\"monedas\" width=\"150px\" height=\"100px\">");
                            out.println("</div>");
                            out.println("<div class=\"puja\">");
                            out.println("<p>Lote: " + moneda.getLote() + " </p>");
                            out.println("<p>Conservación: " + moneda.getConservacion() + " </p>");
                            out.println("<p>Valor: " + moneda.getValor() + " </p>");
                            out.println("<p>Emisión: " + moneda.getLugar_emision() + " </p>");
                            out.println("<p>Año: " + moneda.getAnio() + " </p>");
                            out.println("</div>");
                            out.println("</div>");
                        }
                    } else {
                        out.println("<h2>No hay monedas registradas</h2>");
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
