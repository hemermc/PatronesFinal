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
public interface Iterador {

    /**
     * Devuelve el primer elemento de la lista.
     *
     * @return Primer elemento de la lista.
     * @throws IndexOutOfBoundsException
     */
    Object primero() throws IndexOutOfBoundsException;

    /**
     * Devuelve el siguiente elemento de la lista.
     *
     * @return Siguiente elemento de la lista.
     * @throws IndexOutOfBoundsException
     */
    Object siguiente() throws IndexOutOfBoundsException;

    /**
     * Devuelve true si hay más elementos en la lista y false en caso contrario.
     *
     * @return true si hay más elementos en la lista, false en caso contrario.
     */
    boolean hayMas();

    /**
     * Devuelve el elemento actual de la lista.
     *
     * @return Primer elemento actual de la lista.
     * @throws IndexOutOfBoundsException
     */
    Object elementoActual() throws IndexOutOfBoundsException;
}

