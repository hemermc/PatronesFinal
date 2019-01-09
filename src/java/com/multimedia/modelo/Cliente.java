/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multimedia.modelo;

/**
 *
 * @author amunguia
 */
public class Cliente extends Usuario{
    
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private final String direccion_entrega;
    private final int telefono;
    private final String email;

    public Cliente(String nombre_usuario, String clave, String email, String nombre, String apellidos, String dni, String direccion_entrega, int telefono) {
        super(nombre_usuario, clave);
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion_entrega = direccion_entrega;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
   
}
