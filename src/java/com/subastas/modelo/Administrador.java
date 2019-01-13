
package com.subastas.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Grupo_12
 */
@Getter
@Setter
public class Administrador extends Usuario {

    private int nivel_permisos;

    public Administrador(String nombre_usuario, String clave, int nivel_permisos) {
        super(nombre_usuario, clave);
        this.nivel_permisos = nivel_permisos;
    }

}