package android.salesianostriana.com.nasaapodbase;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.salesianostriana.com.api.NasaApi;
import android.salesianostriana.com.api.NasaPicture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PicFragment extends Fragment {

    private int mColumnCount = 2;
    private INasaPictureListener mListener;
    private MypicRecyclerViewAdapter adapter;
    private List<NasaPicture> listaImagenes=new ArrayList<>();
    private RecyclerView recyclerView;
    private Context context;

    NasaApi nasaApi = new NasaApi("dJLaK1IQk9N3fnNCam84bO9TZshz7su8k23doMLi");
    int count1 = 0;
    int count2 = 1;
    int currentItems, totalItems, scrollOutItems;

    LinearLayoutManager manager;
    ProgressDialog progressDialog;
    LocalDate day = LocalDate.now();
    LocalDate timeBefore = day.minusMonths(count2);

    private static final String ARG_COLUMN_COUNT = "column-count";
    boolean scroll = false;

    public static PicFragment newInstance(int columnCount) {
        PicFragment fragment = new PicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // JodaTimeAndroid.init(context);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            manager = new GridLayoutManager(context, mColumnCount);
            new NasaHistoricoPicsTask().execute();
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof INasaPictureListener) {
            mListener = (INasaPictureListener) context;
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

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(NasaPicture item);
    }

    private class NasaHistoricoPicsTask extends AsyncTask<Void, Void, List<NasaPicture>> {

        NasaApi fotodelDia = new NasaApi("dJLaK1IQk9N3fnNCam84bO9TZshz7su8k23doMLi");

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected List<NasaPicture> doInBackground(Void... voids) {

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = date1.plusDays(-30);

            listaImagenes = fotodelDia.getPicOfDateInterval(date2.toString(),date1.toString());
            Collections.reverse(listaImagenes);

            return listaImagenes;
        }

        @Override
        protected void onPostExecute(List<NasaPicture> s) {

            MypicRecyclerViewAdapter fragmentAdapter = new MypicRecyclerViewAdapter(s,context,mListener);
            recyclerView.setAdapter(fragmentAdapter);
            recyclerView.setLayoutManager(manager);

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                        scroll = true;
                    }
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItems = manager.getChildCount();
                    totalItems = manager.getItemCount();
                    scrollOutItems = manager.findFirstVisibleItemPosition();

                    if(scroll && (currentItems + scrollOutItems == totalItems)){
                        scroll = false;
                        count1 = count1++;
                        count2 = count2++;

                        day = timeBefore.minusMonths(count1).minusDays(1);
                        timeBefore = timeBefore.minusMonths(count2);
                        progressDialog = ProgressDialog.show(context,"", "Cargando más...", true);
                        progressDialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
                    }
                }
            });

        }
        public class LoadScroll extends AsyncTask<Void,Void, List<NasaPicture>>{

            @Override
            protected List<NasaPicture> doInBackground(Void... voids) {
                listaImagenes = nasaApi.getPicOfDateInterval(timeBefore.toString(), day.toString());

                return listaImagenes;
            }

            @Override
            protected void onPostExecute(List<NasaPicture> nasaPictures) {
                Collections.reverse(nasaPictures);
            }
        }
    }



}
