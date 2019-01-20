/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.strategy;

import com.subastas.modelo.Subasta;
import java.util.ArrayList;

/**
 *
 * @author alexandermunguiaclemente
 */
public class Contexto {

    private Estrategia estrategia; // Estrategia que se usa.
    private ArrayList<Subasta> subastas; // Lista de subasstas.

    /**
     * Constructor.
     *
     * @param e Estrategia que se usa.
     * @param u Lista de subastas.
     */
    public Contexto(Estrategia e, ArrayList<Subasta> u) {
        this.estrategia = e;
        this.subastas = u;
    }

    /**
     * Establece la estrategia a usar.
     *
     * @param e Estrategia a usar.
     */
    public void setEstrategia(Estrategia e) {
        this.estrategia = e;
    }

    /**
     * Ejecuta la estrategia.
     */
    public ArrayList<Subasta> ejecutaEstrategia() {
        estrategia.ordena(subastas);
        return subastas;
    }
}  
