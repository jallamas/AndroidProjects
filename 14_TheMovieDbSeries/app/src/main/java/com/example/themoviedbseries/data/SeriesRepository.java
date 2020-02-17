package com.example.themoviedbseries.data;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.response.ResponseSerie;
import com.example.themoviedbseries.response.ResponseSeriePopular;
import com.example.themoviedbseries.response.Serie;
import com.example.themoviedbseries.retrofit.SeriesClient;
import com.example.themoviedbseries.retrofit.SeriesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesRepository {
    SeriesService seriesService;
    SeriesClient seriesClient;
    MutableLiveData<List<Serie>> popularSeries;
    MutableLiveData<ResponseSerie> serie;

    public SeriesRepository(){
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();
        popularSeries = getPopularSeries();
    }
    public SeriesRepository(String id){
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();
        serie = getSerie(id);
    }

    private MutableLiveData<ResponseSerie> getSerie(String id) {
        final MutableLiveData<ResponseSerie> data = new MutableLiveData<>();

        Call<ResponseSerie> call = seriesService.getSerie(id);
        call.enqueue(new Callback<ResponseSerie>() {
            @Override
            public void onResponse(Call<ResponseSerie> call, Response<ResponseSerie> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());

                }else{
                    Toast.makeText(MyApp.getContext(), "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSerie> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return data;
    }

    public MutableLiveData<List<Serie>> getPopularSeries(){
        final MutableLiveData<List<Serie>> data = new MutableLiveData<>();

        Call<ResponseSeriePopular> call = seriesService.getPopularSeries();
        call.enqueue(new Callback<ResponseSeriePopular>() {
            @Override
            public void onResponse(Call<ResponseSeriePopular> call, Response<ResponseSeriePopular> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body().getResults());

                }else{
                    Toast.makeText(MyApp.getContext(), "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSeriePopular> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return data;
    }
}
