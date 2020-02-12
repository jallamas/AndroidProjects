
package com.example.loginapi.retrofit.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqRegister {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("password2")
    @Expose
    private String password2;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReqRegister() {
    }

    /**
     * 
     * @param password
     * @param password2
     * @param email
     * @param username
     */
    public ReqRegister(String email, String username, String password, String password2) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

}
