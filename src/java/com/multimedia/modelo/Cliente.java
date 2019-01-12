
package com.multimedia.modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Grupo_12
 */
@Getter
@Setter
public class Cliente extends Usuario{
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private final String direccion_entrega;
    private final int telefono;
    private final String email;

    
    public Cliente(String nombre, String apellidos, String dni, String direccion_entrega, int telefono, String email, String nombre_usuario, String clave) {
        super(nombre_usuario, clave);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion_entrega = direccion_entrega;
        this.telefono = telefono;
        this.email = email;
    }
    
}