/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Billete;
import com.multimedia.modelo.FormateaFecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class CRUDBillete implements ICRUDGeneral<Billete> {

    private final Connection conexion;
    private final CRUDArticulo articulo;

    public CRUDBillete(Connection conexion) {
        this.conexion = conexion;
        articulo = new CRUDArticulo(conexion);
    }

    /*
    CAMPOS DE LA TABLA(Lote, valor, año, lugar de emisión, fecha, serie, conservación, precio, <<foto>>)
     */
    @Override
    public void insertar(Billete billete) {
        //Cast, solo entrarán billetes
        articulo.insertar(billete);
        String consulta = "INSERT INTO Billetes(lote, fecha, serie) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, articulo.getIdInsercion());
            ps.setDate(2, FormateaFecha.comoDate(billete.getFecha()));
            ps.setString(3, billete.getSerie());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public void eliminar(String lote) {
        articulo.eliminar(lote);
        String consulta = "DELETE FROM Billetes WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public void actualizar(Billete billete) {
        articulo.actualizar(billete);
        String consulta = "UPDATE Billetes SET fecha = ?, serie = ? WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setDate(1, FormateaFecha.comoDate(billete.getFecha()));
            ps.setString(2, billete.getSerie());
            ps.setInt(3, billete.getLote());//Lote especificado
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public Billete obtenerEspecifico(String lote) {
        Billete billete = null;
        String consulta = "SELECT * FROM Billetes INNER JOIN Articulos ON Billetes.lote = Articulos.Lote WHERE Billetes.lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    billete = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla BILLETES", ex);
        }
        return billete;
    }

    @Override
    public ArrayList<Billete> obtenerTodos() {
        ArrayList<Billete> listaBilletes = null;
        String consulta = "SELECT * FROM Articulos T1 INNER JOIN Billetes T2 ON T1.lote = T2.lote";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaBilletes = new ArrayList<>();
            while (rs.next()) {
                listaBilletes.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla BILLETES", ex);
        }
        return listaBilletes;
    }

    /**
     * Genera un objeto procedente de los datos que devuelve la BBDD.
     *
     * @param rs ResultSet con los datos.
     * @return Objeto que contiene los datos.
     */
    @Override
    public Billete formatearResultado(ResultSet rs) {
        Billete billete = null;
        try {
            billete = new Billete(
                    rs.getInt("lote"),
                    rs.getString("valor"),
                    rs.getInt("anio"),
                    rs.getString("lugar_emision"),
                    FormateaFecha.comoLocalDate(rs.getDate("fecha")),
                    rs.getString("serie"),
                    rs.getString("conservacion"),
                    rs.getFloat("precio"),
                    rs.getString("foto"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla BILLETES", ex);
        }
        return billete;
    }
    
}

