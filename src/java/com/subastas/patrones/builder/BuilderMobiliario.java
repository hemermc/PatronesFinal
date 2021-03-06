
package com.subastas.patrones.builder;

/**
 *
 * @author Grupo_12
 */
public class BuilderMobiliario extends BuilderArticulo{
    private final String MOBILIARIO = "Mobiliario";
    
    @Override
    public void crearGeneral(String Nombre, String Descripcion, int anio, 
            String estado_conservacion, float precio,  
            String foto) {

        articulo.setNombre(Nombre);
        articulo.setDescripcion(Descripcion);
        articulo.setAnio(anio);
        articulo.setEstado_conservacion(estado_conservacion);
        articulo.setPrecio(precio);
        articulo.setFoto(foto);
    }

    @Override
    public void crearCategoria() {
        articulo.setCategoria(MOBILIARIO);
    }

    @Override
    public void crearEspecifico(String dimensiones, String autor, String procedencia) {
        articulo.setDimensiones(dimensiones);
        articulo.setAutor(null);
        articulo.setProcedencia(null);
    }
   
}
