/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.ExceptionManager;
import com.multimedia.modelo.FormateaFecha;
import com.multimedia.modelo.Subasta;
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
public class CRUDSubasta implements ICRUDGeneral<Subasta> {

    private final Connection conexion;

    public CRUDSubasta(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Subasta subasta) throws ExceptionManager {

        String consulta = "INSERT INTO Subastas(nombre, precio_inicial, precio_final, fecha, activa, lote) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecioInicial());
            ps.setFloat(3, subasta.getPrecioFinal());
            ps.setDate(4, FormateaFecha.comoDate(subasta.getFecha()));
            ps.setBoolean(5, subasta.isActiva());
            ps.setInt(6, subasta.getLote());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }

    @Override
    public void actualizar(Subasta subasta) throws ExceptionManager {
        String consulta = "UPDATE Subastas SET nombre = ?, precio_Inicial = ?, precio_Final = ?, fecha = ?, activa = ? WHERE id_subasta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecioInicial());
            ps.setFloat(3, subasta.getPrecioFinal());
            ps.setDate(4, FormateaFecha.comoDate(subasta.getFecha()));
            ps.setBoolean(5, subasta.isActiva());
            ps.setInt(6, subasta.getId_subasta());

            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla SUBASTAS", ex);
        }
    }

    @Override
    public void eliminar(String id) throws ExceptionManager {

        String consulta = "DELETE FROM Subastas WHERE id_subasta = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla SUBASTAS", ex);
        }
    }

    @Override
    public Subasta obtenerEspecifico(String id) throws ExceptionManager {
        Subasta subasta = null;
        String consulta = "SELECT * FROM Subastas WHERE id_subasta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    subasta = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla SUBASTAS", ex);
        }
        return subasta;
    }

    @Override
    public ArrayList<Subasta> obtenerTodos() {
        ArrayList<Subasta> listaSubastas = null;
        String consulta = "SELECT * FROM Subastas";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaSubastas = new ArrayList<>();
            while (rs.next()) {
                listaSubastas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla SUBASTAS", ex);
        }
        return listaSubastas;
    }

    public ArrayList obtenerTipo(String tipo) {
        ArrayList<Object> listaTipo = new ArrayList<>();
        String consulta = null;
        if (tipo.equalsIgnoreCase("Monedas")) {
            consulta = "SELECT * FROM Monedas INNER JOIN Articulos"
                    + " ON Monedas.lote = Articulos.lote"
                    + " INNER JOIN Subastas"
                    + " ON Monedas.lote = Subastas.lote"
                    + " WHERE Subastas.activa = true";
        } else if (tipo.equalsIgnoreCase("Billetes")) {
            consulta = "SELECT * FROM Billetes INNER JOIN Articulos"
                    + " ON Billetes.lote = Articulos.lote"
                    + " INNER JOIN Subastas"
                    + " ON Billetes.lote = Subastas.lote"
                    + " WHERE Subastas.activa = true";
        }
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaTipo.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla SUBASTAS", ex);
        }
        return listaTipo;
    }

    @Override
    public Subasta formatearResultado(ResultSet rs) throws SQLException {
        Subasta subasta = null;
        try {
            subasta = new Subasta(
                    rs.getInt("id_subasta"),
                    rs.getString("nombre"),
                    rs.getFloat("precio_inicial"),
                    rs.getFloat("precio_final"),
                    FormateaFecha.comoLocalDate(rs.getDate("fecha")),
                    rs.getBoolean("activa"),
                    rs.getInt("lote"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla SUBASTAS", ex);
        }
        return subasta;
    }

}

