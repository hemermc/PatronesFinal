
package com.multimedia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo_12
 */
public class GestionBBDDLocalhost {

    private static GestionBBDDLocalhost firstInstance = null; //Singleton
    private final String driver;
    private final String urlConexion;
    private Connection conexion;

    private GestionBBDDLocalhost() {
        driver = "com.mysql.cj.jdbc.Driver";
        urlConexion = "jdbc:mysql://mysqlpatrones.cve0d1ffdtii.eu-west-3.rds.amazonaws.com:3306/mydb";
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
            conexion = DriverManager.getConnection(urlConexion,"patrones2018","patrones2018");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionBBDDLocalhost.class.getName()).log(Level.SEVERE, "Error al conectar con la BBDD", ex);
        }
        return conexion;
    }

    public void cerrarBBDD() {
        /*try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBBDDLocalhost.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}

