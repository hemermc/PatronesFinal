
package com.subastas.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class TarjetaCredito {

    private int numero_tarjeta;
    private String nombre_usuario;
    private int mes_caducidad;
    private int anio_caducidad;
    private String tipo;
    private String titular;

    public TarjetaCredito(int numero_tarjeta, String nombre_usuario, int mes_caducidad, int anio_caducidad, String tipo, String titular) {
        this.numero_tarjeta = numero_tarjeta;
        this.nombre_usuario = nombre_usuario;
        this.mes_caducidad = mes_caducidad;
        this.anio_caducidad = anio_caducidad;
        this.tipo = tipo;
        this.titular = titular;
    }

}
