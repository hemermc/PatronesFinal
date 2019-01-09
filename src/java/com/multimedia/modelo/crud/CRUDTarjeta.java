/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.ExceptionManager;
import com.multimedia.modelo.Tarjeta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class CRUDTarjeta implements ICRUDGeneral<Tarjeta> {

    private final Connection conexion;

    public CRUDTarjeta(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Tarjeta tarjeta) throws ExceptionManager {
          String consulta = "INSERT INTO TARJETAS_DE_CREDITO (NUMERO_TARJETA, NOMBRE_USUARIO, Tipo, Titular, Mes_Caducidad, Anio_Caducidad) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, tarjeta.getNumero());
            ps.setString(2, tarjeta.getNombre());
            ps.setString(3, tarjeta.getTipo());
            ps.setString(4, tarjeta.getTitular());
            ps.setInt(5, tarjeta.getMes());
            ps.setInt(6, tarjeta.getAno());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }


    @Override
    public void eliminar(String id) throws ExceptionManager {
     String consulta = " DELETE FROM TARJETAS_DE_CREDITO WHERE numero = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }

    @Override
    public void actualizar(Tarjeta tarjeta) throws ExceptionManager {
         String consulta = "UPDATE TARJETAS_DE_CREDITO SET NOMBRE_USUARIO = ?, Tipo=?, Titular=?, Mes_Caducidad=?, Anio_Caducidad=? WHERE NUMERO_TARJETA = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, tarjeta.getNombre());
            ps.setString(2, tarjeta.getTipo());
            ps.setString(3, tarjeta.getTitular());
            ps.setInt(4, tarjeta.getMes());
            ps.setInt(5, tarjeta.getAno());
            ps.setInt(6, tarjeta.getNumero());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }

    @Override
    public Tarjeta obtenerEspecifico(String id) throws ExceptionManager {
         Tarjeta tarjeta = null;
        String consulta = "SELECT * FROM TARJETAS_DE_CREDITO WHERE NUMERO_TARJETA = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   tarjeta= formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla BILLETES", ex);
        }
        return tarjeta;
    }

    @Override
    public List<Tarjeta> obtenerTodos() throws ExceptionManager {
        ArrayList<Tarjeta> listaTarjetas = null;
        String consulta = "SELECT * FROM TARJETAS_DE_CREDITO";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaTarjetas = new ArrayList<>();
            while (rs.next()) {
                listaTarjetas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla BILLETES", ex);
        }
        return listaTarjetas;
    }

    @Override
    public Tarjeta formatearResultado(ResultSet rs) throws SQLException {
       Tarjeta tarjeta = null;
        try {
            tarjeta= new Tarjeta(
                    rs.getInt("numero"),
                    rs.getString("nombre"),
                    rs.getInt("mes_caducidad"),
                    rs.getInt("anio_caducidad"),
                    rs.getString("tipo"),
                    rs.getString("titular")
                    
                    );
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla BILLETES", ex);
        }
        return tarjeta;
    }
}
