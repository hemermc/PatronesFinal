package com.subastas.modelo.crud;

import com.subastas.commons.Constantes;
import com.subastas.modelo.Cliente;
import com.subastas.modelo.Usuario;
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
public class CRUDCliente implements ICRUDGeneral<Cliente>, ICRUDUsuario {

    private final Connection conexion;

    /**
     * Constructor
     *
     * @param conexion
     */
    public CRUDCliente(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un registro en la tabla Clientes
     *
     * @param cliente
     */
    @Override
    public void insertar(Cliente cliente) {
        String consulta = "INSERT INTO Clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);) {//Implementa el autocierre del PreparedStatement
            ps.setString(1, cliente.getNombre_usuario());
            ps.setString(2, cliente.getClave());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getApellidos());
            ps.setString(6, cliente.getDni());
            ps.setString(7, cliente.getDireccion_entrega());
            ps.setInt(8, cliente.getTelefono());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla USUARIOS", ex);
        }
    }

    /**
     *
     * @param nombre_usuario
     */
    @Override
    public void eliminar(String nombre_usuario) {
        String consulta = "DELETE FROM Clientes WHERE " + Constantes.NOMBRE_USUARIO + " = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nombre_usuario);
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla USUARIOS", ex);
        }
    }

    /**
     *
     * @param cliente
     */
    @Override
    public void actualizar(Cliente cliente) {
        String consulta = "UPDATE Clientes SET " + Constantes.CLAVE + " = ?, "
                + Constantes.EMAIL + " = ?, " + Constantes.NOMBRE + " = ?, "
                + Constantes.APELLIDOS + " = ?, " + Constantes.DNI + " = ?, "
                + Constantes.DIRECCION_ENTREGA + " = ?, " + Constantes.TELEFONO
                + " = ? WHERE " + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, cliente.getNombre_usuario());
            ps.setString(2, cliente.getClave());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getApellidos());
            ps.setString(6, cliente.getDni());
            ps.setString(7, cliente.getDireccion_entrega());
            ps.setInt(8, cliente.getTelefono());
            ps.setString(9, cliente.getEmail());
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla CLIENTES", ex);
        }
    }

    /**
     * Comprueba si existe un registro con el identidicador pasado por parametro
     * y lo devuelve.
     *
     * @param nombre_usuario
     * @return Objeto que contiene los datos del registro buscado.
     */
    @Override
    public Cliente obtenerEspecifico(String nombre_usuario) {
        Cliente cliente = null;
        String consulta = "SELECT * FROM Clientes WHERE " + Constantes.NOMBRE_USUARIO + " = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nombre_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla CLIENTES", ex);
        }
        return cliente;
    }

    /**
     * Devuelve todos los registros que contiene la tabla Usuarios.
     *
     * @return Lista que contiene los registros de la tabla.
     */
    @Override
    public List<Cliente> obtenerTodos() {
        ArrayList<Cliente> listaUsuarios = new ArrayList<>();
        String consulta = "SELECT * FROM Clientes";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery(consulta)) {
            while (rs.next()) {
                listaUsuarios.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla CLIENTES", ex);
        }
        return listaUsuarios;
    }

    /**
     * Obtiene los datos del ResultSet y los almacena en un objeto Usuario.
     *
     * @param rs ResultSet que contiene los datos del registro obtenido de la
     * BBDD.
     * @return Objeto con los datos obtenidos.
     */
    @Override
    public Cliente formatearResultado(ResultSet rs) {
        Cliente cliente = null;
        try {
            cliente = new Cliente(rs.getString(Constantes.NOMBRE),
                    rs.getString(Constantes.APELLIDOS),
                    rs.getString(Constantes.DNI),
                    rs.getString(Constantes.DIRECCION_ENTREGA),
                    rs.getInt(Constantes.TELEFONO),
                    rs.getString(Constantes.EMAIL),
                    rs.getString(Constantes.NOMBRE_USUARIO),
                    rs.getString(Constantes.CLAVE));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla CLIENTES", ex);
        }
        return cliente;
    }

    /**
     * Comprueba si el nombre de usuario existe en la tabla CLIENTES
     *
     * @param nombre_usuario
     * @return booleano que indica si la información es correcta.
     */
    @Override
    public boolean esUsuarioRegistrado(String nombre_usuario) {
        Boolean valido = false;
        if (obtenerEspecifico(nombre_usuario) != null) {
            valido = true;
        }
        return valido;
    }

    /**
     * Comprueba si los datos de inicio de sesión son correctos
     *
     * @param usuario
     * @return
     */
    @Override
    public boolean inicioSesionValido(Usuario usuario) {
        String consulta = "SELECT * FROM Clientes WHERE " + Constantes.NOMBRE_USUARIO + " = ? AND " + Constantes.CLAVE + " = ?";
        Boolean valido = false;
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getClave());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    valido = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, "Error al comprobar la identidad en la tabla CLIENTES", ex);
        }
        return valido;
    }
}
