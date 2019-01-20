package com.subastas.patrones.adapter;

import java.sql.Date;

/**
 *
 * @author Grupo_12
 */
public class AdapterFechaESToUS implements Fecha {

    private final FechaES fechaES;

    public AdapterFechaESToUS(FechaES fechaES) {
        this.fechaES = fechaES;
    }

    @Override
    public int getAnio() {
        return fechaES.getAnio();
    }

    @Override
    public void setAnio(int anio) {
        this.fechaES.setAnio(anio);
    }

    @Override
    public int getMes() {
        return fechaES.getMes();
    }

    @Override
    public void setMes(int mes) {
        this.fechaES.setMes(mes);
    }

    @Override
    public int getDia() {
        return fechaES.getDia();
    }

    @Override
    public void setDia(int dia) {
        this.fechaES.setDia(dia);
    }

    @Override
    public String obtenerFechaString() {
        return fechaES.getMes() + "-" + fechaES.getDia() + "-" + fechaES.getAnio();
    }

    @Override
    public Date obtenerFechaDate() {
        Date fecha = new Date(fechaES.getDia(), fechaES.getMes(), fechaES.getAnio());
        return fecha;
    }

}
