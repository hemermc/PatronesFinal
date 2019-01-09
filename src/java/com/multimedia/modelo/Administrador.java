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
public class Administrador extends Usuario {

    private final int nivel_permisos;

    public Administrador(String nombre_usuario, String clave, int nivel_permisos) {
        super(nombre_usuario, clave);
        this.nivel_permisos = nivel_permisos;
    }

    public int getNivel_permisos() {
        return nivel_permisos;
    }

}