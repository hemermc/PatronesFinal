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
public class Articulo {

    protected final Integer lote;
    protected final String valor;
    protected final int anio;
    protected final String lugar_emision;
    protected final String conservacion;
    protected final float precio;
    protected final String foto;


    //Constructor usado para cuando se obtiene un articulo de la BBDD.
    public Articulo(Integer lote, String valor, int anio, String lugar_emision, String conservacion, float precio, String foto) {
        this.lote = lote;
        this.valor = valor;
        this.anio = anio;
        this.lugar_emision = lugar_emision;
        this.conservacion = conservacion;
        this.precio = precio;
        this.foto = foto;
    }

    // Constructor usado cuando se inserta un articulo en la BBDD.
    public Articulo(String valor, int anio, String lugar_emision, String conservacion, float precio, String foto) {
        this.lote = null;
        this.valor = valor;
        this.anio = anio;
        this.lugar_emision = lugar_emision;
        this.conservacion = conservacion;
        this.precio = precio;
        this.foto = foto;
    }

    public Integer getLote() {
        return lote;
    }

    public String getValor() {
        return valor;
    }

    public int getAnio() {
        return anio;
    }

    public String getLugar_emision() {
        return lugar_emision;
    }

    public String getConservacion() {
        return conservacion;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFoto() {
        return foto;
    }
    
}
