
package com.example.loginapi.retrofit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqNewTask {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("realized_by")
    @Expose
    private Integer realizedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReqNewTask() {
    }

    /**
     *
     * @param createdBy
     * @param title
     * @param body
     * @param realizedBy
     */
    public ReqNewTask(String title, String body, Integer createdBy, Integer realizedBy) {
        super();
        this.title = title;
        this.body = body;
        this.createdBy = createdBy;
        this.realizedBy = realizedBy;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getRealizedBy() {
        return realizedBy;
    }

    public void setRealizedBy(Integer realizedBy) {
        this.realizedBy = realizedBy;
    }

}
