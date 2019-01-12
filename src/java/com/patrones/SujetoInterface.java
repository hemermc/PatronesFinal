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
public interface SujetoInterface {
   public void setPuja(Puja v);
    
    public Puja getPuja();
    
    public void añadirObservador(Observador o);
    
    public void notificarObservadores();
}
