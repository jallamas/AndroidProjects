package org.jallamas.calendareventsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class NewEventActivity extends AppCompatActivity implements View.OnClickListener {

    EditText title, description;
    Button save;
    CalendarView calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        getViews();
    }

    private void getViews() {
        title = findViewById(R.id.editTextTitle);
        description = findViewById(R.id.editTextDescrption);
        calendario = findViewById(R.id.calendarView);
        save = findViewById(R.id.buttonSave);
    }


    @Override
    public void onClick(View v) {

    }

    public void addEvent(){
        String eventTitle = String.valueOf(title.getText());
        LocalDate fecha = Instant.ofEpochMilli(calendario.getDate()).atZone(ZoneId.systemDefault()).toLocalDate();

        if(isEventAlreadyExist(eventTitle, fecha)){
            Toast.makeText(this,"El evento ya las puesto mostro",Toast.LENGTH_SHORT).show();
            return;
        }

        long calID = 3;
        long startMillis = 0;
        long endMillis = 0;
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(fecha.getYear(),fecha.getMonth().getValue(),fecha.getDayOfMonth(), 00, 00);
        startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(fecha.getYear(),fecha.getMonth().getValue(),fecha.getDayOfMonth(), 23, 59);
        endMillis = endTime.getTimeInMillis();

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, startMillis);
        values.put(CalendarContract.Events.DTEND, endMillis);
        values.put(CalendarContract.Events.TITLE, String.valueOf(title.getText()));
        values.put(CalendarContract.Events.DESCRIPTION, String.valueOf(description.getText()));
        values.put(CalendarContract.Events.CALENDAR_ID, calID);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
            Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
            long eventID = Long.parseLong(uri.getLastPathSegment());
            Toast.makeText(this,"Evento creado",Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
        }


    }

    private boolean isEventAlreadyExist(String eventTitle, LocalDate fecha) {

    }
}
