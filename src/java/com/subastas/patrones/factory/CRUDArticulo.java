package com.subastas.patrones.factory;

import com.subastas.commons.Constantes;
import com.subastas.modelo.Articulo;
import com.subastas.patrones.builder.BuilderArte;
import com.subastas.patrones.builder.BuilderArticulo;
import com.subastas.patrones.builder.BuilderMobiliario;
import com.subastas.patrones.builder.BuilderNumismatica;
import com.subastas.patrones.builder.Director;
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
 * @author Grupo_12
 */
public class CRUDArticulo extends ICRUDGeneral<Articulo> {

    private final Connection conexion;

    public CRUDArticulo(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Articulo articulo) {
        String consultaArticulo = "INSERT INTO Articulos"
                + "(" + Constantes.NOMBRE + ", " + Constantes.DESCRIPCION + ", "
                + Constantes.ANIO + ", " + Constantes.ESTADO_CONSERVACION + ", "
                + Constantes.PRECIO + ", " + Constantes.CATEGORIA + ", " + Constantes.FOTO + ",dimensiones,procedencia,autor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(consultaArticulo)) {
            ps.setString(1, articulo.getNombre());
            ps.setString(2, articulo.getDescripcion());
            ps.setInt(3, articulo.getAnio());
            ps.setString(4, articulo.getEstado_conservacion());
            ps.setFloat(5, articulo.getPrecio());
            ps.setString(6, articulo.getCategoria());
            ps.setString(7, articulo.getFoto());
            ps.setString(8, articulo.getDimensiones());
            ps.setString(9, articulo.getProcedencia());
            ps.setString(10, articulo.getAutor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public void eliminar(String id_articulo) {
        String consulta = "DELETE FROM Articulos WHERE " + Constantes.ID_ARTICULO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id_articulo));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public void actualizar(Articulo articulo) {
        String consulta = "UPDATE Articulos "
                + "SET " + Constantes.NOMBRE + " = ?, " + Constantes.DESCRIPCION
                + " = ?, " + Constantes.ANIO + " = ?, " + Constantes.ESTADO_CONSERVACION
                + " = ?, " + Constantes.PRECIO + " = ?, " + Constantes.CATEGORIA
                + " = ?, " + Constantes.FOTO + " = ? "
                + "WHERE " + Constantes.ID_ARTICULO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, articulo.getNombre());
            ps.setString(2, articulo.getDescripcion());
            ps.setInt(3, articulo.getAnio());
            ps.setString(4, articulo.getEstado_conservacion());
            ps.setFloat(5, articulo.getPrecio());
            ps.setString(6, articulo.getCategoria());
            ps.setString(7, articulo.getFoto());
            ps.setInt(8, articulo.getId_articulo());
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public Articulo obtenerEspecifico(String lote) {
        Articulo articulo = null;
        String consulta = "SELECT * FROM Articulos WHERE " + Constantes.ID_ARTICULO + " = ?";

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
     * Genera un objeto procedente de los datos que devuelve la BBDD
     *
     * @param rs ResultSet con los datos
     * @return Objeto que contiene los datos
     */
    @Override
    public Articulo formatearResultado(ResultSet rs) {
        Articulo articulo = null;
        try {
            articulo = new Articulo(rs.getInt(Constantes.ID_ARTICULO),
                    rs.getString(Constantes.NOMBRE),
                    rs.getString(Constantes.DESCRIPCION),
                    rs.getInt(Constantes.ANIO),
                    rs.getString(Constantes.ESTADO_CONSERVACION),
                    
                    rs.getFloat(Constantes.PRECIO),
                    rs.getString("categoria"),
                    rs.getString(Constantes.FOTO),
                    rs.getString(Constantes.DIMENSIONES),
                    
                    rs.getString(Constantes.PROCEDENCIA),
                    rs.getString(Constantes.AUTOR));
      
            

      
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla ARTICULOS", ex);
        }
        return articulo;
    }
}
