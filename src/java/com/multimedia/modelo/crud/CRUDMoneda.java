/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Moneda;
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
public class CRUDMoneda implements ICRUDGeneral<Moneda> {

    private final Connection conexion;
    private final CRUDArticulo articulo;
    
    public CRUDMoneda(Connection conexion) {
        this.conexion = conexion;
        articulo = new CRUDArticulo(conexion);
    }

    @Override
    public void insertar(Moneda moneda) {
        articulo.insertar(moneda);
        String consulta = "INSERT INTO Monedas(lote, estrellas) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, articulo.getIdInsercion());
            ps.setString(2, moneda.getEstrellas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public void eliminar(String lote) {
        articulo.eliminar(lote);
        String consulta = "DELETE FROM Monedas WHERE lote = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public void actualizar(Moneda moneda) {
        articulo.actualizar(moneda);
        String consulta = "UPDATE Monedas SET estrellas = ? WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, moneda.getEstrellas());
            ps.setInt(2, moneda.getLote());//Lote especificado
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public Moneda obtenerEspecifico(String lote) {
        Moneda moneda = null;
        String consulta = "SELECT * FROM Monedas INNER JOIN ARTICULOS ON Monedas.lote = Articulos.Lote WHERE Monedas.lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    moneda = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla MONEDAS", ex);
        }
        return moneda;
    }

    @Override
    public ArrayList<Moneda> obtenerTodos() {
        ArrayList<Moneda> listaMonedas = null;
        String consulta = "SELECT * FROM Articulos T1 INNER JOIN Monedas T2 ON T1.lote = T2.lote";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaMonedas = new ArrayList<>();
            while (rs.next()) {
                listaMonedas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla MONEDAS", ex);
        }
        return listaMonedas;
    }

    @Override
    public Moneda formatearResultado(ResultSet rs) {
        Moneda moneda = null;
        try {
            moneda = new Moneda(
                    rs.getInt("lote"),
                    rs.getString("valor"),
                    rs.getInt("anio"),
                    rs.getString("estrellas"),
                    rs.getString("lugar_emision"),
                    rs.getString("conservacion"),
                    rs.getFloat("precio"),
                    rs.getString("foto"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla MONEDAS", ex);
        }
        return moneda;
    }

}

