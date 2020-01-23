package android.salesianostriana.com.nasaapodbase;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DateSelectFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    static ISeleccionarFechaListener i;

    static DateSelectFragment newInstance(Activity activity) {
        i = (ISeleccionarFechaListener) activity;
        return new DateSelectFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        i.onFechaSeleccionada(year, month, day);
    }

}
