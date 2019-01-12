
package com.patrones.builder;

import com.multimedia.modelo.Articulo;

/**
 *
 * @author Grupo_12
 */
public class Director {
    private BuilderArticulo builderArticulo;
    
    public void setBuilderArticulo(BuilderArticulo builderArticulo){
        this.builderArticulo = builderArticulo;
    }
    
    public Articulo getArticulo(){
        return builderArticulo.getArticulo();
    }
    
    public void crearArticulo(Integer id_articulo, String nombre, String descripcion, int anio, 
            String estado_conservacion, float precio, String foto, 
            String dimensiones, String autor, String procedencia){
        builderArticulo.crearArticulo();       
        builderArticulo.crearGeneral(id_articulo, nombre, descripcion, anio, 
            estado_conservacion, precio, foto);
        builderArticulo.crearCategoria();
        builderArticulo.crearEspecifico(dimensiones, autor, procedencia);
    }
    
}
