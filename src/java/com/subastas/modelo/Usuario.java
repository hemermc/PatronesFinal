
package com.subastas.modelo;

import lombok.Data;

/**
 *
 * @author Grupo_12
 */
@Data
public class Usuario {

    protected String nombre_usuario;
    protected String clave;

    public Usuario(String nombre_usuario, String clave) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
    }

}