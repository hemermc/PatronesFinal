/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.iterator;

import java.util.ArrayList;

/**
 *
 * @author amunguia
 */
public class AgregadoConcreto implements Agregado {

    // Lista de elementos a recorrer.
    public ArrayList elementos;

    /**
     * Constructor.
     *
     * @param vec Lista de elementos a recorrer.
     */
    public AgregadoConcreto(ArrayList vec) {
        elementos = vec;
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto(this);
    }
}

