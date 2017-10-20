package com.example.marlon.matriculasjm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Acerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
    }
    public void salir(View v) {
        finish();
}}
