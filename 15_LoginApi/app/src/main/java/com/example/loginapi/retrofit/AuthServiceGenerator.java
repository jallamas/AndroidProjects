package com.example.loginapi.retrofit;

import com.example.loginapi.common.Constantes;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthServiceGenerator {

    private static AuthServiceGenerator serviceGenerator = null;
    private AuthServicio iServicio;
    private Retrofit retrofit;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor);

    public AuthServiceGenerator(){

        //Incluimos el token en la cabecera de la petición
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new AuthInterceptor());
        OkHttpClient okHttpClient = okHttpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        iServicio = retrofit.create(AuthServicio.class);
    }


    public static AuthServiceGenerator getInstance(){
        if(serviceGenerator==null){
            serviceGenerator = new AuthServiceGenerator();
        }
        return serviceGenerator;
    }

    public AuthServicio getAuthServicio(){
        return iServicio;
    }


}
