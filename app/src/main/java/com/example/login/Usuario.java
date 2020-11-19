package com.example.login;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
       this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "{" +
                nombre + '\'' +
                ", Usuario='" + usuario + '\'' +
                ", Clave='" + contrasena  + '\'' +
                '}';
    }
}
