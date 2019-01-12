<%-- 
Contiene la cabecera y la barra de navegaci�n
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<script src="./js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="./js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="./js/jquery-func.js" type="text/javascript"></script>
<div id="header">
    <div class="shell">
        <h1 id="logo"><a href="VistaPrincipal.jsp">Subasta<span>&amp;</span>Antiguedades</a></h1>
       <!-- <div><img src="res/UAH.png" height = "70"/></div>-->

        <% //Comprueba si es un administrador o un cliente
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            Boolean administrador = (Boolean) session.getAttribute("administrador");
            if (usuario != null) {//Si el usuario no ha iniciado sesion se muestran los botones de inicio
                if (administrador) {
                    out.println("<li><a href =\"VistaPanelAdmin.jsp\">Panel</a></li>");
                } else {
                    out.println("<li><a href=\"" + request.getContextPath() + "/ControladorPujas\">Mis pujas</a></li>");
                }
            }
        %>
        <li><a href="VistaContacto.jsp">Contacto</a></li>
        <% //Comprueba si ha iniciado sesi�n
            if (usuario == null) {
                out.println("<li><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion</a></li>");
                out.println("<li><a href=\"VistaRegistroCliente.jsp\">Registrarse</a></li>");
            } else {
                out.println("<li>" + usuario.getNombre_usuario() + "</li>");
                out.println("<li><a href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesi�n</a></li>");
            }
        %>
    </ul>
</div>
