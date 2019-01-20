package com.subastas.patrones.observer;

import com.subastas.modelo.Puja;

/**
 *
 * @author Grupo_12
 */
public interface SujetoInterface {

    public void setPuja(Puja puja);

    public Puja getPuja();

    public void anadirObservador(Observador observador);

    public void notificarObservadores();
}
