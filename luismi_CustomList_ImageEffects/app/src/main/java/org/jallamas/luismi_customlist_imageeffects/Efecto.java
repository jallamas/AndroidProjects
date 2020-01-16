package org.jallamas.luismi_customlist_imageeffects;

public class Efecto {

    private String urlPhoto;
    private String nombreEfecto;

    public Efecto(String urlPhoto, String nombreEfecto) {
        this.urlPhoto = urlPhoto;
        this.nombreEfecto = nombreEfecto;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getNombreEfecto() {
        return nombreEfecto;
    }

    public void setNombreEfecto(String nombreEfecto) {
        this.nombreEfecto = nombreEfecto;
    }
}
