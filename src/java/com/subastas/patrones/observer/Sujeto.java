package com.subastas.patrones.observer;

import com.subastas.modelo.Puja;

/**
 *
 * @author Grupo_12
 */
public class Sujeto implements SujetoInterface {

    private Observador observador;// Lista de observadores de un objeto
    private Puja puja;//Objeto monitorizado

    @Override
    public void setPuja(Puja puja) {
        this.puja = puja;
    }

    @Override
    public Puja getPuja() {
        return this.puja;
    }

    @Override
    public void anadirObservador(Observador observador) {
        this.observador = observador;
    }

    @Override
    public void notificarObservadores() {
        observador.actualizar();
    }

}
