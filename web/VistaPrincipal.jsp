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
        <meta name="P�gina de subastas" content="">
        <link rel="icon" href="#"><!-- Favicon -->
        <link rel="stylesheet" href="./css/newstyles.css"/>
        <title>Numism�tica UAH</title>
    </head>
    <body>
        <div class="contenedor-index">   
            <jsp:include page="ComponenteHeaderNav.jsp"/>
            <div id="content">
                <div class="line"></div>
		<div id="pitch">
                    <h1>Somos una empresa seria de subastas y antig�edades. <br /></h1>
                    <p><em>Sabemos que necesitas algo m�s, el servicio atento de la compa�ia, con�cenos.</em></p>
		</div>
		<div class="col">
                    <h2>Mobiliario</h2>
                    <p>En esta secci�n podr�s encontrar diferentes subastas de art�culos relacionados con la categor�a de Mobiliario.</p>
                    <form action="ControladorAccesoSubasta" method="get">
                        <input type="hidden" name="categoria" value="Mobiliario">
                        <input class="link" type="submit"  value="Acceder" >
                    </form>                               
                </div>
                <div class="col">
                    <h2>Arte</h2>
                    <p>En esta secci�n podr�s encontrar diferentes subastas de art�culos relacionados con la categor�a de Arte.</p>
                    <form action="ControladorAccesoSubasta" method="get">
                        <input type="hidden" name="categoria" value="Arte">
                        <input class="link" type="submit" value="Acceder">
                    </form>	
                </div>
                <div class="col">
                    <h2>Numism�tica</h2>
                    <p>En esta secci�n podr�s encontrar diferentes subastas de art�culos relacionados con la categor�a de Numism�tica.</p>
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
            <p>Copyright &copy; 2019 &minus; Subastas&amp;Antiguedades &middot; Dise�adores: Alexander y Juan Antonio</p>
        </div>   
    </body>
</html>