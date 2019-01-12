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
        <jsp:include page="ComponenteHeaderNav.jsp"/>
        <div class="contenedor-index">   
            <div id="content">
		<div id="pitch">
                    <h1>Somos una empresa seria de subastas y antigüedades</h1>
                    <p><em>Sabemos que necesitas algo más, el servicio atento de la compañia, conócenos</em></p>
		</div>
                <div class="seccion">
                    <div class="col">
                        <div class="col-top">
                           <h2>Mobiliario</h2>    
                        </div>
                        <div class="col-mid">
                           <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Mobiliario</p>     
                        </div>
                        <div class="col-bot">
                            <form action="ControladorAccesoSubasta" method="get">
                                <input type="hidden" name="categoria" value="Mobiliario">
                                <input class="btn_acceso" type="submit"  value="Acceder" >
                            </form>       
                        </div>                         
                    </div>
                    <div class="col">
                        <div class="col-top">
                           <h2>Arte</h2>    
                        </div>
                        <div class="col-mid">
                           <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Arte</p>     
                        </div>
                        <div class="col-bot">
                            <form action="ControladorAccesoSubasta" method="get">
                                <input type="hidden" name="categoria" value="Arte">
                                <input class="btn_acceso" type="submit" value="Acceder">
                            </form>       
                        </div>                         
                    </div>
                    <div class="col">
                        <div class="col-top">
                           <h2>Numismática</h2>    
                        </div>
                        <div class="col-mid">
                           <p>En esta sección podrás encontrar diferentes subastas de artículos relacionados con la categoría de Numismática</p>     
                        </div>
                        <div class="col-bot">
                            <form action="ControladorAccesoSubasta" method="get">
                                <input type="hidden" name="categoria" value="Numismatica">
                                <input class="btn_acceso" type="submit" value="Acceder">
                            </form>       
                        </div>                         
                    </div> 
                </div>
            </div>
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
