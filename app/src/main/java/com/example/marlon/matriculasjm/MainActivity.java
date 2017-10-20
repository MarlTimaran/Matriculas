package com.example.marlon.matriculasjm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.marlon.matriculasjm.Models.Adaptador;
import com.example.marlon.matriculasjm.Models.Matriculas;
import com.example.marlon.matriculasjm.datosApi.Datos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    public final static String TAG="DATOS INSTITUCIONES";



    private RecyclerView view;
    private Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(RecyclerView)findViewById(R.id.rv1);
        view.setLayoutManager(new LinearLayoutManager(this));

        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void obtenerDatos(View v) {

        Datos service = retrofit.create(Datos.class);
        final Call<List<Matriculas>> matriculaCall = service.obtenerListaMatriculas();

        matriculaCall.enqueue(new Callback<List<Matriculas>>() {
            @Override
            public void onResponse(Call<List<Matriculas>> call, Response<List<Matriculas>> response) {
                if (response.isSuccessful()) {
                    List institucion = response.body();
                    for (int i = 0; i < institucion.size(); i++) {
                        Matriculas ins = (Matriculas) institucion.get(i);
                        adaptador = new Adaptador(institucion);
                        view.setAdapter(adaptador);


                    }
                } else {

                    Toast notificacion = Toast.makeText(MainActivity.this, "Error....", Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }

            @Override
            public void onFailure(Call<List<Matriculas>> call, Throwable t) {

                Toast notificacion = Toast.makeText(MainActivity.this, "Error....", Toast.LENGTH_LONG);
                notificacion.show();
            }
        });
    }
    public void Acerca(View V)
    {
        Intent i = new Intent(this, Acerca.class );
        startActivity(i);
    }
}