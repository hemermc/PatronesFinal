
package com.subastas.modelo.crud;

import com.subastas.modelo.Usuario;

/**
 *
 * @author Grupo_12
 */
public abstract interface ICRUDUsuario {

    boolean esUsuarioRegistrado(String nombre_usuario);

    boolean inicioSesionValido(Usuario usuario);
}