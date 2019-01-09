<%-- 
    Document   : VistaSubastasCliente
    Created on : 09-ene-2019, 12:29:18
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.Billete"%>
<%@page import="com.multimedia.modelo.Moneda"%>
<%@page import="com.multimedia.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.multimedia.modelo.Subasta"%>
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
            <main>
                <div class="contenedor-pujas">
                    <%
                        ArrayList<Subasta> listaSubastas = (ArrayList) session.getAttribute("lista-subastas");
                        String tiposubasta = (String) session.getAttribute("tipo-subasta");
                        ArrayList<Moneda> monedas = null;
                        ArrayList<Billete> billetes = null;
                        if(tiposubasta.equalsIgnoreCase("Monedas")){ monedas = (ArrayList) session.getAttribute("listalote");}
                        else {billetes = (ArrayList) session.getAttribute("listalote");}
                        out.println("<h1> Subastas de " + tiposubasta + "</h1>");
                        if (listaSubastas != null) {//Si hay subastas activas de ese tipo
                            out.println("<h3>Número de subastas activas:" + listaSubastas.size() + "</h3>");
                            for (int i = 0; i < listaSubastas.size(); i++) {
                                out.println("<div class=\"subasta-elemento\">");
                                out.println("<p>Nombre subasta: " + listaSubastas.get(i).getNombre() + "</p>"
                                        + "<p>Precio: " + listaSubastas.get(i).getPrecioFinal() + "</p>"
                                        + "<p>Fecha: " + listaSubastas.get(i).getFecha() + "</p>");
                               if(tiposubasta.equalsIgnoreCase("Monedas")){ //Si es monedas imprimimos una información
                                        
                                        out.println("<p>Lote: " + monedas.get(i).getLote() + " </p>");
                                        out.println("<p>Conservación: " + monedas.get(i).getConservacion() + " </p>");
                                        out.println("<p>Valor: " + monedas.get(i).getValor() + " </p>");
                                        out.println("<p>Emisión: " + monedas.get(i).getLugar_emision() + " </p>");
                                        out.println("<p>Año: " + monedas.get(i).getAnio() + " </p>");
                               }else{ //Billetes
                                   out.println("<p>Lote: " + billetes.get(i).getLote() + " </p>");
                                    out.println("<p>Conservación: " + billetes.get(i).getConservacion() + " </p>");
                                    out.println("<p>Valor: " + billetes.get(i).getValor() + " </p>");
                                    out.println("<p>Emisión: " + billetes.get(i).getLugar_emision() + " </p>");
                                    out.println("<p>Año: " + billetes.get(i).getAnio() + " </p>");
                               }
                                out.println(" <form action=\"ControladorSubastas\" method=\"Post\" class=\"formulario\">"
                                        + "<input type=\"hidden\" name=\"id-subasta\" value=\"" + listaSubastas.get(i).getId_subasta() + "\" class=\"btn-input\">"
                                        + "<input type=\"hidden\" name=\"tipo\" value=\"" + tiposubasta + "\" class=\"btn-input\">"
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
