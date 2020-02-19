package com.example.loginapi;

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


import com.example.loginapi.retrofit.AuthServiceGenerator;
import com.example.loginapi.retrofit.AuthServicio;
import com.example.loginapi.retrofit.response.ResponseTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    private RecyclerView recyclerView;
    private MyTaskRecyclerViewAdapter adapter;
    private List<ResponseTask> tasklist;
    AuthServicio authServicio;
    AuthServiceGenerator authServiceGenerator;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TaskListFragment() {
    }

    public static TaskListFragment newInstance(int columnCount) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

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
            loadTaskList();
        }
        return view;
    }

    private void retrofitInit() {
        authServiceGenerator = authServiceGenerator.getInstance();
        authServicio = authServiceGenerator.getAuthServicio();
    }

    private void loadTaskList() {

        Call<List<ResponseTask>> call = authServicio.getTasks();
        call.enqueue(new Callback<List<ResponseTask>>() {
            @Override
            public void onResponse(Call<List<ResponseTask>> call, Response<List<ResponseTask>> response) {
                if(response.isSuccessful()){
                    tasklist = response.body();
                    adapter = new MyTaskRecyclerViewAdapter(
                            getActivity(),
                            tasklist
                    );
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(),"Algo fue mal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseTask>> call, Throwable t) {
                Toast.makeText(getActivity(),"Error en la conexión",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
