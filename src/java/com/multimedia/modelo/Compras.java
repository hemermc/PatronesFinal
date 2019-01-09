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
public class Compras {
    private final Integer id_compra;
    private final float importe;
    private final Integer id_subasta;
    private final String nombre_usuario;
    
    
    public Compras(Integer id_compra,float importe,Integer id_subasta,String nombre_usuario){
        this.id_compra=id_compra;
        this.importe=importe;
        this.id_subasta=id_subasta;
        this.nombre_usuario=nombre_usuario;    
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public float getImporte() {
        return importe;
    }

    public Integer getId_subasta() {
        return id_subasta;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
}
