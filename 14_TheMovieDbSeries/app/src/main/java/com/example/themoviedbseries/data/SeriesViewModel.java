package com.example.themoviedbseries.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.response.Result;

import java.util.List;

public class SeriesViewModel extends AndroidViewModel {

    private SeriesRepository seriesRepository;
    private MutableLiveData<List<Result>> listaSeries;

    public SeriesViewModel(@NonNull Application application) {
        super(application);
        seriesRepository = new SeriesRepository();
        listaSeries = seriesRepository.getPopularSeries();
    }

    public MutableLiveData<List<Result>> getSeriesPopulares(){
        return listaSeries;
    }
}
