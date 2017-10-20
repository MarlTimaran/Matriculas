package com.example.marlon.matriculasjm.datosApi;

import com.example.marlon.matriculasjm.Models.Matriculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by marlon on 19/10/17.
 */

public interface Datos {
    @GET("5dgd-hu6w.json")
    Call<List<Matriculas>> obtenerListaMatriculas();
}
