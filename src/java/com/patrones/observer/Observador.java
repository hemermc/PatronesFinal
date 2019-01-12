/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patrones.observer;

import com.multimedia.modelo.Cliente;
import com.multimedia.modelo.EnvioMail;
import com.multimedia.modelo.Puja;

/**
 *
 * @author amunguia
 */
public class Observador implements ObserverInterface {

    private String nombre;
    private Puja puja; 
    private Cliente cli;
    private Sujeto sujeto;
    private EnvioMail singleMail = new EnvioMail();
    
    public Observador(String nombre, Puja puja,Cliente cli, Sujeto sujeto) {
        this.nombre = nombre;
        this.puja = puja;
        this.cli = cli;
        this.sujeto = sujeto;
        sujeto.añadirObservador(this);
    }

    @Override
    public void actualizar() {
       if(sujeto.getPuja().getNombre_usuario() != puja.getNombre_usuario()){
           singleMail.envioSingleCorreo(cli.getEmail());
       }
        
    }
}

