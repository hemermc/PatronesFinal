
package com.subastas.modelo;

import lombok.Data;
import lombok.ToString;

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
    private String fecha_alta;
    private String fecha_cierre;
    private String estado;
    private Integer id_articulo;

    
    //Constructor usado para cuando se obtiene una subasta de la BBDD
    public Subasta(Integer id_subasta, String nombre, float precio_inicial, float precio_final, String fecha_alta, String fecha_cierre, String estado, Integer id_articulo) {
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
    public Subasta(String nombre, float precio_inicial, float precio_final, String fecha_alta, String fecha_cierre, String estado, Integer id_articulo) {
        this.id_subasta = null;
        this.nombre = nombre;
        this.precio_inicial = precio_inicial;
        this.precio_final = precio_final;
        this.fecha_alta = fecha_alta;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.id_articulo = id_articulo;
    }
    
    public String datosSubasta(){
        return nombre+";"+precio_inicial+";"+precio_final+";"+fecha_alta+";"+fecha_cierre+";"+estado+";"+id_articulo+";";
    }
}
