<%-- 
Página principal donde el usuario puede ver el catálogo de pujas disponibles,
puede acceder a su perfil de usuario, etc.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="Página de subastas - Práctica final Multimedia" content="">
    <meta name="Grupo11" content="">
    <link rel="icon" href="#">
    <!-- Favicon -->
    <link href="./css/styles.css" rel="stylesheet">

    <title>Subastas</title>
    <%
       
    %>
        
</head>

<body>
    <div class="contenedor-principal">
        <header>           
            <a href="#"><img id="logo" src="./res/logo.jpg" alt="logo"></a>
            <ul class="lista-nav">
                <li class="elemento-nav"><a href="#">Inicio</a></li>
                <li class="elemento-nav"><a href="#">Subastas</a></li>
                <li class="elemento-nav"><a href="#">Contacto</a></li>
            </ul>
        </header>
        <main>
            <h1>Página principal de subastas</h1>
            <section class="fila">
                <article class="columna">
                    <h2>Billetes</h2>
                    <img src="./res/billete.jpg" alt="billete" width="250px" height="170px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Iusto fuga quas corporis velit explicabo cum dolorem excepturi
                    neque earum nostrum? Harum perferendis accusamus sequi qui earum impedit vel ducimus eligendi?</p>
                </article>
                <article class="columna">
                    <h2>Monedas</h2>
                    <img src="./res/monedas.jpg" alt="moneda" width="250px" height="170px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates deleniti impedit, ullam officia unde, assumenda,
                    quas perspiciatis similique accusamus totam numquam reprehenderit non pariatur animi reiciendis vero nobis eius
                    maiores. Doloremque quas optio earum at unde repellat sequi molestias ex.</p>
                </article>
                <article class="columna">
                    <h2>Elemento</h2>
                    <img src="./res/monedas.jpg" alt="moneda" width="250px" height="170px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates deleniti impedit, ullam officia unde, assumenda,
                    quas perspiciatis similique accusamus totam numquam reprehenderit non pariatur animi reiciendis vero nobis eius
                    maiores. Doloremque quas optio earum at unde repellat sequi molestias ex.</p>
                </article>
            </section>
        </main>
        <footer>
            <p>&copy;2019</p>
        </footer>  
    </div> 
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/main.js"></script>
</body>

</html>

