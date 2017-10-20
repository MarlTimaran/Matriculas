package com.example.marlon.matriculasjm.Models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marlon.matriculasjm.R;

import java.util.List;

/**
 * Created by marlon on 19/10/17.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView municipio, establecimento;
        private CardView card;


        public ViewHolder(View itemView) {
            super(itemView);

            establecimento =(TextView)itemView.findViewById(R.id.tv2);
            municipio =(TextView)itemView.findViewById(R.id.tv1);
            //card=(CardView)itemView.findViewById(R.id.card);
        }
    }

    public List<Matriculas> lista;

    public Adaptador(List<Matriculas> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.establecimento.setText(lista.get(position).getNombreEstablecimiento());
        holder.municipio.setText(lista.get(position).getMunicipio());

        //RollIn Landing DropOut BounceIn FadeIn FlipInX RotateIn SlideInLeft ZoomIn
        //YoYo.with(Techniques.ZoomIn).playOn(holder.card);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}