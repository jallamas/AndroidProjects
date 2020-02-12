package com.example.themoviedbseries;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.themoviedbseries.response.ResponseSeriePopular;
import com.example.themoviedbseries.response.Result;
import com.example.themoviedbseries.retrofit.SeriesClient;
import com.example.themoviedbseries.retrofit.SeriesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SerieFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    List<Result> resultList;
    MySerieRecyclerViewAdapter adapter;
    private int mColumnCount = 2;
    private RecyclerView recyclerView;
    SeriesService seriesService;
    SeriesClient seriesClient;

    public SerieFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serie_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            retrofitInit();
            loadSeriesData();
        }
        return view;
    }

    private void retrofitInit() {
        seriesClient = seriesClient.getInstance();
        seriesService = seriesClient.getSeriesService();

    }

    private void loadSeriesData() {
        Call<ResponseSeriePopular> call = seriesService.getPopularSeries();
        call.enqueue(new Callback<ResponseSeriePopular>() {
            @Override
            public void onResponse(Call<ResponseSeriePopular> call, Response<ResponseSeriePopular> response) {
                if(response.isSuccessful()){
                    resultList =response.body().getResults();
                    adapter = new MySerieRecyclerViewAdapter(
                            getActivity(),
                            resultList
                    );
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(getActivity(), "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSeriePopular> call, Throwable t) {
                Toast.makeText(getActivity(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
