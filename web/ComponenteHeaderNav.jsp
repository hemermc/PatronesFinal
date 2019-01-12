<%-- 
Contiene la cabecera y la barra de navegación
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<header>
    <div id="logo"><h1><a href="VistaPrincipal.jsp">Subasta<span>&amp;</span>Antiguedades</a></h1></div>
    <div><img src="res/UAH.png" height = "70"/></div>
</header>
<div id="content">
    <ul id="menu">
	<li class="current"><a href="VistaPrincipal.jsp">Inicio</a></li>

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
        <% //Comprueba si ha iniciado sesión
            if (usuario == null) {
                out.println("<li><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion</a></li>");
                out.println("<li><a href=\"VistaRegistroCliente.jsp\">Registrarse</a></li>");
            } else {
                out.println("<li>" + usuario.getNombre_usuario() + "</li>");
                out.println("<li><a href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesión</a></li>");
            }
        %>
    </ul>
</div>