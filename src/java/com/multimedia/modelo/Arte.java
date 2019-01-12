
package com.multimedia.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Grupo_12
 */
@Getter
@Setter
public class Arte extends Articulo{
    private String autor;

    public Arte(String autor, Integer id_articulo, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {
        super(id_articulo, nombre, descripcion, anio, estado_conservacion, precio, foto, categoria);
        this.autor = autor;
    }

    public Arte(String autor, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {
        super(nombre, descripcion, anio, estado_conservacion, precio, foto, categoria);
        this.autor = autor;
    }
    
}
