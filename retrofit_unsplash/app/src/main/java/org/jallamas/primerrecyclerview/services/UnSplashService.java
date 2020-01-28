package org.jallamas.primerrecyclerview.services;

import org.jallamas.primerrecyclerview.models.UnSplashPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UnSplashService {

    @GET("photos/random/?client_id={client_id")
    Call<List<UnSplashPhoto>> randomImages(
            @Path("client_id") String client_id
    );
}
