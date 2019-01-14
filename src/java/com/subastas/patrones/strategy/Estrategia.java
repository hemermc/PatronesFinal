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
public interface Estrategia {

    /**
     * Ordena lista de alumnos pasada como argumento
     *
     * @param alumnos Lista de alumnos
     */
    public void ordena(ArrayList<Subasta> subastas);
}