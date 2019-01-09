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
			<h1>Nosotros somos una empresa seria de subastas y antiguedades<br /></h1>
                        <p><em>sabemos que necesitas algo mas, el servicio atento de la compañia, conócenos.</em></p>
		</div>
            
		<div class="col">
					<h2>Subastas Activas</h2>
					<p>Sed at elit non est auctor lobortis sed nec turpis. Vivamus nec odio eget lacus semper ultrices. Cras rhoncus purus id lectus congue eu faucibus leo bibendum. Curabitur fermentum lobortis nunc, at ornare ante tristique quis.</p>
					<form action="ControladorAccesoSubasta" method="get">
                                            <input type="hidden" name="tipo" value="Monedas">
                                            <input class="link" type="submit"  value="Acceder" >
                                        </form>
                                        
				</div>
				<div class="col">
					<h2>Productos</h2>
					<p>Sed at elit non est auctor lobortis sed nec turpis. Vivamus nec odio eget lacus semper ultrices. Cras rhoncus purus id lectus congue eu faucibus leo bibendum. Curabitur fermentum lobortis nunc, at ornare ante tristique quis.</p>
					<a class="link" href="#">Acceder</a>
				</div>
				<div class="col last">
					<h2>Tus Pujas</h2>
					<p>Sed at elit non est auctor lobortis sed nec turpis. Vivamus nec odio eget lacus semper ultrices. Cras rhoncus purus id lectus congue eu faucibus leo bibendum. Curabitur fermentum lobortis nunc, at ornare ante tristique quis.</p>
					<a class="link" href="#">Acceder</a>
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
            </div>
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
            
        </div>
    </body>
</html>