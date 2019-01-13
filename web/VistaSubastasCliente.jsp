<%-- 
    Document   : VistaSubastasCliente
    Created on : 09-ene-2019, 12:29:18
    Author     : amunguia
--%>

<%@page import="com.subastas.modelo.Articulo"%>
<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.subastas.modelo.Subasta"%>
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
            <main>
                <div class="contenedor-pujas">
                    <%
                        ArrayList<Subasta> listaSubastas = (ArrayList) session.getAttribute("lista-subastas");
                        String categoriaSubasta = (String) session.getAttribute("categoria-subasta");
                        ArrayList<Articulo> listaArticulos = null;
                       
                        if (listaSubastas != null) {//Si hay subastas activas de ese tipo
                            if(categoriaSubasta.equalsIgnoreCase("Mobiliario")){
                                listaArticulos = (ArrayList) session.getAttribute("lista-articulos");
                            }
                            else if(categoriaSubasta.equalsIgnoreCase("Arte")){ 
                                listaArticulos = (ArrayList) session.getAttribute("lista-articulos");
                            } else if(categoriaSubasta.equalsIgnoreCase("Numismatica")){ 
                                listaArticulos = (ArrayList) session.getAttribute("lista-articulos");
                            }
                            out.println("<h1> Subastas de " + categoriaSubasta + "</h1>");
                            out.println("<h3>Número de subastas activas:" + listaSubastas.size() + "</h3>");
                            
                            for (int i = 0; i < listaSubastas.size(); i++) {
                                out.println("<div class=\"subasta-elemento\">");
                                out.println("<p>Nombre subasta: " + listaSubastas.get(i).getNombre() + "</p>"
                                        + "<p>Precio: " + listaSubastas.get(i).getPrecio_final()+ "</p>"
                                        + "<p>Fecha: " + listaSubastas.get(i).getPrecio_inicial()+ "</p>");
                               if(categoriaSubasta.equalsIgnoreCase("Mobiliario")){
                                    out.println("<p>Nombre: " + listaArticulos.get(i).getNombre()+ " </p>");
                                    out.println("<p>Descripción: " + listaArticulos.get(i).getDescripcion()+ " </p>");
                                    out.println("<p>Año: " + listaArticulos.get(i).getAnio()+ " </p>");
                                    out.println("<p>Estado de conservación: " + listaArticulos.get(i).getEstado_conservacion()+ " </p>");
                                    out.println("<p>Precio: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Foto: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Dimensiones " + listaArticulos.get(i).getDimensiones()+ " </p>");
                               } else if(categoriaSubasta.equalsIgnoreCase("Arte")){
                                    out.println("<p>Nombre: " + listaArticulos.get(i).getNombre()+ " </p>");
                                    out.println("<p>Descripción: " + listaArticulos.get(i).getDescripcion()+ " </p>");
                                    out.println("<p>Año: " + listaArticulos.get(i).getAnio()+ " </p>");
                                    out.println("<p>Estado de conservación: " + listaArticulos.get(i).getEstado_conservacion()+ " </p>");
                                    out.println("<p>Precio: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Foto: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Autor " + listaArticulos.get(i).getAutor()+ " </p>");
                               } else if(categoriaSubasta.equalsIgnoreCase("Numismatica")){
                                    out.println("<p>Nombre: " + listaArticulos.get(i).getNombre()+ " </p>");
                                    out.println("<p>Descripción: " + listaArticulos.get(i).getDescripcion()+ " </p>");
                                    out.println("<p>Año: " + listaArticulos.get(i).getAnio()+ " </p>");
                                    out.println("<p>Estado de conservación: " + listaArticulos.get(i).getEstado_conservacion()+ " </p>");
                                    out.println("<p>Precio: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Foto: " + listaArticulos.get(i).getAnio() + " </p>");
                                    out.println("<p>Procedencia " + listaArticulos.get(i).getProcedencia()+ " </p>");
                               }
                                out.println(" <form action=\"ControladorSubastas\" method=\"Post\" class=\"formulario\">"
                                        + "<input type=\"hidden\" name=\"id-subasta\" value=\"" + listaSubastas.get(i).getId_subasta() + "\" class=\"btn-input\">"
                                        + "<input type=\"hidden\" name=\"categoria\" value=\"" + categoriaSubasta + "\" class=\"btn-input\">"
                                        + "<input type=\"text\" name=\"puja\" class=\"btn-input\" placeholder=\"Precio\" required>"
                                        + "<input type=\"submit\" value=\"Pujar\" class=\"btn-input\">"
                                        + "</form>"
                                        + "</div>");
                            }
                        } else {
                            out.println("<h3>No existe subastas de este tipo");
                        }
                    %>  
                </div>
            </main>
            <footer>
                <ul>
                    <li>&copy; 2019 Patrones</li>
                </ul>
            </footer>
        </div>
    </body>
</html>
