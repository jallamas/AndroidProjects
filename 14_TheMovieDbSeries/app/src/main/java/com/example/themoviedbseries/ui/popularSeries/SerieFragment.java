package com.example.themoviedbseries.ui.popularSeries;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.themoviedbseries.R;
import com.example.themoviedbseries.response.Serie;
import com.example.themoviedbseries.viewModel.SeriesViewModel;

import java.util.List;

public class SerieFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
//    List<Serie> serieList;
    MySerieRecyclerViewAdapter adapter;
    private int mColumnCount = 2;
    private RecyclerView recyclerView;
    private SeriesViewModel seriesViewModel;
    Observer<List<Serie>> observer;

    public SerieFragment() {
    }

    public static SerieFragment newInstance(int columnCount) {
        SerieFragment fragment = new SerieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seriesViewModel = new ViewModelProvider(getActivity()).get(SeriesViewModel.class);

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

            observer = new Observer<List<Serie>>() {
                @Override
                public void onChanged(List<Serie> series) {
                    adapter = new MySerieRecyclerViewAdapter(
                            getActivity(),
                            series,
                            seriesViewModel //TODO IMPORTANTE: debemos pasarle al Adapter el ViewModel
                    );
                    recyclerView.setAdapter(adapter);
                }
            };

            seriesViewModel.getSeriesPopulares().observe(getActivity(), observer);

        }
        return view;
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        Toast.makeText(getActivity(), "onResume()", Toast.LENGTH_SHORT).show();
//
//        //TODO IMPORTANTE
//        seriesViewModel.getSeriesPopulares().removeObserver(observer);
//
//        seriesViewModel.getSeriesPopulares().observe(getActivity(), new Observer<List<Serie>>() {
//            @Override
//            public void onChanged(List<Serie> series) {
//                adapter.setData(series);
//                recyclerView.setAdapter(adapter);
//            }
//        });
//
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Toast.makeText(getActivity(), "onPause()", Toast.LENGTH_SHORT).show();
//    }
}