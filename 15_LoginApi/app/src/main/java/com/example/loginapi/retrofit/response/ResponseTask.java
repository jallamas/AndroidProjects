
package com.example.loginapi.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseTask {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("realized_by")
    @Expose
    private RealizedBy realizedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseTask() {
    }

    /**
     * 
     * @param createdAt
     * @param createdBy
     * @param id
     * @param title
     * @param body
     * @param realizedBy
     */
    public ResponseTask(Integer id, String createdAt, String title, String body, CreatedBy createdBy, RealizedBy realizedBy) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.body = body;
        this.createdBy = createdBy;
        this.realizedBy = realizedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public RealizedBy getRealizedBy() {
        return realizedBy;
    }

    public void setRealizedBy(RealizedBy realizedBy) {
        this.realizedBy = realizedBy;
    }

}
