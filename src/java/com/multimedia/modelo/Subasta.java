/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

import com.patrones.Observador;
import com.patrones.SujetoInterface;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author amunguia
 */
public class Subasta{

    private final Integer id_subasta;
    private final String nombre;
    private final float precioInicial;
    private float precioFinal;
    private final LocalDate fecha;
    private boolean activa;
    private final int lote;

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    //Constructor para almacenar los datos procedentes de la BBDD
    public Subasta(Integer id_subasta, String nombre, float precioInicial, float precioFinal, LocalDate fecha, boolean activa, int lote) {
        this.id_subasta = id_subasta;
        this.nombre = nombre;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.activa = activa;
        this.lote = lote;
    }

    //Constructor para añadir una subasta
    public Subasta(String nombre, float precioInicial, float precioFinal, LocalDate fecha, boolean activa, int lote) {
        this.id_subasta = null;
        this.nombre = nombre;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.activa = activa;
        this.lote = lote;
    }

    public Integer getId_subasta() {
        return id_subasta;
    }

    public String getNombre() {
        return nombre;
    }
    private static final Logger LOG = Logger.getLogger(Subasta.class.getName());

    public float getPrecioInicial() {
        return precioInicial;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float preciofinal) {
        precioFinal = preciofinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isActiva() {
        return activa;
    }

    public int getLote() {
        return lote;
    }
}
