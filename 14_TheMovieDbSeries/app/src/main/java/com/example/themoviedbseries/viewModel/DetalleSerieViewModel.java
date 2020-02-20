package com.example.themoviedbseries.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.data.SeriesRepository;
import com.example.themoviedbseries.response.SerieDetails;

public class DetalleSerieViewModel extends AndroidViewModel {

    MutableLiveData<SerieDetails> serie;
    SeriesRepository seriesRepository;

    public DetalleSerieViewModel(@NonNull Application application) {
        super(application);
        seriesRepository = new SeriesRepository();
    }

    public MutableLiveData<SerieDetails> getSerie(int idSerie) {
        serie = seriesRepository.getSerie(idSerie);
        return serie;
    }

}
