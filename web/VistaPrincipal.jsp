<%-- 
    Document   : VistaPrincipal
    Author     : Grupo_12
--%>

<%@page import="com.multimedia.modelo.*"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="Página de subastas" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numismática UAH</title>
    </head>
    <body>
        <div class="contenedor-index">   
            <jsp:include page="ComponenteHeaderNav.jsp"/>
            <div id="content">
                <div class="line"></div>
		<div id="pitch">
                    <h1>Somos una empresa seria de subastas y antigüedades. <br /></h1>
                    <p><em>Sabemos que necesitas algo más, el servicio atento de la compañia, conócenos.</em></p>
		</div>
		<div class="col">
                    <h2>Mobiliario</h2>
                    <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Mobiliario.</p>
                    <form action="ControladorAccesoSubasta" method="get">
                        <input type="hidden" name="categoria" value="Mobiliario">
                        <input class="link" type="submit"  value="Acceder" >
                    </form>                               
                </div>
                <div class="col">
                    <h2>Arte</h2>
                    <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Arte.</p>
                    <form action="ControladorAccesoSubasta" method="get">
                        <input type="hidden" name="categoria" value="Arte">
                        <input class="link" type="submit" value="Acceder">
                    </form>	
                </div>
                <div class="col">
                    <h2>Numismática</h2>
                    <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Numismática.</p>
                    <form action="ControladorAccesoSubasta" method="get">
                        <input type="hidden" name="categoria" value="Numismatica">
                        <input class="link" type="submit" value="Acceder">
                    </form>	
                </div>
                <div class="col last">
                    <h2>Tus Pujas</h2>
                    <p>Gestiona tus pujas.</p>
                    <form action="ControladorPujas" method="get">
                        <input class="link" type="submit" value="Acceder">
                    </form>    
                </div>
                <div class="clr"></div>
            </div>
            <div class="clr"></div>
        </div>
        <div id="footer">
            <p id="links">
                <a href="#">Politica de privacidad</a>
                <a href="#">Terminos de uso</a>
            </p>
            <p>
                <a href="#">Inicio</a>
                <a href="#">Subastas</a>
                <a href="#">Productos subastados</a>
                <a href="#">Contactanos</a>
                <a href="#">acerca de nosotros</a>
            </p>
            <p>Copyright &copy; 2019 &minus; Subastas&amp;Antiguedades &middot; Diseñadores: Alexander y Juan Antonio</p>
        </div>   
    </body>
</html>