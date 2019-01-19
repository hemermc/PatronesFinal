package com.subastas.patrones.observer;

import com.subastas.modelo.Cliente;
import com.subastas.modelo.EnvioMail;
import com.subastas.modelo.Puja;
import lombok.Getter;

/**
 *
 * @author Grupo_12
 */
@Getter
public class Observador implements ObserverInterface {

    private final String nombre;
    private final Puja puja;
    private final Cliente cliente;
    private final Sujeto sujeto;
    private final EnvioMail singleMail;

    public Observador(String nombre, Puja puja, Cliente cliente, Sujeto sujeto) {
        this.nombre = nombre;
        this.puja = puja;
        this.cliente = cliente;
        this.sujeto = sujeto;
        this.singleMail = new EnvioMail();

        if (sujeto != null) {
            sujeto.anadirObservador(this);
        }
    }

    @Override
    public void actualizar() {
        if (!sujeto.getPuja().getNombre_usuario().equals(puja.getNombre_usuario())) {
            singleMail.envioSingleCorreo(cliente.getEmail());
        }
    }
}
