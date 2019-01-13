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
public interface ComandoInterface {
    public void setConexion(Connection conexion);

    /**
     *
     * @return
     */
    public Connection getConexion();
    /**
     * Método con las acciones a realizar.
     *
     * @return conexion
     */
    
    public Connection ejecutar();  
}
