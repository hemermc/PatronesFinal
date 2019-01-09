/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

/**
 *
 * @author amunguia
 */
public class Puja {
    private final Integer id_subasta;
    private final String nombre_usuario;
    private float cantidad;
    
    public Puja(Integer id_subasta, String nombre_usuario, float cantidad) {
        this.id_subasta = id_subasta;
        this.nombre_usuario= nombre_usuario;
        this.cantidad = cantidad;
    }  

    public Integer getId_subasta() {
        return id_subasta;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public float getCantidad() {
        return cantidad;
    }
                             
}
