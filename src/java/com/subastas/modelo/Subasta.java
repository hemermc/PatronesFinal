
package com.subastas.modelo;

import com.subastas.patrones.observer.Observador;
import com.subastas.patrones.observer.SujetoInterface;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Subasta {

    private Integer id_subasta;
    private String nombre;
    private float precio_inicial;
    private float precio_final;
    private LocalDate fecha_alta;
    private LocalDate fecha_cierre;
    private String estado;
    private Integer id_articulo;

    
    //Constructor usado para cuando se obtiene una subasta de la BBDD
    public Subasta(Integer id_subasta, String nombre, float precio_inicial, float precio_final, LocalDate fecha_alta, LocalDate fecha_cierre, String estado, Integer id_articulo) {
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
    public Subasta(String nombre, float precio_inicial, float precio_final, LocalDate fecha_alta, LocalDate fecha_cierre, String estado, Integer id_articulo) {
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
