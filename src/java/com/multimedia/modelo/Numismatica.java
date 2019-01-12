
package com.multimedia.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Grupo_12
 */
@Getter
@Setter
public class Numismatica extends Articulo{
    private String procedencia;

    public Numismatica(String procedencia, Integer id_articulo, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {
        super(id_articulo, nombre, descripcion, anio, estado_conservacion, precio, foto, categoria);
        this.procedencia = procedencia;
    }

    public Numismatica(String procedencia, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {
        super(nombre, descripcion, anio, estado_conservacion, precio, foto, categoria);
        this.procedencia = procedencia;
    }
    
}
