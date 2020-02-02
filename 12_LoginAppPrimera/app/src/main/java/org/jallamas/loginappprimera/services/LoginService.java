package org.jallamas.loginappprimera.services;

import org.jallamas.loginappprimera.models.Usuario;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/auth/login")
    Call<Usuario> basicLogin();
}
