
package com.multimedia.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Compras {
    private final Integer id_compra;
    private final float importe;
    private final Integer id_subasta;
    private final String nombre_usuario;
    
    
    //Constructor usado para cuando se obtiene una compra de la BBDD
    public Compras(Integer id_compra,float importe,Integer id_subasta,String nombre_usuario){
        this.id_compra = id_compra;
        this.importe = importe;
        this.id_subasta = id_subasta;
        this.nombre_usuario = nombre_usuario;    
    }

    // Constructor usado cuando se inserta una compra en la BBDD
    public Compras(float importe, Integer id_subasta, String nombre_usuario) {
        this.id_compra = null;
        this.importe = importe;
        this.id_subasta = id_subasta;
        this.nombre_usuario = nombre_usuario;
    }

}