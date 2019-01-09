/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

import java.time.LocalDate;

/**
 *
 * @author amunguia
 */
public class Billete extends Articulo {

    //(Lote, valor, año, lugar de emisión, fecha, serie, conservación, precio, <<foto>>)
    private final LocalDate fecha;
    private final String serie;

    public Billete(Integer lote, String valor, int anio, String lugar_emision, LocalDate fecha, String serie, String conservacion, float precio, String foto) {
        super(lote, valor, anio, lugar_emision, conservacion, precio, foto);
        this.fecha = fecha;
        this.serie = serie;
    }

    public Billete(String valor, int anio, String lugar_emision, LocalDate fecha, String serie, String conservacion, float precio, String foto) {
        super(valor, anio, lugar_emision, conservacion, precio, foto);
        this.fecha = fecha;
        this.serie = serie;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getSerie() {
        return serie;
    }
    
}
