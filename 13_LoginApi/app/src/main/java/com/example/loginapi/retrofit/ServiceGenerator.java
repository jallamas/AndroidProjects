package com.example.loginapi.retrofit;

import com.example.loginapi.common.Constantes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ServiceGenerator serviceGenerator = null;
    private IServicio iServicio;
    private Retrofit retrofit;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor);

    public ServiceGenerator(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iServicio = retrofit.create(IServicio.class);
    }

    public static ServiceGenerator getInstance(){
        if(serviceGenerator==null){
            serviceGenerator = new ServiceGenerator();
        }
        return serviceGenerator;
    }

    public IServicio getIServicio(){
        return iServicio;
    }

}
