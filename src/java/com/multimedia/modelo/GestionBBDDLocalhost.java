/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class GestionBBDDLocalhost {

    private static GestionBBDDLocalhost firstInstance = null; //Singleton
    private final String driver;
    private final String urlConexion;
    private Connection conexion;

    private GestionBBDDLocalhost() {
        driver = "org.apache.derby.jdbc.ClientDriver";
        urlConexion = "jdbc:derby://localhost:1527/finalPatrones";
        conexion = null;
    }

    public static GestionBBDDLocalhost getInstance() {
        if (firstInstance == null) {
            firstInstance = new GestionBBDDLocalhost();
        }
        return firstInstance;
    }

    public Connection establecerConexion() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(urlConexion,"","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionBBDDLocalhost.class.getName()).log(Level.SEVERE, "Error al conectar con la BBDD", ex);
        }
        return conexion;
    }

    public void cerrarBBDD() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBBDDLocalhost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

