
package com.subastas.patrones.command;

import com.subastas.modelo.GestionBBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo_12
 */
public class ComandoConectar  implements ComandoInterface{
    @Override
    public Connection ejecutar() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String urlConexion = "jdbc:mysql://mysqlpatrones.cve0d1ffdtii.eu-west-3.rds.amazonaws.com:3306/mydb";
        Connection conexion = null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(urlConexion,"patrones2018","patrones2018");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionBBDD.class.getName()).log(Level.SEVERE, "Error al conectar con la BBDD", ex);
        }
        return conexion;
    }
}
