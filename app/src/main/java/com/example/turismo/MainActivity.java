package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nombreArt,lugarArt,precioArt,descripcionArt,titulo;
    ImageView fotoArt;

    Contenido Articulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = findViewById(R.id.titulo);
        nombreArt = findViewById(R.id.nombreMain);
        lugarArt = findViewById(R.id.lugarMain);
        precioArt = findViewById(R.id.precioMain);
        descripcionArt = findViewById(R.id.descripcionMain);
        fotoArt = findViewById(R.id.fotoMain);

        Articulo = (Contenido) getIntent().getSerializableExtra("Contenido");

        titulo.setText(Articulo.getTitulo());
        nombreArt.setText(Articulo.getNombreArticulo());
        lugarArt.setText(Articulo.getLugarArticulo());
        precioArt.setText(Articulo.getPrecioArituculo());
        descripcionArt.setText(Articulo.getDescripcionArticulo());
        fotoArt.setImageResource(Articulo.getFotoArticulo());



    }
}