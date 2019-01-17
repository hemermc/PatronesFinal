<%-- 
Contiene la cabecera y la barra de navegación
--%>

<%@page import="com.subastas.modelo.Usuario"%>
<%@page import="com.subastas.commons.Constantes"%>
<script src="./js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="./js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="./js/jquery-func.js" type="text/javascript"></script>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">El Desván del Abuelo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <%out.println("<a class=\"nav-link\" href=\"VistaPrincipal.jsp\">Inicio</a>");%>
            </li>
            <% //Comprueba si es un administrador o un cliente
                Usuario usuario = (Usuario) session.getAttribute(Constantes.USUARIO);
                Boolean administrador = (Boolean) session.getAttribute(Constantes.ADMINISTRADOR);
                if (usuario != null) {//Si el usuario no ha iniciado sesion se muestran los botones de inicio
                    if (administrador) {
                        out.println("<li class=\"nav-item\"><a class=\"nav-link\" href =\"VistaPanelAdmin.jsp\">Panel</li>");
                    } else {
                        out.println("<li class=\"nav-item\"><a class=\"nav-item\" href=\"" + request.getContextPath() + "/ControladorPujas\">Mis pujas</li>");
                    }
                }
            %>
            <li class="nav-item">
                <a class="nav-link" href="VistaContacto.jsp">Contacto</a>
            </li>
            <% //Comprueba si ha iniciado sesión
                if (usuario == null) {
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"VistaInicioSesion.jsp\">Inicio de Sesion</a></li>");
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"VistaRegistroCliente.jsp\">Registrarse</a></li>");
                } else {
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">"+ usuario.getNombre_usuario() +"</a></li>");
                    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesión</a></li>");
                }
            %>  
        </ul>
    </div>
</nav>