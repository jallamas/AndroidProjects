package org.jallamas.alumnosapp.models;

public class Alumno {

    private String nombre;
    private String apellidos;
    private String fotoUrl;

    public Alumno(String nombre, String apellidos, String fotoUrl) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fotoUrl = fotoUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
