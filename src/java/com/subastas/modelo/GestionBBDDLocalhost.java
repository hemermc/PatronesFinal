
package com.subastas.modelo;

import com.subastas.patrones.command.ComandoConectar;
import com.subastas.patrones.command.ComandoInterface;
import com.subastas.patrones.command.Invocador;
import java.sql.Connection;

/**
 *
 * @author Grupo_12
 */
public class GestionBBDDLocalhost {

    private static GestionBBDDLocalhost firstInstance = null; //Singleton
    private Connection conexion;

    private GestionBBDDLocalhost() {
    }

    public static GestionBBDDLocalhost getInstance() {
        if (firstInstance == null) {
            firstInstance = new GestionBBDDLocalhost();
        }
        return firstInstance;
    }

    public Connection establecerConexion() {
       conexion = null;
       try {
            
            ComandoInterface comando = new ComandoConectar();
            // Invocador
            Invocador inv = new Invocador();
            // Establece y ejecuta el comando
            inv.setComando(comando);
            conexion = inv.ejecutaComando();
            
        } catch (Exception e) {
            System.out.println(e.toString());
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

