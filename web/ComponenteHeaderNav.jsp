<%-- 
Contiene la cabecera y la barra de navegación
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<header>
    <div class="box"></div>
    <div class="logo"><img src="res/numi.png" height = "70"></div>
    <div class="social"><img src="res/UAH.png" height = "70"/></div>
</header>
<nav>
    <div class="nav-elemento"><a href="VistaPrincipal.jsp">Inicio</a></div>
    <% //Comprueba si es un administrador o un cliente
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Boolean administrador = (Boolean) session.getAttribute("administrador");
        if (usuario != null) {//Si el usuario no ha iniciado sesion se muestran los botones de inicio
            if (administrador) {
                out.println(" <div class=\"nav-elemento\"> <a href =\"VistaPanelAdmin.jsp\">Panel</a></div>");
            } else {
                out.println("<div class=\"nav-elemento\"><a href=\"" + request.getContextPath() + "/ControladorPujas\">Mis pujas</a></div>");
            }
        }
    %>
    <div class="nav-elemento"><a href="VistaContacto.jsp">Contacto</a></div>
    <div class="nav-elemento">
        <% //Comprueba si ha iniciado sesión
            if (usuario == null) {
                out.println("<div class=\"login\"><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion</a></div>");
                out.println("<div class=\"login\"><a href=\"VistaRegistroCliente.jsp\">Registrarse</a></div>");
            } else {
                out.println("<i class=\"fa fa-user-circle-o\" aria-hidden=\"true\"></i>");
                out.println("<div class=\"login\">" + usuario.getNombre_usuario() + "</div>");
                out.println("<div class=\"login\"><a href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesión</a></div>");
            }
        %>
    </div>
</nav>