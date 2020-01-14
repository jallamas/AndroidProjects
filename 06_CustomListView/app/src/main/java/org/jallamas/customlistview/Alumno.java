package org.jallamas.customlistview;

public class Alumno {

    private String nombre;
    private String photoUrl;
    private int edad;

    public Alumno(String nombre, String photoUrl, int edad) {
        this.nombre = nombre;
        this.photoUrl = photoUrl;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
