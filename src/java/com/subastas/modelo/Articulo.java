
package com.subastas.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Articulo {
    
    private int id_articulo;
    private String nombre;
    private String descripcion;
    private int anio;
    private String estado_conservacion;
    private float precio;
    private String categoria;
    private String foto;
    private String dimensiones;
    private String procedencia;
    private String autor;

    public Articulo(int id_articulo, String nombre, String descripcion, int anio, String estado_conservacion, float precio, String categoria, String foto, String dimensiones, String procedencia, String autor) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
        this.estado_conservacion = estado_conservacion;
        this.precio = precio;
        this.categoria = categoria;
        this.foto = foto;
        this.dimensiones = dimensiones;
        this.procedencia = procedencia;
        this.autor = autor;
    }

    public Articulo() {
         //To change body of generated methods, choose Tools | Templates.
    }
    
    public String datosArticulo(){
        return nombre+";"+descripcion+";"+anio+";"+estado_conservacion+";"+precio+";"+categoria+";"+dimensiones+";"+procedencia+";"+autor+";";
    }
    
}