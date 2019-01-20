
package com.subastas.patrones.builder;

import com.subastas.modelo.Articulo;

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
    
    public void crearArticulo(String nombre, String descripcion, int anio, 
            String estado_conservacion, float precio, String foto, 
            String dimensiones, String autor, String procedencia){
        builderArticulo.crearArticulo();       
        builderArticulo.crearGeneral(nombre, descripcion, anio, 
            estado_conservacion, precio, foto);
        builderArticulo.crearCategoria();
        builderArticulo.crearEspecifico(dimensiones, autor, procedencia);
    }
    
}
