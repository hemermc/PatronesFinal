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
        <div id="navigation">
            <ul>
                <li>
                    <a href="VistaPrincipal.jsp">Inicio<span><em></em></span></a>
                </li>
                <% //Comprueba si es un administrador o un cliente
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    Boolean administrador = (Boolean) session.getAttribute("administrador");
                    if (usuario != null) {//Si el usuario no ha iniciado sesion se muestran los botones de inicio
                        if (administrador) {
                            out.println("<li><a href =\"VistaPanelAdmin.jsp\">Panel<span><em></em></span></a></li>");
                        } else {
                            out.println("<li><a href=\"" + request.getContextPath() + "/ControladorPujas\">Mis pujas<span><em></em></span></a></li>");
                        }
                    }
                %>
                <li>
                    <a href="VistaContacto.jsp">Contacto<span><em></em></span></a>
                </li>
                <% //Comprueba si ha iniciado sesi�n
                    if (usuario == null) {
                        out.println("<li><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion<span><em></em></span></a></li>");
                        out.println("<li class=\"last\"><a href=\"VistaRegistroCliente.jsp\">Registrarse<span><em></em></span></a></li>");
                    } else {
                        out.println("<li id=\"user-avatar\">" + usuario.getNombre_usuario() + "</li>");
                        out.println("<li class=\"last\"><a href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesi�n<span><em></em></span></a></li>");
                    }
                %>
            </ul>
        </div>
    </div>
</div>