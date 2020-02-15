package com.example.themoviedbseries.data;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.MySerieRecyclerViewAdapter;
import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.response.ResponseSeriePopular;
import com.example.themoviedbseries.response.Result;
import com.example.themoviedbseries.retrofit.SeriesClient;
import com.example.themoviedbseries.retrofit.SeriesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesRepository {
    SeriesService seriesService;
    SeriesClient seriesClient;
    MutableLiveData<List<Result>> popularSeries;

    SeriesRepository(){
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();
        popularSeries = getPopularSeries();
    }

    public MutableLiveData<List<Result>> getPopularSeries(){
        final MutableLiveData<List<Result>> data = new MutableLiveData<>();

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
