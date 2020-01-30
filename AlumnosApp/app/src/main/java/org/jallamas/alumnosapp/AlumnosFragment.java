package org.jallamas.alumnosapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jallamas.alumnosapp.models.Alumno;

import java.util.ArrayList;
import java.util.List;


public class AlumnosFragment extends Fragment {

    private int mColumnCount = 1;
    private IAlumnosListener mListener;
    private MyAlumnosRecyclerViewAdapter adapter;
    private List<Alumno> listaAlumnos;

    public AlumnosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alumnos_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            listaAlumnos = new ArrayList<>();
            listaAlumnos.add(new Alumno("José Antonio","Llamas","https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg"));
            listaAlumnos.add(new Alumno("Esperanza","Escacena","https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg"));
            listaAlumnos.add(new Alumno("José Manuel","Bargueño","https://s3.amazonaws.com/uifaces/faces/twitter/towhidzaman/128.jpg"));

            adapter = new MyAlumnosRecyclerViewAdapter(
                    listaAlumnos,
                    context,
                    R.layout.fragment_alumnos);

            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IAlumnosListener) {
            mListener = (IAlumnosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IAlumnosListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
