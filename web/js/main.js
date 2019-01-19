//Oculta los elementos del selector de acciones en el panel de gestion 
//de subastas admin 
$('#selector-accion').change(function () {
    if ($("#selector-accion option:selected").val() === "insertar") {
        $('#insertar').show();
        $('#actualizar').hide();
        $('#eliminar').hide();
    } else if ($("#selector-accion option:selected").val() === "actualizar") {
        $('#insertar').hide();
        $('#actualizar').show();
        $('#eliminar').hide();
    } else if ($("#selector-accion option:selected").val() === "eliminar") {
        $('#insertar').hide();
        $('#actualizar').hide();
        $('#eliminar').show();
    }
});

//Envia los datos del detalle de la subasta a la modal del admin
function setDetalleSubastaAdmin(datosSubasta) {
    var partsOfStr = datosSubasta.split(';');

    $('#detalle-subasta-admin')
            .html('<p class="card-text"><strong>Nombre: </strong>' + partsOfStr[0] + '</p>'
                    + '<p class="card-text"><strong>Precio inicial: </strong>' + partsOfStr[1] + '&euro;</p>'
                    + '<p class="card-text"><strong>Precio final: </strong>' + partsOfStr[2] + '&euro;</p>'
                    + '<p class="card-text"><strong>Fecha alta: </strong>' + partsOfStr[3] + '</p>'
                    + '<p class="card-text"><strong>Fecha cierre: </strong>' + partsOfStr[4] + '</p>');
}

//Envia los datos del detalle del articulo a la modal del admin
function setDetalleArticuloAdmin(datosArticulo) {
    var partsOfStr = datosArticulo.split(';');

    $('#detalle-articulo-admin')
            .html('<p class="card-text"><strong>Nombre: </strong>' + partsOfStr[0] + '</p>'
                    + '<p class="card-text"><strong>Descripción: </strong>' + partsOfStr[1] + '</p>'
                    + '<p class="card-text"><strong>Año: </strong>' + partsOfStr[2] + '</p>'
                    + '<p class="card-text"><strong>Estado de conservación: </strong>' + partsOfStr[3] + '</p>'
                    + '<p class="card-text"><strong>Precio: </strong>' + partsOfStr[4] + '&euro;</p>'
                    + '<p class="card-text"><strong>Categoria: </strong>' + partsOfStr[5] + '</p>'
                    + '<p class="card-text"><strong>Dimensiones: </strong>' + partsOfStr[6] + '</p>'
                    + '<p class="card-text"><strong>Procedencia: </strong>' + partsOfStr[7] + '</p>'
                    + '<p class="card-text"><strong>Autor: </strong>' + partsOfStr[8] + '</p>');
}

//Envia los datos de la subasta a la modal de detalle de subasta como cliente
function setDetalleSubastaCliente(datosSubasta) {
    var partsOfStr = datosSubasta.split(';');

    $('#detalle-subasta')
            .html('<h4>' + partsOfStr[0] + '</h4>'
                    + '<p class="card-text"><strong>Precio final: </strong>' + partsOfStr[0] + '&euro;</p>'
                    + '<p class="card-text"><strong>Fecha alta: </strong>' + partsOfStr[1] + '</p>'
                    + '<p class="card-text"><strong>Fecha cierre: </strong>' + partsOfStr[2] + '</p>'
                    + '<br><br>' +
                    +'<p class="card-text"><strong>Nombre: </strong>' + partsOfStr[3] + '</p>'
                    + '<p class="card-text"><strong>Descripción: </strong>' + partsOfStr[4] + '</p>'
                    + '<p class="card-text"><strong>Año: </strong>' + partsOfStr[5] + '</p>'
                    + '<p class="card-text"><strong>Estado de conservación: </strong>' + partsOfStr[6] + '</p>'
                    + '<p class="card-text"><strong>Precio: </strong>' + partsOfStr[7] + '&euro;</p>'
                    + '<p class="card-text"><strong>Categoria: </strong>' + partsOfStr[8] + '</p>'
                    + '<p class="card-text"><strong>Dimensiones: </strong>' + partsOfStr[9] + '</p>'
                    + '<p class="card-text"><strong>Procedencia: </strong>' + partsOfStr[10] + '</p>'
                    + '<p class="card-text"><strong>Autor: </strong>' + partsOfStr[11] + '</p>');
}

//Envia el id de la subasta a la modal de puja del cliente
function setIdSubastaPuja(idSubasta) {
    $('#form-puja')
            .append('<input type="hidden" value="' + idSubasta + '" name="id-subasta">');
}
