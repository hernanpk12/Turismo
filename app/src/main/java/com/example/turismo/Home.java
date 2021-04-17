package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ArrayList<Contenido> listadeDatos=new ArrayList<>();

    RecyclerView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listado= findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearListado();



        Adaptadorlista adactador = new Adaptadorlista(listadeDatos);
        listado.setAdapter(adactador);
    }

    private void crearListado() {
        listadeDatos.add(new Contenido("Hoteles","La Macarena","Caño Cristales parte baja","1600000",getString(R.string.descripcion1),R.drawable.imagen1));
        listadeDatos.add(new Contenido("Comidas","Fiambre","Caño Cristales","10000",getString(R.string.descripcion2),R.drawable.comida2));
    }
}