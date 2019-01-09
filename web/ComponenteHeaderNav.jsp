<%-- 
Contiene la cabecera y la barra de navegación
--%>

<%@page import="com.multimedia.modelo.Usuario"%>
<div id="header">
    <div class="shell">
        <h1 id="logo"><a href="VistaPrincipal.jsp">Subasta<span>&amp;</span>Antiguedades</a></h1>
       <!-- <div><img src="res/UAH.png" height = "70"/></div>-->

        <!--div id="content"-->
        <div id="navigation">
            <ul>
                <li><a href="VistaPrincipal.jsp">Inicio<em></em></a></li>

                <% //Comprueba si es un administrador o un cliente
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    Boolean administrador = (Boolean) session.getAttribute("administrador");
                    if (usuario != null) {//Si el usuario no ha iniciado sesion se muestran los botones de inicio
                        if (administrador) {
                            out.println(" <li<a href =\"VistaPanelAdmin.jsp\">Panel<span><em></em></span></a></li>");
                        } else {
                            out.println("<li><a href=\"" + request.getContextPath() + "/ControladorPujas\">Mis pujas<span><em></em></span></a></li>");
                        }
                    }
                %>
                <li><a href="VistaContacto.jsp">Contacto</a></li>
                <% //Comprueba si ha iniciado sesión
                    if (usuario == null) {
                        out.println("<li><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion<span><em></em></span></a></li>");
                        out.println("<li class=\"last\"><a href=\"VistaRegistroCliente.jsp\">Registrarse<span><em></em></span></a></li>");
                    } else {
                       // out.println("<i class=\"fa fa-user-circle-o\" aria-hidden=\"true\"></i>");
                        out.println("<li>" + usuario.getNombre_usuario() + "</li>");
                        out.println("<li class=\"last\"><a href=\"" + request.getContextPath() + "/ControladorLogout\">Cerrar Sesión<span><em></em></span></a></li>");
                    }
                %>
            </ul>
        </div>
    </div>
</div>