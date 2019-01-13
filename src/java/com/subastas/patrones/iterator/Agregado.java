/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.iterator;

/**
 *
 * @author amunguia
 */
public interface Agregado {

    /**
     * Método de fabricación para crear un iterador.
     *
     * @return Iterador concreto.
     */
    Iterador crearIterador();
}
