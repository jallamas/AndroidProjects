package com.example.themoviedbseries;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.themoviedbseries.data.SeriesViewModel;
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
    private SeriesViewModel seriesViewModel;


    public SerieFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seriesViewModel = new ViewModelProvider(getActivity())
                .get(SeriesViewModel.class);

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
            adapter = new MySerieRecyclerViewAdapter(
                    getActivity(),
                    resultList
            );
            recyclerView.setAdapter(adapter);

            loadSeriesData();
        }
        return view;
    }

    private void loadSeriesData() {
        seriesViewModel.getSeriesPopulares().observe(getActivity(), new Observer<List<Result>>() {
                    @Override
                    public void onChanged(List<Result> results) {
                        resultList = results;
                        adapter.setData(resultList);
                    }
                }
        );

    }

}
