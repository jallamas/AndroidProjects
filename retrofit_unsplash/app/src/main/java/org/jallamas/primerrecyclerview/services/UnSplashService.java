package org.jallamas.primerrecyclerview.services;

import android.media.Image;

import org.jallamas.primerrecyclerview.models.UnSplashPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UnSplashService {

    @GET("/photos/random")
    Call<List<UnSplashPhoto>> randomImages(
            Call<Image>
    );
}
