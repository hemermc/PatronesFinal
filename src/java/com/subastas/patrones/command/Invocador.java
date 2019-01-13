/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.command;

import java.sql.Connection;

/**
 *
 * @author amunguia
 */

public class Invocador {

    //Comando al que le pediremos que ejecute la petición.
    private ComandoInterface comando;

    /**
     * Establece el comando.
     *
     * @param comando
     */
    public void setComando(ComandoInterface comando) {
        this.comando = comando;
    }

    /**
     * Ejecuta el comando.
     *
     * @param param
     */
    public Connection ejecutaComando() {
        return comando.ejecutar();
    }
}
