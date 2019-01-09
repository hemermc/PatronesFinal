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
public class Moneda extends Articulo {

    private final String estrellas;

    //Constructor para gestionar la información de la BBDD
    public Moneda(Integer lote, String valor, int anio, String estrellas, String lugar_emision, String conservacion, float precio, String foto) {
        super(lote,valor, anio, lugar_emision, conservacion, precio, foto);
        this.estrellas = estrellas;
    }
    
    //Constructor para los insert
    public Moneda(String valor, int anio, String estrellas, String lugar_emision, String conservacion, float precio, String foto) {
        super(valor, anio, lugar_emision, conservacion, precio, foto);
        this.estrellas = estrellas;
    }
    
    public String getEstrellas() {
        return estrellas;
    }
}
