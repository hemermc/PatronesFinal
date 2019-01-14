
package com.subastas.patrones.factory;

import com.subastas.modelo.ExceptionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Grupo_12
 * @param <T>
 */
public abstract class ICRUDGeneral<T> {

    public abstract void insertar(T obj) throws ExceptionManager;

    public abstract void eliminar(String id) throws ExceptionManager;

    public abstract void actualizar(T obj) throws ExceptionManager;
    
    public abstract T obtenerEspecifico(String id) throws ExceptionManager;
    
    public abstract List<T> obtenerTodos() throws ExceptionManager;

    public abstract T formatearResultado(ResultSet rs) throws SQLException;
}

