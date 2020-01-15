package org.jallamas.customlisthotels;

public class Hotel {

    private String nombre;
    private String photoUrl;
    private double rate;
    private int price;
    private int offerPrice;

    public Hotel(String nombre, String photoUrl, double rate, int price, int offerPrice) {
        this.nombre = nombre;
        this.photoUrl = photoUrl;
        this.rate = rate;
        this.price = price;
        this.offerPrice = offerPrice;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }
}
