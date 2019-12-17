package com.juara.daftartamu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReservasiForm extends AppCompatActivity {


    EditText txtNama, txtAlamat;
    RadioButton rbtPria, rbtWanita;
    CalendarView cv;
    Button btnSubmit;
    RadioGroup rg;
    String selectedDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);

        rg = findViewById(R.id.rg);

        rbtPria = findViewById(R.id.rbtPria);
        rbtWanita = findViewById(R.id.rbtWanita);

        cv = findViewById(R.id.calendarView);

        btnSubmit = findViewById(R.id.btnSubmit);



        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
                Date myDate = myCalendar.getTime();
                 selectedDates = sdf.format(myDate);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ReservasiForm.this, ConfirmationForm.class);
                intent.putExtra("nama",txtNama.getText().toString());
                intent.putExtra("alamat",txtAlamat.getText().toString());

                if (rg.getCheckedRadioButtonId() ==  R.id.rbtPria){
                    intent.putExtra("jk","Pria");
                }else{
                    intent.putExtra("jk","wanita");
                }


                intent.putExtra("reservation",selectedDates);

                startActivity(intent);



            }
        });



        //hello from dewa
    }
}
