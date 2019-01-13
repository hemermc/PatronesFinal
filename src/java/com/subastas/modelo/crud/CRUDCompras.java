package com.subastas.modelo.crud;

import com.subastas.commons.Constantes;
import com.subastas.modelo.Compras;
import com.subastas.modelo.ExceptionManager;
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
public abstract class CRUDCompras implements ICRUDGeneral<Compras> {

    private final Connection conexion;

    public CRUDCompras(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Compras compras) throws ExceptionManager {

        String consulta = "INSERT INTO Compras"
                + "(" + Constantes.ID_COMPRA + ", " + Constantes.IMPORTE + ", "
                + Constantes.ID_SUBASTA + ", " + Constantes.NOMBRE_USUARIO + ") "
                + "VALUES (?, ?, ?, ?)";
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
        String consulta = "DELETE FROM Compras WHERE " + Constantes.ID_COMPRA + " = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, id_compra);
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla COMPRAS", ex);
        }
    }

    @Override
    public void actualizar(Compras compras) throws ExceptionManager {
        String consulta = "UPDATE Compras "
                + "SET " + Constantes.IMPORTE + " = ?, " + Constantes.ID_SUBASTA + " = ?, " + Constantes.NOMBRE_USUARIO + " = ? "
                + "WHERE id_compra = ?";
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
        String consulta = "SELECT * FROM Compras WHERE " + Constantes.ID_COMPRA + " = ?";
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
    public ArrayList<Compras> obtenerTodos() {
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
                    rs.getInt(Constantes.ID_COMPRA),
                    rs.getFloat(Constantes.IMPORTE),
                    rs.getInt(Constantes.ID_SUBASTA),
                    rs.getString(Constantes.NOMBRE_USUARIO));

        } catch (SQLException ex) {
            Logger.getLogger(CRUDCompras.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla COMPRAS", ex);
        }
        return compra;
    }
}
