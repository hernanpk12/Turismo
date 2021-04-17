package com.example.turismo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptadorlista extends RecyclerView.Adapter<Adaptadorlista.viewHolder> {
    ArrayList<Contenido> listaDeDatos;

    public Adaptadorlista(ArrayList<Contenido> listaDeDatos) {
        this.listaDeDatos = listaDeDatos;
    }


    @NonNull
    @Override
    public Adaptadorlista.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItemListado= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new viewHolder(vistaItemListado);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptadorlista.viewHolder holder, int position) {
        holder.actualizarDatosItem(listaDeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaDeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView foto;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.fotoArticulo);
            titulo = itemView.findViewById(R.id.titulo);
        }

        public void actualizarDatosItem(Contenido datos) {


            foto.setImageResource(datos.getFotoArticulo());
            titulo.setText(datos.getTitulo());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
                    intent.putExtra("Contenido",datos);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
