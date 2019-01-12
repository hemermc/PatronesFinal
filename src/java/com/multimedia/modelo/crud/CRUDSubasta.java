
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
 * @author Grupo_12
 */
public class CRUDSubasta implements ICRUDGeneral<Subasta> {

    private final Connection conexion;

    public CRUDSubasta(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un registro en la tabla Subastas
     * @param subasta
     * @throws ExceptionManager 
     */
    @Override
    public void insertar(Subasta subasta) throws ExceptionManager {
        String consulta = "INSERT INTO Subastas(nombre, precio_inicial, precio_final, fecha_alta, fecha_cierre, estado, id_articulo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecio_inicial());
            ps.setFloat(3, subasta.getPrecio_final());
            ps.setDate(4, FormateaFecha.comoDate(subasta.getFecha_alta()));
            ps.setDate(5, FormateaFecha.comoDate(subasta.getFecha_cierre()));
            ps.setString(6, subasta.getEstado());
            ps.setInt(7, subasta.getId_articulo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla SUBASTAS", ex);
        }
    }

    /**
     * Actualiza los datos de un registro de la tabla Subastas
     * @param subasta contiene los datos que se van a actualizar
     * @throws ExceptionManager 
     */
    @Override
    public void actualizar(Subasta subasta) throws ExceptionManager {
        String consulta = "UPDATE Subastas SET nombre = ?, precio_inicial = ?, precio_final = ?, fecha_alta, fecha_cierre, estado, id_articulo "
                + "WHERE id_subasta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, subasta.getNombre());
            ps.setFloat(2, subasta.getPrecio_inicial());
            ps.setFloat(3, subasta.getPrecio_final());
            ps.setDate(4, FormateaFecha.comoDate(subasta.getFecha_alta()));
            ps.setDate(5, FormateaFecha.comoDate(subasta.getFecha_cierre()));
            ps.setString(6, subasta.getEstado());
            ps.setInt(7, subasta.getId_articulo());
            ps.setInt(8, subasta.getId_subasta());

            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla SUBASTAS", ex);
        }
    }

    /**
     * Elimina un registro de la tabla Subastas
     * @param id identificador del registro que se va a eliminar
     * @throws ExceptionManager 
     */
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

    /**
     * Obtiene los datos de un registro por su id_subasta
     * @param id identificador del registro que se quiere recuperar
     * @return
     * @throws ExceptionManager 
     */
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

    /**
     * Recupera todos los registros de la tabla Subastas
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
     * Recupera los registros de la tabla Subastas filtrando por la categoria de la subasta
     * @param categoria
     * @return 
     */
    public ArrayList<Subasta> obtenerCategoria(String categoria) {
        ArrayList<Subasta> listaSubastas = new ArrayList<>();
        String consulta = "SELECT * FROM("
                + "SELECT id_articulo "
                + "FROM Articulos "
                + "WHERE categoria = ?)"
                + " as Resultado "
                + "NATURAL JOIN Subastas WHERE estado = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, categoria);
            ps.setString(2, "Activa");
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    listaSubastas.add(formatearResultado(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla SUBASTAS", ex);
        }
        if(listaSubastas.isEmpty()){
            System.out.println("***************************************** TENEMOS UN PROBLEMON");
        }
        else{
            System.out.println("******************************************" + listaSubastas.get(0).toString());
        }
        
        
        return listaSubastas;
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
                    FormateaFecha.comoLocalDate(rs.getDate("fecha_alta")),
                    FormateaFecha.comoLocalDate(rs.getDate("fecha_cierre")),
                    rs.getString("estado"),
                    rs.getInt("id_articulo"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDSubasta.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla SUBASTAS", ex);
        }
        return subasta;
    }

}

