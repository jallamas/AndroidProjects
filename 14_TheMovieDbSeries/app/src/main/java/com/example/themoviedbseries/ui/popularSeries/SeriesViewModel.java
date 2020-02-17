package com.example.themoviedbseries.ui.popularSeries;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.data.SeriesRepository;
import com.example.themoviedbseries.response.Serie;

import java.util.List;

public class SeriesViewModel extends AndroidViewModel {

    private SeriesRepository seriesRepository;
    private MutableLiveData<List<Serie>> listaSeries;

    public SeriesViewModel(@NonNull Application application) {
        super(application);
        seriesRepository = new SeriesRepository();
        listaSeries = seriesRepository.getPopularSeries();
    }


    public MutableLiveData<List<Serie>> getSeriesPopulares(){
        return listaSeries;
    }

}
