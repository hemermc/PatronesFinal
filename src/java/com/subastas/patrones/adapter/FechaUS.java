package com.subastas.patrones.adapter;

import java.util.StringTokenizer;
import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class FechaUS {

    private int dia;
    private int mes;
    private int anio;

    public FechaUS(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public FechaUS(String date) {
        StringTokenizer st = new StringTokenizer(date, "-");

        if (st.countTokens() == 3) {
            try {
                this.anio = Integer.parseInt(st.nextToken());
                this.mes = Integer.parseInt(st.nextToken());
                this.dia = Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {

            }
        } else {
            this.anio = 0;
            this.mes = 0;
            this.dia = 0;
        }
    }

}
