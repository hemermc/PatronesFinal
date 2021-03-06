package com.subastas.patrones.factory;

import com.subastas.commons.Constantes;
import com.subastas.modelo.ExceptionManager;
import com.subastas.modelo.Puja;
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
public class CRUDPujas  extends ICRUDGeneral<Puja> {

    private final Connection conexion;

    public CRUDPujas(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Puja puja) throws ExceptionManager {

        String consulta = "INSERT INTO Pujas VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, puja.getId_subasta());
            ps.setString(2, puja.getNombre_usuario());
            ps.setFloat(3, puja.getCantidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla PUJAS", ex);
        }
    }

    public void eliminar(String id_subasta, String nombre_usuario) {
        String consulta = "DELETE FROM Pujas WHERE " + Constantes.ID_SUBASTA + " = ? AND " + Constantes.NOMBRE_USUARIO + " = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id_subasta));
            ps.setString(2, nombre_usuario);
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla PUJAS", ex);
        }
    }

    @Override
    public void actualizar(Puja puja) throws ExceptionManager {
        String consulta = "UPDATE Pujas SET " + Constantes.CANTIDAD
                + " = ? WHERE " + Constantes.ID_SUBASTA + " = ? AND "
                + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setFloat(1, puja.getCantidad());
            ps.setInt(2, puja.getId_subasta());
            ps.setString(3, puja.getNombre_usuario());
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla PUJAS", ex);
        }
    }

    public Puja obtenerEspecifico(String id_subasta, String nombre_usuario) throws ExceptionManager {
        Puja puja = null;
        String consulta = "SELECT * FROM Pujas WHERE " + Constantes.ID_SUBASTA
                + " = ? AND " + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id_subasta));
            ps.setString(2, nombre_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    puja = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla PUJAS", ex);
        }
        return puja;
    }

    public ArrayList<Puja> obtenerPujasSubasta(String id_subasta) throws ExceptionManager {
        ArrayList<Puja> listaPujas = new ArrayList<>();
        String consulta = "SELECT * FROM Pujas WHERE " + Constantes.ID_SUBASTA + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, id_subasta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaPujas.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla PUJAS", ex);
        }
        return listaPujas;
    }

    public ArrayList<Puja> obtenerPujasGanadorasCliente(String nombre_usuario) throws ExceptionManager {
        ArrayList<Puja> listaPujas = new ArrayList<>();
        String consulta = "SELECT Pujas.* FROM Pujas INNER JOIN Clientes ON Pujas."
                + Constantes.NOMBRE_USUARIO + " = Clientes." + Constantes.NOMBRE_USUARIO + " "
                + " INNER JOIN Subastas "
                + " ON Pujas." + Constantes.ID_SUBASTA + " = Subastas." + Constantes.ID_SUBASTA + " "
                + " WHERE Subastas." + Constantes.PRECIO_FINAL + " = Pujas." + Constantes.CANTIDAD
                + " AND Clientes." + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nombre_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaPujas.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla PUJAS", ex);
        }
        return listaPujas;
    }

    public ArrayList<Puja> obtenerPujasPerdedorasCliente(String nombre_usuario) throws ExceptionManager {
        ArrayList<Puja> listaPujas = new ArrayList<>();
        String consulta = "SELECT Pujas.* FROM Pujas INNER JOIN Clientes "
                + " ON Pujas." + Constantes.NOMBRE_USUARIO + " = Clientes."
                + Constantes.NOMBRE_USUARIO + " "
                + " INNER JOIN Subastas "
                + " ON Pujas." + Constantes.ID_SUBASTA + " = Subastas."
                + Constantes.ID_SUBASTA + " "
                + " WHERE Subastas." + Constantes.PRECIO_FINAL + " <> Pujas."
                + Constantes.CANTIDAD + " AND Clientes." + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nombre_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaPujas.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla PUJAS", ex);
        }
        return listaPujas;
    }

    @Override
    public ArrayList<Puja> obtenerTodos() {
        ArrayList<Puja> listaPujas = null;
        String consulta = "SELECT * FROM Pujas";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaPujas = new ArrayList<>();
            while (rs.next()) {
                listaPujas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla PUJAS", ex);
        }
        return listaPujas;
    }

    @Override
    public Puja formatearResultado(ResultSet rs) throws SQLException {
        Puja puja = null;
        try {
            puja = new Puja(
                    rs.getInt(Constantes.ID_SUBASTA),
                    rs.getString(Constantes.NOMBRE_USUARIO),
                    rs.getInt(Constantes.CANTIDAD));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPujas.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla PUJAS", ex);
        }
        return puja;
    }

    @Override
    public void eliminar(String id) throws ExceptionManager {
    }

    @Override
    public Puja obtenerEspecifico(String id) throws ExceptionManager {
        return null;
    }
}
