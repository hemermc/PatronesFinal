
package com.multimedia.modelo;

import java.time.LocalDate;
import java.util.logging.Logger;
import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Subasta {

    private final Integer id_subasta;
    private final String nombre;
    private final float precio_inicial;
    private float precio_final;
    private final LocalDate fecha_alta;
    private final LocalDate fecha_cierre;
    private String estado;
    private final int id_articulo;

    
    //Constructor usado para cuando se obtiene una subasta de la BBDD
    public Subasta(Integer id_subasta, String nombre, float precio_inicial, float precio_final, LocalDate fecha_alta, LocalDate fecha_cierre, String estado, int id_articulo) {
        this.id_subasta = id_subasta;
        this.nombre = nombre;
        this.precio_inicial = precio_inicial;
        this.precio_final = precio_final;
        this.fecha_alta = fecha_alta;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.id_articulo = id_articulo;
    }
    
    // Constructor usado cuando se inserta una subasta en la BBDD
    public Subasta(String nombre, float precio_inicial, float precio_final, LocalDate fecha_alta, LocalDate fecha_cierre, String estado, int id_articulo) {
        this.id_subasta = null;
        this.nombre = nombre;
        this.precio_inicial = precio_inicial;
        this.precio_final = precio_final;
        this.fecha_alta = fecha_alta;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.id_articulo = id_articulo;
    }
}