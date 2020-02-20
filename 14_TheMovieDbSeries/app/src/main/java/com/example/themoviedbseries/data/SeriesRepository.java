package com.example.themoviedbseries.data;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.response.Serie;
import com.example.themoviedbseries.response.SerieDetails;
import com.example.themoviedbseries.response.SeriesPopulares;
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
    MutableLiveData<SerieDetails> serie;

    public SeriesRepository(){
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();
        popularSeries = getPopularSeries();
    }
    public SeriesRepository(int id){
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();
        serie = getSerie(id);
    }

    public MutableLiveData<SerieDetails> getSerie(int id) {
        final MutableLiveData<SerieDetails> data = new MutableLiveData<>();

        Call<SerieDetails> call = seriesService.getSerie(id);
        call.enqueue(new Callback<SerieDetails>() {
            @Override
            public void onResponse(Call<SerieDetails> call, Response<SerieDetails> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());

                }else{
                    Toast.makeText(MyApp.getContext(), "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SerieDetails> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return data;
    }

    public MutableLiveData<List<Serie>> getPopularSeries(){
        final MutableLiveData<List<Serie>> data = new MutableLiveData<>();

        Call<SeriesPopulares> call = seriesService.getPopularSeries();
        call.enqueue(new Callback<SeriesPopulares>() {
            @Override
            public void onResponse(Call<SeriesPopulares> call, Response<SeriesPopulares> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body().getResults());

                }else{
                    Toast.makeText(MyApp.getContext(), "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SeriesPopulares> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return data;
    }
}
