
package org.jallamas.primerrecyclerview.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnSplashPhoto {

    private String id;
    private String createdAt;
    private String updatedAt;
    private String promotedAt;
    private Integer width;
    private Integer height;
    private String color;
    private Object description;
    private String altDescription;
    private Urls urls;
    private Links links;
    private List<Object> categories = null;
    private Integer likes;
    private Boolean likedByUser;
    private List<Object> currentUserCollections = null;
    private User user;
    private Exif exif;
    private Location location;
    private Integer views;
    private Integer downloads;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnSplashPhoto() {
    }

    /**
     * 
     * @param likedByUser
     * @param color
     * @param description
     * @param createdAt
     * @param urls
     * @param downloads
     * @param currentUserCollections
     * @param promotedAt
     * @param width
     * @param links
     * @param location
     * @param id
     * @param categories
     * @param altDescription
     * @param user
     * @param views
     * @param updatedAt
     * @param height
     * @param likes
     * @param exif
     */
    public UnSplashPhoto(String id, String createdAt, String updatedAt, String promotedAt, Integer width, Integer height, String color, Object description, String altDescription, Urls urls, Links links, List<Object> categories, Integer likes, Boolean likedByUser, List<Object> currentUserCollections, User user, Exif exif, Location location, Integer views, Integer downloads) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.promotedAt = promotedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.description = description;
        this.altDescription = altDescription;
        this.urls = urls;
        this.links = links;
        this.categories = categories;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.currentUserCollections = currentUserCollections;
        this.user = user;
        this.exif = exif;
        this.location = location;
        this.views = views;
        this.downloads = downloads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPromotedAt() {
        return promotedAt;
    }

    public void setPromotedAt(String promotedAt) {
        this.promotedAt = promotedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exif getExif() {
        return exif;
    }

    public void setExif(Exif exif) {
        this.exif = exif;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
