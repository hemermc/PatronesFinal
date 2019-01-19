package com.subastas.patrones.adapter;

import java.sql.Date;

/**
 *
 * @author Grupo_12
 */
public class AdapterFechaUSToES implements Fecha {

    private final FechaUS fechaUS;

    public AdapterFechaUSToES(FechaUS fechaUS) {
        this.fechaUS = fechaUS;
    }

    @Override
    public int getAnio() {
        return fechaUS.getAnio();
    }

    @Override
    public void setAnio(int anio) {
        this.fechaUS.setAnio(anio);
    }

    @Override
    public int getMes() {
        return fechaUS.getMes();
    }

    @Override
    public void setMes(int mes) {
        this.fechaUS.setMes(mes);
    }

    @Override
    public int getDia() {
        return fechaUS.getDia();
    }

    @Override
    public void setDia(int dia) {
        this.fechaUS.setDia(dia);
    }

    @Override
    public String obtenerFechaString() {
        return fechaUS.getDia() + "/" + fechaUS.getMes() + "/" + fechaUS.getAnio();
    }

    @Override
    public Date obtenerFechaDate() {
        Date fecha = new Date(fechaUS.getDia(), fechaUS.getMes(), fechaUS.getAnio());
        return fecha;
    }

}
