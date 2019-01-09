/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class CRUDArticulo implements ICRUDGeneral<Articulo> {

    private final Connection conexion;
    private Integer idInsercion;

    public CRUDArticulo(Connection conexion) {
        this.conexion = conexion;
        idInsercion = null;
    }

    /*
    CAMPOS DE LA TABLA(Lote, valor, año, lugar de emisión, conservación, precio, <<foto>>)
     */
    @Override
    public void insertar(Articulo articulo) {
        String consultaArticulo = "INSERT INTO Articulos(valor, anio, lugar_emision, conservacion, precio, foto) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consultaArticulo)) {
            ps.setString(1, articulo.getValor());
            ps.setInt(2, articulo.getAnio());
            ps.setString(3, articulo.getLugar_emision());
            ps.setString(4, articulo.getConservacion());
            ps.setFloat(5, articulo.getPrecio());
            ps.setString(6, articulo.getFoto());
            ps.executeUpdate();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(lote) as lote FROM Articulos");
            if (rs.next()) {
                idInsercion = rs.getInt("lote");//Recupera el lote del ultimo articulo insertado
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla ARTICULOS", ex);
        }
    }

    public Integer getIdInsercion() {
        return idInsercion;
    }

    @Override
    public void eliminar(String lote) {
        String consulta = "DELETE FROM Articulos WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public void actualizar(Articulo articulo) {
        String consulta = "UPDATE Articulos SET valor = ?, anio = ?, lugar_emision = ?, conservacion = ?, precio = ?, foto = ? WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, articulo.getValor());
            ps.setInt(2, articulo.getAnio());
            ps.setString(3, articulo.getLugar_emision());
            ps.setString(4, articulo.getConservacion());
            ps.setFloat(5, articulo.getPrecio());
            ps.setString(6, articulo.getFoto());
            ps.setInt(7, articulo.getLote());//Lote especificado
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public Articulo obtenerEspecifico(String lote) {
        Articulo articulo = null;
        String consulta = "SELECT * FROM Articulos WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    articulo = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla ARTICULOS", ex);
        }
        return articulo;
    }

    @Override
    public List<Articulo> obtenerTodos() {
        ArrayList<Articulo> listaArticulos = null;
        String consulta = "SELECT * FROM Articulos";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaArticulos = new ArrayList<>();
            while (rs.next()) {
                listaArticulos.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla ARTICULOS", ex);
        }
        return listaArticulos;
    }

    /**
     * Genera un objeto procedente de los datos que devuelve la BBDD.
     *
     * @param rs ResultSet con los datos.
     * @return Objeto que contiene los datos.
     */
    @Override
    public Articulo formatearResultado(ResultSet rs) {
        Articulo articulo = null;
        try {
            articulo = new Articulo(
                    rs.getInt("lote"),
                    rs.getString("valor"),
                    rs.getInt("anio"),
                    rs.getString("lugar_emision"),
                    rs.getString("conservacion"),
                    rs.getFloat("precio"),
                    rs.getString("foto"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla ARTICULOS", ex);
        }
        return articulo;
    }
}
