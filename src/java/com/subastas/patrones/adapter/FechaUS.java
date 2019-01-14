
package com.subastas.patrones.adapter;

import java.util.StringTokenizer;

/**
 *
 * @author Grupo_12
 */
public class FechaUS {
    private int dia;
    private int mes;
    private int anio;
    
    public FechaUS(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public FechaUS(String date){
        StringTokenizer st = new StringTokenizer(date, "-");
        
        this.anio = Integer.parseInt(st.nextToken());
        this.mes = Integer.parseInt(st.nextToken());
        this.dia = Integer.parseInt(st.nextToken());
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
