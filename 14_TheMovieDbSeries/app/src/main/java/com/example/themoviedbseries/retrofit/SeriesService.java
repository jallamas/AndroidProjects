package com.example.themoviedbseries.retrofit;

import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.response.ResponseSerie;
import com.example.themoviedbseries.response.ResponseSeriePopular;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeriesService {

    @GET("tv/popular?api_key=" + Constantes.API_KEY + "&language=en-US&page=1")
    Call<ResponseSeriePopular> getPopularSeries();

    @GET("tv/{id}")
    Call<ResponseSerie> getSerie(@Path("id") int id);

}