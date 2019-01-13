
package com.subastas.modelo.crud;

import com.subastas.modelo.ExceptionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Grupo_12
 * @param <T>
 */
public interface ICRUDGeneral<T> {

    void insertar(T obj) throws ExceptionManager;

    void eliminar(String id) throws ExceptionManager;

    void actualizar(T obj) throws ExceptionManager;
    
    T obtenerEspecifico(String id) throws ExceptionManager;
    
    List<T> obtenerTodos() throws ExceptionManager;

    T formatearResultado(ResultSet rs) throws SQLException;
}

