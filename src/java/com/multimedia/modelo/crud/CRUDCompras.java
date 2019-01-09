/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Compras;
import com.multimedia.modelo.ExceptionManager;
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
public abstract class CRUDCompras implements ICRUDGeneral<Compras>{
    private final Connection conexion;
    
    
     public CRUDCompras(Connection conexion) {
        this.conexion = conexion;
    }
     
    @Override   
    public void insertar(Compras compras) throws ExceptionManager {
       
        String consulta = "INSERT INTO Compras(id_compra, importe, id_subasta, nombre_usuario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, compras.getId_compra());
            ps.setFloat(2, compras.getImporte());
            ps.setInt(3, compras.getId_subasta());
            ps.setString(4, compras.getNombre_usuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla COMPRAS", ex);
        }
    }
    

    public void eliminar(Integer id_compra) {
        String consulta = "DELETE FROM Compras WHERE id_compra = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, id_compra);
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla COMPRAS", ex);
        }
    }

    @Override
    public void actualizar(Compras compras) throws ExceptionManager {
        String consulta = "UPDATE Compras SET importe = ?, id_subasta = ?, nombre_usuario = ? WHERE id_compra = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setFloat(1, compras.getImporte());
            ps.setInt(2, compras.getId_subasta());
            ps.setString(3, compras.getNombre_usuario());
            ps.setInt(4, compras.getId_compra());
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla COMPRAS", ex);
        }
    }

    @Override
    public Compras obtenerEspecifico(String id_compra) throws ExceptionManager {
        Compras compra = null;
        String consulta = "SELECT * FROM Compras WHERE id_compra = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id_compra));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    compra = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla COMPRAS", ex);
        }
        return compra;
    }

    @Override
    public ArrayList<Compras> obtenerTodos()  {
         ArrayList<Compras> listaCompras = null;
        String consulta = "SELECT * FROM Compras";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaCompras = new ArrayList<>();
            while (rs.next()) {
                listaCompras.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla COMPRAS", ex);
        }
        return listaCompras;
    }

    @Override
    public Compras formatearResultado(ResultSet rs) throws SQLException {
Compras compra = null;
        try {
            
            compra = new Compras(
            rs.getInt("id_compra"),
            rs.getFloat("importe"),
            rs.getInt("id_subasta"),
            rs.getString("nombre_usuario"));
        
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla COMPRAS", ex);
        }
        return compra;
    }    
}

