
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
    
    public String datosArticulo(){
        return nombre+";"+descripcion+";"+anio+";"+estado_conservacion+";"+precio+";"+categoria+";"+dimensiones+";"+procedencia+";"+autor+";";
    }
    
}