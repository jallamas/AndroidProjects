package org.jallamas.examenrecyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ContactoFragmentList extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    IContactoListener mListener;
    List<Contacto> contactoList;
    MyContactoRecyclerViewAdapter adapter;

     public ContactoFragmentList() {
    }

    @SuppressWarnings("unused")
    public static ContactoFragmentList newInstance(int columnCount) {
        ContactoFragmentList fragment = new ContactoFragmentList();
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
        View view = inflater.inflate(R.layout.fragment_contacto_list, container, false);

        contactoList = new ArrayList<>();

        contactoList.add(new Contacto("José Antonio Llamas","haciendo el examen","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg",25,56,4,false));
        contactoList.add(new Contacto("Esperanza Escacena","Mala como un perro","https://s3.amazonaws.com/uifaces/faces/twitter/adellecharles/128.jpg",28,25,6,true));
        contactoList.add(new Contacto("José Manuel Bargueño","Atracando viejas","https://s3.amazonaws.com/uifaces/faces/twitter/abinav_t/128.jpg",32,68,0,false));
        contactoList.add(new Contacto("Pablo Rodríguez","Jugando a todo menos a baloncesto","https://s3.amazonaws.com/uifaces/faces/twitter/mlane/128.jpg",45,156,14,true));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyContactoRecyclerViewAdapter(
                    getActivity(),
                    contactoList,
                    mListener
            );

            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IContactoListener) {
            mListener = (IContactoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IContactoListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
