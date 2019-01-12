
package com.multimedia.modelo.crud;

import com.multimedia.modelo.ExceptionManager;
import com.multimedia.modelo.TarjetaCredito;
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
public class CRUDTarjeta implements ICRUDGeneral<TarjetaCredito> {

    private final Connection conexion;

    public CRUDTarjeta(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(TarjetaCredito tarjeta) throws ExceptionManager {
        String consulta = "INSERT INTO Tarjetas_de_Credito "
                + "(numero_tarjeta, nombre_usuario, tipo, titular, mes_caducidad, anio_caducidad) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, tarjeta.getNumero_tarjeta());
            ps.setString(2, tarjeta.getNombre_usuario());
            ps.setString(3, tarjeta.getTipo());
            ps.setString(4, tarjeta.getTitular());
            ps.setInt(5, tarjeta.getMes_caducidad());
            ps.setInt(6, tarjeta.getAnio_caducidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla TARJETAS_DE_CREDITO", ex);
        }
    }

    @Override
    public void eliminar(String id) throws ExceptionManager {
     String consulta = " DELETE FROM Tarjetas_de_Credito WHERE numero_tarjeta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla TARJETAS_DE_CREDITO", ex);
        }
    }

    @Override
    public void actualizar(TarjetaCredito tarjeta) throws ExceptionManager {
         String consulta = "UPDATE Tarjetas_de_Credito "
                 + "SET nombre_usuario = ?, tipo = ?, titular = ?, mes_caducidad = ?, anio_caducidad = ? "
                 + "WHERE NUMERO_TARJETA = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, tarjeta.getNombre_usuario());
            ps.setString(2, tarjeta.getTipo());
            ps.setString(3, tarjeta.getTitular());
            ps.setInt(4, tarjeta.getMes_caducidad());
            ps.setInt(5, tarjeta.getAnio_caducidad());
            ps.setInt(6, tarjeta.getNumero_tarjeta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla TARJETAS_DE_CREDITO", ex);
        }
    }

    @Override
    public TarjetaCredito obtenerEspecifico(String id) throws ExceptionManager {
         TarjetaCredito tarjeta = null;
        String consulta = "SELECT * FROM Tarjetas_de_Credito WHERE numero_tarjeta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   tarjeta= formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla TARJETAS_DE_CREDITO", ex);
        }
        return tarjeta;
    }

    @Override
    public List<TarjetaCredito> obtenerTodos() throws ExceptionManager {
        ArrayList<TarjetaCredito> listaTarjetas = null;
        String consulta = "SELECT * FROM Tarjetas_de_Credito";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaTarjetas = new ArrayList<>();
            while (rs.next()) {
                listaTarjetas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla TARJETAS_DE_CREDITO", ex);
        }
        return listaTarjetas;
    }

    @Override
    public TarjetaCredito formatearResultado(ResultSet rs) throws SQLException {
       TarjetaCredito tarjeta = null;
        try {
            tarjeta= new TarjetaCredito(
                    rs.getInt("numero_tarjeta"),
                    rs.getString("nombre_usuario"),
                    rs.getInt("mes_caducidad"),
                    rs.getInt("anio_caducidad"),
                    rs.getString("tipo"),
                    rs.getString("titular"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDTarjeta.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla TARJETAS_DE_CREDITO", ex);
        }
        return tarjeta;
    }
}
