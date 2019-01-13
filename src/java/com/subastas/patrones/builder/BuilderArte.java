
package com.subastas.patrones.builder;

/**
 *
 * @author Grupo_12
 */
public class BuilderArte extends BuilderArticulo{
    private final String ARTE = "Arte";
    
    @Override
    public void crearGeneral(Integer id_articulo, String Nombre, String Descripcion, int anio, 
            String estado_conservacion, float precio, 
            String foto) {
        articulo.setId_articulo(id_articulo);
        articulo.setNombre(Nombre);
        articulo.setDescripcion(Descripcion);
        articulo.setAnio(anio);
        articulo.setEstado_conservacion(estado_conservacion);
        articulo.setPrecio(precio);
        articulo.setFoto(foto);
    }

    @Override
    public void crearCategoria() {
        articulo.setCategoria(ARTE);
    }

    @Override
    public void crearEspecifico(String dimensiones, String autor, String procedencia) {
        articulo.setDimensiones(null);
        articulo.setAutor(autor);
        articulo.setProcedencia(null);
    }
    
}
