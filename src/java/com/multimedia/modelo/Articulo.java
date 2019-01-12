
package com.multimedia.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Articulo {
    
    protected final Integer id_articulo;
    protected final String nombre;
    protected final String descripcion;
    protected final int anio;
    protected final String estado_conservacion;
    protected final float precio;
    protected final String categoria;
    protected final String foto;


    //Constructor usado para cuando se obtiene un articulo de la BBDD
    public Articulo(Integer id_articulo, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {    
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
        this.estado_conservacion = estado_conservacion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
    }

    // Constructor usado cuando se inserta un articulo en la BBDD
    public Articulo(String nombre, String descripcion, int anio, String estado_conservacion, float precio, String foto, String categoria) {
        this.id_articulo = null;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
        this.estado_conservacion = estado_conservacion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
    }
    
}