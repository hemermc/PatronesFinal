$('#selector-accion').change(function(){
    if($( "#selector-accion option:selected" ).val() === "insertar"){
        $('#insertar').show();
        $('#actualizar').hide();
        $('#eliminar').hide();
    }else if($( "#selector-accion option:selected" ).val() === "actualizar"){
        $('#insertar').hide();
        $('#actualizar').show();
        $('#eliminar').hide();
    }else if($( "#selector-accion option:selected" ).val() === "eliminar"){
        $('#insertar').hide();
        $('#actualizar').hide();
        $('#eliminar').show();
    }
});