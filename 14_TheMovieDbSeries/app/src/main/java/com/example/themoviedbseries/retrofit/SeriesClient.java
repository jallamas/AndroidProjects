package com.example.themoviedbseries.retrofit;

import com.example.themoviedbseries.common.Constantes;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeriesClient {
    private static SeriesClient instance = null;
    private SeriesService seriesService;
    private Retrofit retrofit;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor);

    public SeriesClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        seriesService = retrofit.create(SeriesService.class);
    }

    public static SeriesClient getInstance(){
        if (instance == null){
            instance = new SeriesClient();
        }
        return instance;
    }

    public SeriesService getSeriesService(){
        return seriesService;
    }
}
