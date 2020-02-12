package org.jallamas.themoviedbseries.retrofit;

import org.jallamas.themoviedbseries.common.Constantes;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static ServiceGenerator serviceGenerator = null;
    private SeriesService servicio;
    private Retrofit retrofit;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor);

    public ServiceGenerator() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(SeriesService.class);
    }

    public static ServiceGenerator getInstance(){
        if(serviceGenerator==null){
            serviceGenerator = new ServiceGenerator();
        }
        return serviceGenerator;
    }

    public SeriesService getSeriesService(){
        return servicio;
    }
}
