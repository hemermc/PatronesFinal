/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patrones;

import com.multimedia.modelo.Puja;

/**
 *
 * @author amunguia
 */
public class Sujeto implements SujetoInterface{
    // Lista de observadores de un valor.
    private Observador observador;
    //Valor monitorizado.
    private Puja puja;
    @Override
    public void setPuja(Puja v) {
        this.puja = v;
    }

    @Override
    public Puja getPuja() {
         return this.puja;
    }

    @Override
    public void añadirObservador(Observador o) {
        this.observador = o;
    }

    @Override
    public void notificarObservadores() {
        observador.actualizar();
    }
    
}
