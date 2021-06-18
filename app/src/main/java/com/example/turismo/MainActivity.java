package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView nombreArt,lugarArt,precioArt,descripcionArt;
    ImageView fotoArt;
    FirebaseFirestore baseDatos= FirebaseFirestore.getInstance();
    Contenido Articulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreArt = findViewById(R.id.nombreMain);
        lugarArt = findViewById(R.id.lugarMain);
        precioArt = findViewById(R.id.precioMain);
        descripcionArt = findViewById(R.id.descripcionMain);
        fotoArt = findViewById(R.id.fotoMain);


        Articulo = (Contenido) getIntent().getSerializableExtra("contenido");

        nombreArt.setText(Articulo.getNombreArticulo());
        lugarArt.setText(Articulo.getLugarArticulo());
        precioArt.setText(Articulo.getPrecioArituculo());
        descripcionArt.setText(Articulo.getDescripcionArticulo());
        /*fotoArt.setImageResource(Articulo.getFoto());*/

        Picasso.with(this).load(Articulo.getFoto()).resize(1000,950)
                .centerInside().into(fotoArt);



       /* Picasso.with(fotoArt.getContext())
                .load(Articulo.getFoto())
                .into(fotoArt);*/


    }
}