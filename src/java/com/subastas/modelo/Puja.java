
package com.subastas.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Puja {
    private Integer id_puja;
    private Integer id_subasta;
    private String nombre_usuario;
    private float cantidad;
    
    //Constructor usado para cuando se obtiene una puja de la BBDD
    public Puja(Integer id_puja, Integer id_subasta, String nombre_usuario, float cantidad) {
        this.id_puja = id_puja;
        this.id_subasta = id_subasta;
        this.nombre_usuario= nombre_usuario;
        this.cantidad = cantidad;
    }

    //Constructor usado cuando se inserta una puja en la BBDD
    public Puja(Integer id_subasta, String nombre_usuario, float cantidad) {
        this.id_puja = null;
        this.id_subasta = id_subasta;
        this.nombre_usuario = nombre_usuario;
        this.cantidad = cantidad;
    }
                             
}