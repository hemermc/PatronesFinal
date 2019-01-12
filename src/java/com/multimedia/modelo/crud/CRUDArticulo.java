
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Articulo;
import com.patrones.builder.BuilderArte;
import com.patrones.builder.BuilderArticulo;
import com.patrones.builder.BuilderMobiliario;
import com.patrones.builder.BuilderNumismatica;
import com.patrones.builder.Director;
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
 * @author Grupo_12
 */
public class CRUDArticulo implements ICRUDGeneral<Articulo> {

    private final Connection conexion;
    private Integer id_articulo;

    public CRUDArticulo(Connection conexion) {
        this.conexion = conexion;
        id_articulo = null;
    }

    @Override
    public void insertar(Articulo articulo) {
        String consultaArticulo = "INSERT INTO Articulos"
                + "(nombre, descripcion, anio, estado_conservacion, precio, categoria, foto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consultaArticulo)) {
            ps.setString(1, articulo.getNombre());
            ps.setString(2, articulo.getDescripcion());
            ps.setInt(3, articulo.getAnio());
            ps.setString(4, articulo.getEstado_conservacion());
            ps.setFloat(5, articulo.getPrecio());
            ps.setString(6, articulo.getCategoria());
            ps.setString(7, articulo.getFoto());
            ps.executeUpdate();
            
            Statement st = conexion.createStatement();
            //Recupera el id_articulo del último articulo insertado para insertar el articulo especifico en su tabla correspondiente
            ResultSet rs = st.executeQuery("SELECT MAX(lote) as lote FROM Articulos");
            
            if (rs.next()) {
                id_articulo = rs.getInt("id_articulo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla ARTICULOS", ex);
        }
    }

    public Integer getId_articulo() {
        return id_articulo;
    }

    @Override
    public void eliminar(String lote) {
        String consulta = "DELETE FROM Articulos WHERE id_articulo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla ARTICULOS", ex);
        }
    }

    @Override
    public void actualizar(Articulo articulo) {
        String consulta = "UPDATE Articulos "
                + "SET nombre = ?, descripcion = ?, anio = ?, estado_conservacion = ?, precio = ?, categoria = ?, foto = ? "
                + "WHERE id_articulo = ?";
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
        String consulta = "SELECT * FROM Articulos WHERE id_articulo = ?";
        
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
        Director director = new Director();
        BuilderArticulo bArticulo = null;
        
        try {
            switch (rs.getString("categoria")) {
                case "Mobiliario":
                    bArticulo = new BuilderMobiliario();
                    break;
                case "Arte":
                    bArticulo = new BuilderArte();
                    break;
                case "Numismatica":
                    bArticulo = new BuilderNumismatica();
                    break;
                default:
                    break;
            }
            director.setBuilderArticulo(bArticulo);
            director.crearArticulo(rs.getInt("id_articulo"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("anio"),
                rs.getString("estado_conservacion"),
                rs.getFloat("precio"),
                rs.getString("foto"),
                rs.getString("dimensiones"),
                rs.getString("autor"),
                rs.getString("procedencia"));
            
            articulo = director.getArticulo();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDArticulo.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla ARTICULOS", ex);
        }
        return articulo;
    }
}
