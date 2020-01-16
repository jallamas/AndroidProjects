package org.jallamas.luismi_customlist_imageeffects;

import android.graphics.Bitmap;

import com.bumptech.glide.load.Transformation;

public class Efecto {

    private String urlPhoto;
    private String nombreEfecto;
    private Transformation<Bitmap> transformation;

    public Efecto(String urlPhoto, String nombreEfecto, Transformation<Bitmap> transformation) {
        this.urlPhoto = urlPhoto;
        this.nombreEfecto = nombreEfecto;
        this.transformation = transformation;
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

    public Transformation<Bitmap> getTransformation() {
        return transformation;
    }

    public void setTransformation(Transformation<Bitmap> transformation) {
        this.transformation = transformation;
    }
}
