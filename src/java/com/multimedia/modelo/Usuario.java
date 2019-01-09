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
public class Usuario {

    protected final String nombre_usuario;
    protected final String clave;

    public Usuario(String nombre_usuario, String clave) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

}

