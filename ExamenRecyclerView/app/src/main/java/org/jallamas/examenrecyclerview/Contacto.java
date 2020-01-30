package org.jallamas.examenrecyclerview;

public class Contacto {

    private String nombre;
    private String estado;
    private String fotoUrl;
    private int edad;
    private int numeroAmigos;
    private int numeroFotosSubidas;
    private boolean estadoOnline;

    public Contacto(String nombre, String estado, String fotoUrl, int edad, int numeroAmigos, int numeroFotosSubidas, boolean estadoOnline) {
        this.nombre = nombre;
        this.estado = estado;
        this.fotoUrl = fotoUrl;
        this.edad = edad;
        this.numeroAmigos = numeroAmigos;
        this.numeroFotosSubidas = numeroFotosSubidas;
        this.estadoOnline = estadoOnline;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroAmigos() {
        return numeroAmigos;
    }

    public void setNumeroAmigos(int numeroAmigos) {
        this.numeroAmigos = numeroAmigos;
    }

    public int getNumeroFotosSubidas() {
        return numeroFotosSubidas;
    }

    public void setNumeroFotosSubidas(int numeroFotosSubidas) {
        this.numeroFotosSubidas = numeroFotosSubidas;
    }

    public boolean isEstadoOnline() {
        return estadoOnline;
    }

    public void setEstadoOnline(boolean estadoOnline) {
        this.estadoOnline = estadoOnline;
    }
}
