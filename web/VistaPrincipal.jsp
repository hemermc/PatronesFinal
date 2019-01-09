<%-- 
    Document   : VistaPrincipal
    Created on : 09-ene-2019, 12:28:15
    Author     : amunguia
--%>

<%@page import="com.multimedia.modelo.*"%>
<!DOCTYPE html>
<html lang="es">
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
                <section>
                    <article class="bloque" id ="primero">   
                        <div class="informacion-subasta">
                            <h3>Subastas de monedas</h3>
                            <img src="./res/monedas.jpg" alt="monedas" width="240px" height="160px">
                        </div>
                        <div class="puja"> 
                            <form action="ControladorAccesoSubasta" method="get" class="formulario">
                                <input type="hidden" name="tipo" value="Monedas" class="btn-input">
                                <input type="submit"  value="Acceder" class="btn-input">
                            </form>	
                        </div>
                    </article>
                    <article class="bloque" id ="segundo">
                        <div class="informacion-subasta">
                            <h3>Subastas de billetes</h3>
                            <img src="./res/billete.jpg" alt="billete" width="240px" height="160px">
                        </div>
                        <div class="puja">
                            <form action="ControladorAccesoSubasta" method="get" class="formulario">
                                <input type="hidden" name="tipo" value="Billetes" class="btn-input">
                                <input type="submit" value="Acceder" class="btn-input">
                            </form>	
                        </div>
                    </article>
                </section>
            </main>
            <footer>
                <ul>
                    <li>&copy; 2019 Patrones</li>
                </ul>
            </footer>
        </div>
    </body>
</html>