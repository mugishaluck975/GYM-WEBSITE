package com.example.client_reg_form;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView date;
    EditText surname,firstname,address;
    Button profile ,reset;
    RadioButton male,female;
    CheckBox football,jogging,singing,swimming,biking,dancing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        date = findViewById(R.id.txtdate);
        profile = findViewById(R.id.profile);
        reset = findViewById(R.id.reset);
        surname = findViewById(R.id.surnametxt);
        firstname = findViewById(R.id.firstnametxt);
        address = findViewById(R.id.addresstxt);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        football = findViewById(R.id.football);
        jogging = findViewById(R.id.jogging);
        singing = findViewById(R.id.singing);
        swimming = findViewById(R.id.swimming);
        biking = findViewById(R.id.biking);
        dancing = findViewById(R.id.dancing);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog pickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },Year,month,Day);
                pickerDialog.show();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Surname = surname.getText().toString();
                String Firstname = firstname.getText().toString();
                String Address = address.getText().toString();
                String gender = male.isChecked()?"Male":"Female";
                String Date = date.getText().toString();
                StringBuilder sportactivities = new StringBuilder();
                if(football.isChecked())sportactivities.append("Football");
                if(jogging.isChecked())sportactivities.append("Jogging");
                if(singing.isChecked())sportactivities.append("Singing");
                if(swimming.isChecked())sportactivities.append("Swimming");
                if(biking.isChecked())sportactivities.append("Biking");
                if(dancing.isChecked())sportactivities.append("Dancing");

                Intent Sendalldata_to_new_activity = new Intent(MainActivity.this, View_Summary.class);
                Sendalldata_to_new_activity.putExtra("SIRNAME  ",Surname);
                Sendalldata_to_new_activity.putExtra("FIRSTNAME ",Firstname);
                Sendalldata_to_new_activity.putExtra("ADDRESS ",Address);
                Sendalldata_to_new_activity.putExtra("GENDER ",gender);
                Sendalldata_to_new_activity.putExtra("DATE ",Date);
                Sendalldata_to_new_activity.putExtra("SPORTSACTIVITIES ",Sendalldata_to_new_activity.toString());
                startActivity(Sendalldata_to_new_activity);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}