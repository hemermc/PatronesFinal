
package com.subastas.modelo;

/**
 *
 * @author Grupo_12
 * @param <T>
 */
public interface IConexion<T> {
    
    public T establecerConexion();
    
    public void cerrarConexion();
}
