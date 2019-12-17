package com.juara.daftartamu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationForm extends AppCompatActivity {

    TextView txtAlamat, txtNama, txtJenisKelamin, txtTanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_form);



        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtJenisKelamin = findViewById(R.id.txtJenisKelamin);
        txtTanggal = findViewById(R.id.txtTanggal);

        txtNama.setText(getIntent().getStringExtra("nama"));
        txtAlamat.setText(getIntent().getStringExtra("alamat"));
        txtJenisKelamin.setText(getIntent().getStringExtra("jk"));
        txtTanggal.setText(getIntent().getStringExtra("reservation"));



    }
}
