
package com.multimedia.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Factura {
    private Integer id_factura;
    private float importe_total;
    private int id_compra;

    
//Constructor usado para cuando se obtiene una factura de la BBDD
    public Factura(Integer id_factura, float importe_total, int id_compra) {
        this.id_factura = id_factura;
        this.importe_total = importe_total;
        this.id_compra = id_compra;
    }

    // Constructor usado cuando se inserta una factura en la BBDD
    public Factura(float importe_total, int id_compra) {
        this.id_factura = null;
        this.importe_total = importe_total;
        this.id_compra = id_compra;
    }
    
}
