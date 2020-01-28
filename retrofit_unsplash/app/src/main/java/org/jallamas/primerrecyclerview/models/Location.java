
package org.jallamas.primerrecyclerview.models;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private String title;
    private String name;
    private Object city;
    private String country;
    private Position position;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param country
     * @param city
     * @param name
     * @param position
     * @param title
     */
    public Location(String title, String name, Object city, String country, Position position) {
        super();
        this.title = title;
        this.name = name;
        this.city = city;
        this.country = country;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
