
package com.example.loginapi.retrofit.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealizedBy {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RealizedBy() {
    }

    /**
     * 
     * @param roles
     * @param id
     * @param fullname
     * @param email
     * @param username
     */
    public RealizedBy(Integer id, String username, String email, String fullname, List<String> roles) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
