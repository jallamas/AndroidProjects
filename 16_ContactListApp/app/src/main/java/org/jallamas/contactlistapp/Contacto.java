package org.jallamas.contactlistapp;

public class Contacto {

    private String nombre;
    private String telefono;
    private String photo;
    private String email;

    public Contacto(String nombre, String telefono, String photo, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.photo = photo;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
