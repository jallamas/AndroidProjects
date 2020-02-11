package com.example.loginapi.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("token")
    @Expose
    private String token;

    public ResponseAuth() {
    }

    public ResponseAuth(String username, String token) {
        super();
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
