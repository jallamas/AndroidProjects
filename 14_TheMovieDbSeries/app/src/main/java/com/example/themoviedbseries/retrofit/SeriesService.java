package com.example.themoviedbseries.retrofit;

import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.response.ResponseSeriePopular;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SeriesService {

    @GET("tv/popular?api_key=" + Constantes.API_KEY + "&language=en-US&page=1")
    Call<ResponseSeriePopular> getPopularSeries();

}
