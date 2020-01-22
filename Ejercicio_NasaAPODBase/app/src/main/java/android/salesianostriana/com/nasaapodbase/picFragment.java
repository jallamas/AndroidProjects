package android.salesianostriana.com.nasaapodbase;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.salesianostriana.com.api.NasaApi;
import android.salesianostriana.com.api.NasaPicture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;


public class picFragment extends Fragment {

    private int mColumnCount = 2;
    private INasaPictureListener mListener;
    private MypicRecyclerViewAdapter adapter;
    private List<NasaPicture> listaImagenes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public picFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            listaImagenes=new ArrayList<>();

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
                    + " debe implementar la interfaz INasaPictureListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private class NasaPicsTask extends AsyncTask<String, Void, String> {

        private MainActivity myActivity;
        private String apiKey="dJLaK1IQk9N3fnNCam84bO9TZshz7su8k23doMLi";

        public NasaPicsTask(MainActivity myActivity){
            this.myActivity=myActivity;
        }

        NasaApi nasaApi = new NasaApi(apiKey);

        @Override
        protected String doInBackground(String... strings) {
            listaImagenes=nasaApi.getPicOfDateInterval(DateTime.now().minusDays(30).toString(),DateTime.now().toString());

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            adapter = new MypicRecyclerViewAdapter(
                    context,
                    R.layout.fragment_pic,
                    listaImagenes);

            recyclerView.setAdapter(adapter);


            list.setAdapter(adapter);
        }
    }

}
