
package com.subastas.modelo;

import com.subastas.patrones.command.ComandoConectar;
import com.subastas.patrones.command.ComandoInterface;
import com.subastas.patrones.command.Invocador;
import java.sql.Connection;

/**
 *
 * @author Grupo_12
 */
public class GestionBBDD implements IConexion<Connection>{

    private static GestionBBDD firstInstance = null; //Singleton
    private Connection conexion;

    private GestionBBDD() {
    }

    public static GestionBBDD getInstance() {
        if (firstInstance == null) {
            firstInstance = new GestionBBDD();
        }
        return firstInstance;
    }

    @Override
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

    @Override
    public void cerrarConexion() {
        /*try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}

