package com.example.themoviedbseries.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.themoviedbseries.data.SeriesRepository;

import com.example.themoviedbseries.response.Serie;

import java.util.List;

public class SeriesViewModel extends AndroidViewModel {
    private SeriesRepository seriesRepository;
    private MutableLiveData<List<Serie>> listaSeries;
    MutableLiveData<Integer> idSerieSeleccionada;


    public SeriesViewModel(@NonNull Application application) {
        super(application);
        seriesRepository = new SeriesRepository();
        this.idSerieSeleccionada = new MutableLiveData<>();
        this.idSerieSeleccionada.setValue(null);
    }

    public MutableLiveData<List<Serie>> getSeriesPopulares(){

        listaSeries = seriesRepository.getPopularSeries();

        return listaSeries;
    }

    public void setIdSerieSeleccionada(Integer idSerieSeleccionada) {
        Log.d("seteando id",idSerieSeleccionada.toString());
        this.idSerieSeleccionada.setValue(idSerieSeleccionada);
    }

    public MutableLiveData<Integer> getIdSerieSeleccionada() {
        Log.d("geteando id",idSerieSeleccionada.toString());
        return idSerieSeleccionada;
    }
}
