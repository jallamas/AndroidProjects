package org.jallamas.fragmentlistrecyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jallamas.fragmentlistrecyclerview.dummy.DummyContent;
import org.jallamas.fragmentlistrecyclerview.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IRestauranteListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private IRestauranteListener mListener;
    private MyRestauranteRecyclerViewAdapter adapter;
    private List<Restaurante> restaurantes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restaurantes=new ArrayList<>();
            restaurantes.add(new Restaurante("Casa Paco","https://media-cdn.tripadvisor.com/media/photo-s/01/eb/01/91/casa-paco-madrid.jpg",3.0f,"Avda. Pepe Charco","954959595"));
            restaurantes.add(new Restaurante("El Espigón","https://d3f5rf6vpkkrog.cloudfront.net/images/valoraciones/0019/3762/open-uri20180503-19346-v1503x_logo.?1525331188",4.5f,"Avda. Ramón Carande","954875421"));
            adapter = new MyRestauranteRecyclerViewAdapter(
                    context,
                    R.layout.fragment_restaurante,
                    restaurantes,
                    mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    //Recibe como parámetro el activity donde se ha insertado el fragmento
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IRestauranteListener) {
            mListener = (IRestauranteListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
