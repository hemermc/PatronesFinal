<%-- 
    Document   : VistaSubastasAdmin
    Created on : 09-ene-2019, 12:29:05
    Author     : amunguia
--%>

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
        <meta name="Página de subastas - Práctica final Multimedia" content="">
        <meta name="Grupo11" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numismática UAH</title>
    </head>
    <body>
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor-index">
            <h1>Gestión de subastas</h1>
            <div class="insertar">
                <h2>Añadir Subasta</h2>
                <form action="ControladorGestionSubastas" method="post" class ='formulario'>
                    <input type="text" name="Lote" class="registro-input" placeholder="Lote" required>
                    <input type="text" name="Nombre" class="registro-input" placeholder="Nombre" required>
                    <input type="text" name="PrecioInicial" class="registro-input" placeholder="Precio Inicial" required>
                    <input type="date" name="Fecha" class="registro-input" placeholder="Fecha" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Modificar Subasta</h2>
                <form action="ControladorGestionSubastas" method="post" class ='formulario'>
                    <input type="text" name="Lote" class="registro-input" placeholder="Lote" required>
                    <input type="text" name="Nombre" class="registro-input" placeholder="Nombre" required>
                    <input type="text" name="PrecioInicial" class="registro-input" placeholder="Precio Inicial" required>
                    <input type="date" name="Fecha" class="registro-input" placeholder="Fecha" required>
                    <input type="submit" value="Registrar" class="btn-input">
                </form>
            </div>
            <div class="insertar">
                <h2>Eliminar Subasta</h2>
                <form action="ControladorGestionSubastas" method="post" class ='formulario'>
                    <input type="hidden" name="accion" value="eliminar" class="registro-input">
                    <input type="text" name="id_subasta" class="registro-input" placeholder="id subasta" required>
                    
                    <input type="submit" value="Eliminar" class="btn-input">
                </form>
            </div>
            <h2>Subastas registradas</h2>
            <div id ="contenedor-panel">
                <%
                    ArrayList<Subasta> subastas = (ArrayList) session.getAttribute("subastas");
                    out.println("<div class =\"bloque-grid\">");
                    if (subastas != null) {
                        Agregado agregado = new AgregadoConcreto(subastas);
                        Iterador ite = agregado.crearIterador();
                        while(ite.hayMas()){
                            Subasta actual = (Subasta)ite.elementoActual();
                            out.println("<div class =\"bloque\">");
                            out.println("<div class=\"informacion-subasta\">");
                            out.println("<img src=\"./res/subasta.png\" alt=\"subastas\" width=\"150px\" height=\"100px\">");
                            out.println("</div>");
                            out.println("<div class=\"puja\">");
                            out.println("<p>Id Subasta: " + actual.getId_subasta() + " </p>");
                            out.println("<p>Fecha alta: " + actual.getFecha_alta()+ " </p>");
                            out.println("<p>Fecha cierre: " + actual.getFecha_cierre()+ " </p>");
                            out.println("<p>Precio Inicial: " + actual.getPrecio_inicial()+ " </p>");
                            out.println("<p>Precio final: " + actual.getPrecio_final()+ " </p>");
                            out.println("<p>Estado " + actual.getEstado()+ " </p>");
                            out.println(" <form action=\"ControladorActivarSubasta\" method=\"Post\" class=\"formulario\">"
                                    + "<input type=\"hidden\" name=\"id-subasta\" value=\"" + actual.getId_subasta() + "\" class=\"btn-input\">"
                                    + "<input type=\"submit\" value=\"Activar/Desactivar\" class=\"btn-input\">"
                                    + "</form>"
                                    + "</div>");
                            out.println("</div>");
                            ite.siguiente();
                        }
                        
                    }else{
                        out.println("<h2>No hay subastas registradas</h2>");
                    }
                    out.println("</div>");
                %>
            </div>
            <jsp:include page="ComponenteFooter.jsp"/>
        </div>
    </body>
</html>
