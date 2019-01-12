
package com.patrones.builder;

import com.multimedia.modelo.Articulo;

/**
 *
 * @author Grupo_12
 */
public abstract class BuilderArticulo {
    protected Articulo articulo;

    public Articulo getArticulo(){
        return this.articulo;
    }
    
    public void crearArticulo(){
        this.articulo = new Articulo();
    }
    
    public abstract void crearGeneral(Integer id_articulo, String Nombre, String Descripcion, int anio, 
            String estado_conservacion, float precio, String foto);
    public abstract void crearCategoria();
    public abstract void crearEspecifico(String dimensiones, String autor, String procedencia);
}
