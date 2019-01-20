/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.strategy;

import com.subastas.modelo.Subasta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author alexandermunguiaclemente
 */
public class EstrategiaConcretaReciente implements Estrategia {

    @Override
    public void ordena(ArrayList<Subasta> subastas) {
        //Comparador para ordenar los alumnos por su nombre
        Comparator ReciComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Subasta sub1 = (Subasta) o1;
                Subasta sub2 = (Subasta) o2;

                return sub1.getFecha_alta().compareTo(sub2.getFecha_alta());
            }
        };

        //Ordenamos los objetos del array por el atributo nombre
        Collections.sort(subastas, ReciComp);
    }

}

