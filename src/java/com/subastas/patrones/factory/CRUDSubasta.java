package com.subastas.patrones.factory;

import com.subastas.commons.Constantes;
import com.subastas.modelo.ExceptionManager;
import com.subastas.modelo.Subasta;
import com.subastas.patrones.adapter.AdapterFechaUSToES;
import com.subastas.patrones.adapter.FechaUS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo_12
 */
public class CRUDSubasta extends ICRUDGeneral<Subasta> {

    private final Connection conexion;

    public CRUDSubasta(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un registro en la tabla Subastas
     *
     * @param subasta
     * @throws ExceptionManager
     */
    @Override
    public void insertar(Subasta subasta) throws ExceptionManager {
        String consulta = "INSERT INTO Subastas(" + Constantes.NOMBRE + ", "
                + Constantes.PRECIO_INICIAL + ", " + Constantes.PRECIO_FINAL + ", "
                + Constantes.FECHA_ALTA + ", " + Constantes.FECHA_CIERRE + ", "
                + Constantes.ESTADO + ", " + Constantes.ID_ARTICULO + ") "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {

            AdapterFechaUSToES adapterAlta = new AdapterFechaUSToES(new FechaUS(subasta.getFecha_alta()));
            AdapterFechaUSToES adapterCierre = new AdapterFechaUSToES(new FechaUS(subasta.getFecha_cierre()));

            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecio_inicial());
            ps.setFloat(3, subasta.getPrecio_final());
            ps.setDate(4, adapterAlta.obtenerFechaDate());
            ps.setDate(5, adapterCierre.obtenerFechaDate());
            ps.setString(6, subasta.getEstado());
            ps.setInt(7, subasta.getId_articulo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }

    /**
     * Actualiza los datos de un registro de la tabla Subastas
     *
     * @param subasta contiene los datos que se van a actualizar
     * @throws ExceptionManager
     */
    @Override
    public void actualizar(Subasta subasta) throws ExceptionManager {

        AdapterFechaUSToES adapterAlta = new AdapterFechaUSToES(new FechaUS(subasta.getFecha_alta()));
        AdapterFechaUSToES adapterCierre = new AdapterFechaUSToES(new FechaUS(subasta.getFecha_cierre()));

        String consulta = "UPDATE Subastas SET " 
                + Constantes.NOMBRE + " = ?, "
                + Constantes.PRECIO_INICIAL + " = ?, "
                + Constantes.PRECIO_FINAL + " = ?, "
                + Constantes.FECHA_ALTA + " = ?, "
                + Constantes.FECHA_CIERRE + " = ?, "
                + Constantes.ESTADO + " = ?, "
                + Constantes.ID_ARTICULO + " = ? "
                + "WHERE " + Constantes.ID_SUBASTA + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecio_inicial());
            ps.setFloat(3, subasta.getPrecio_final());
            ps.setDate(4, adapterAlta.obtenerFechaDate());
            ps.setDate(5, adapterCierre.obtenerFechaDate());
            ps.setString(6, subasta.getEstado());
            ps.setInt(7, subasta.getId_articulo());
            ps.setInt(8, subasta.getId_subasta());

            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()+"\n").log(Level.SEVERE, "Error al actualizar un registro de la tabla SUBASTAS\n", ex);
        }
    }

    /**
     * Elimina un registro de la tabla Subastas
     *
     * @param id identificador del registro que se va a eliminar
     * @throws ExceptionManager
     */
    @Override
    public void eliminar(String id) throws ExceptionManager {
        String consulta = "DELETE FROM Subastas WHERE "
                + Constantes.ID_SUBASTA + " = ?";//Genera la consulta

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla SUBASTAS", ex);
        }
    }

    /**
     * Obtiene los datos de un registro por su id_subasta
     *
     * @param id identificador del registro que se quiere recuperar
     * @return
     * @throws ExceptionManager
     */
    @Override
    public Subasta obtenerEspecifico(String id) throws ExceptionManager {
        Subasta subasta = null;
        String consulta = "SELECT * FROM Subastas WHERE "
                + Constantes.ID_SUBASTA + " = ?";
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

    /**
     * Recupera todos los registros de la tabla Subastas
     *
     * @return lista con todos los registros de la tabla
     */
    @Override
    public ArrayList<Subasta> obtenerTodos() {
        ArrayList<Subasta> listaSubastas = new ArrayList<>();
        String consulta = "SELECT * FROM Subastas";

        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listaSubastas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla SUBASTAS", ex);
        }
        return listaSubastas;
    }

    /**
     * Recupera los registros de la tabla Subastas filtrando por la categoria de
     * la subasta y el estado "ACTIVA"
     *
     * @param categoria
     * @return
     */
    public ArrayList<Subasta> obtenerCategoria(String categoria) {
        ArrayList<Subasta> listaSubastas = new ArrayList<>();
        String consulta = "SELECT * FROM("
                + "SELECT " + Constantes.ID_ARTICULO + " "
                + "FROM Articulos "
                + "WHERE " + Constantes.CATEGORIA + " = ?)"
                + " as Resultado "
                + "NATURAL JOIN Subastas WHERE " + Constantes.ESTADO + " = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, categoria);
            ps.setString(2, "Activa");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaSubastas.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla SUBASTAS", ex);
        }

        return listaSubastas;
    }

    @Override
    public Subasta formatearResultado(ResultSet rs) throws SQLException {
        Subasta subasta = null;

        try {
            AdapterFechaUSToES adapterAlta = new AdapterFechaUSToES(new FechaUS(rs.getDate(Constantes.FECHA_ALTA).toString()));
            AdapterFechaUSToES adapterCierre = new AdapterFechaUSToES(new FechaUS(rs.getDate(Constantes.FECHA_CIERRE).toString()));

            subasta = new Subasta(
                    rs.getInt(Constantes.ID_SUBASTA),
                    rs.getString(Constantes.NOMBRE),
                    rs.getFloat(Constantes.PRECIO_INICIAL),
                    rs.getFloat(Constantes.PRECIO_FINAL),
                    adapterAlta.obtenerFechaString(),
                    adapterCierre.obtenerFechaString(),
                    rs.getString(Constantes.ESTADO),
                    rs.getInt(Constantes.ID_ARTICULO));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla SUBASTAS", ex);
        }
        return subasta;
    }

}
