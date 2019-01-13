/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subastas.patrones.command;

import com.subastas.modelo.GestionBBDDLocalhost;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class ComandoConectar  implements ComandoInterface{
    @Override
    public Connection ejecutar() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String urlConexion = "jdbc:mysql://mysqlpatrones.cve0d1ffdtii.eu-west-3.rds.amazonaws.com:3306/mydb";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(urlConexion,"patrones2018","patrones2018");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionBBDDLocalhost.class.getName()).log(Level.SEVERE, "Error al conectar con la BBDD", ex);
        }
        return con;
    }
}
