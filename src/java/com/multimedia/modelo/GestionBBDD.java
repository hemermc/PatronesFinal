/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource;
/**
 *
 * @author amunguia
 */
public class GestionBBDD {

    private static GestionBBDD firstInstance = null; //Singleton
    private static String dbRuta;
    private static MiniConnectionPoolManager poolMgr;

    private GestionBBDD() {
        dbRuta = "/finalPatrones";
        EmbeddedConnectionPoolDataSource dataSource = new EmbeddedConnectionPoolDataSource();
        dataSource.setDatabaseName(dbRuta);
        dataSource.setCreateDatabase("create");
        poolMgr = new MiniConnectionPoolManager(dataSource, 10);
    }
    
    public static GestionBBDD getInstance() {
        if (firstInstance == null) {
            firstInstance = new GestionBBDD();
        }
        return firstInstance;
    }

    public Connection establecerConexion() throws SQLException {
        return poolMgr.getConnection();
    }

    public MiniConnectionPoolManager getManager() {
        return poolMgr;
    }

    public void crearBaseDatos() {
        try (Connection conexion = poolMgr.getConnection()) {
            try (Statement st = conexion.createStatement()) {
                String crearTablaAdministradores = "CREATE TABLE Administradores ("
                        + "nombre_usuario Varchar(25) NOT NULL CONSTRAINT administradores_pk PRIMARY KEY,"
                        + "clave Varchar(25) NOT NULL,"
                        + "email Varchar(25) NOT NULL,"
                        + "nivel_permisos Integer NOT NULL)";

                String crearTablaClientes = "CREATE TABLE Clientes ("
                        + "nombre_usuario Varchar(25) NOT NULL CONSTRAINT clientes_pk PRIMARY KEY,"
                        + "clave Varchar(25) NOT NULL,"
                        + "email Varchar(25) NOT NULL,"
                        + "nombre Varchar(25) NOT NULL,"
                        + "apellidos Varchar(25) NOT NULL,"
                        + "dni Varchar(9) NOT NULL UNIQUE,"
                        + "direccion_entrega Varchar(25) NOT NULL,"
                        + "telefono Integer NOT NULL)";

                String crearTablaArticulos = "CREATE TABLE Articulos ("
                        + "lote Integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT articulos_pk PRIMARY KEY,"
                        + "valor Numeric(12,2) NOT NULL,"
                        + "anio Varchar(4) NOT NULL,"
                        + "lugar_emision Varchar(20) NOT NULL,"
                        + "conservacion Varchar(5) NOT NULL,"
                        + "precio Numeric(7,2) NOT NULL,"
                        + "foto Varchar(35) NOT NULL)";

                String crearTablaBilletes = "CREATE TABLE Billetes ("
                        + "fecha Varchar(6) NOT NULL,"
                        + "serie Varchar(25) NOT NULL,"
                        + "lote Integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL CONSTRAINT billetes_pk PRIMARY KEY)";

                String crearTablaMonedas = "CREATE TABLE Monedas ("
                        + "estrellas Varchar(5) NOT NULL,"
                        + "lote Integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT monedas_pk PRIMARY KEY)";                 

                String crearTablaSubastas = "CREATE TABLE Subastas ("
                        + "id_subasta Integer NOT NULL CONSTRAINT subastas_pk PRIMARY KEY,"
                        + "precio_inicial Numeric(12,2) NOT NULL,"
                        + "precio_final Numeric(12,2) NOT NULL,"
                        + "activa Boolean NOT NULL,"
                        + "fecha Varchar(6) NOT NULL,"
                        + "lote Integer NOT NULL)";

                String crearTablaPujas = "CREATE TABLE Pujas ("
                        + "id_subasta Integer NOT NULL,"
                        + "nombre_usuario Varchar(25) NOT NULL,"
                        + "cantidad Numeric(10,2) NOT NULL,"
                        + "ganada Boolean NOT NULL,"
                        + "primary key (id_subasta, nombre_usuario))";

                String crearTablaCompras = "CREATE TABLE Compras ("
                        + "id_compra Integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "importe Numeric(10,2) NOT NULL,"
                        + "id_subasta Integer NOT NULL,"
                        + "nombre_usuario Varchar(25) NOT NULL)";
                
                st.execute(crearTablaAdministradores);
                st.execute(crearTablaClientes);
                st.execute(crearTablaArticulos);
                st.execute(crearTablaBilletes);
                st.execute(crearTablaMonedas);
                st.execute(crearTablaCompras);
                st.execute(crearTablaPujas);
                st.execute(crearTablaSubastas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionBBDD.class.getName()).log(Level.SEVERE, "ERROR al crear la BBDD", ex);
        } 
    }

    public void cerrarBBDD() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
