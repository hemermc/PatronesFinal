
package com.subastas.patrones.adapter;

import java.sql.Date;

/**
 *
 * @author Grupo_12
 */
public interface Fecha {
    public int getAnio();
    
    public void setAnio(int anio);
    
    public int getMes();
    
    public void setMes(int mes);
    
    public int getDia();
    
    public void setDia(int dia);
    
    public String obtenerFechaString();
    
    public Date obtenerFechaDate();
}
