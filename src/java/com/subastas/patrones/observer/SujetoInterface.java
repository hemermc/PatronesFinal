/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.observer;

import com.subastas.patrones.observer.Observador;
import com.subastas.modelo.Puja;

/**
 *
 * @author amunguia
 */
public interface SujetoInterface {
   public void setPuja(Puja v);
    
    public Puja getPuja();
    
    public void añadirObservador(Observador o);
    
    public void notificarObservadores();
}
