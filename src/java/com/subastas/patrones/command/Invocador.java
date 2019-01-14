
package com.subastas.patrones.command;

import java.sql.Connection;

/**
 *
 * @author Grupo_12
 */

public class Invocador {

    //Comando al que le pediremos que ejecute la petición
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
     * @return Connection Conexion con la BBDD
     */
    public Connection ejecutaComando() {
        return comando.ejecutar();
    }
}
