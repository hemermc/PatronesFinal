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
public class Tarjeta {

    private final int numero;
    private final String nombre;
    private final int mes;
    private final int ano;
    private final String tipo;
    private final String titular;

    public Tarjeta(int numero, String nombre, int mes, int ano, String tipo, String titular) {
        this.numero = numero;
        this.nombre = nombre;
        this.mes = mes;
        this.ano = ano;
        this.tipo = tipo;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTitular() {
        return titular;
    }
 
}
