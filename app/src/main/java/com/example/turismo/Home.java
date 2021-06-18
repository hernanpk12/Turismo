package com.example.turismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {
    ArrayList<Contenido> listadeDatos=new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore baseDatos= FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listado= findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearListado();

    }

    private void crearListado() {
        baseDatos.collection("Comidas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){

                            for(QueryDocumentSnapshot document: task.getResult()){
                                String titulo = document.get("titulo").toString();
                                String nombreArticulo = document.get("nombreArticulo").toString();
                                String lugarArticulo = document.get("lugarArticulo").toString();
                                String precioArticulo = document.get("PrecioArticulo").toString();
                                String descripcion = document.get("descripcion").toString();
                                String foto = document.get("foto").toString();

                                listadeDatos.add(new Contenido(titulo,nombreArticulo,lugarArticulo,precioArticulo,descripcion,foto));


                            }

                            Adaptadorlista adactador = new Adaptadorlista(listadeDatos);
                            listado.setAdapter(adactador);

                        }else {
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                        }

                    }
                });
    }



    public  void  cambiarIdioma(String lenguaje){
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono =getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());

    }

    //Metedo que pinta en menu en esta actividad
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Metodo que controla la accion del menu

    public  boolean onOptionsItemSelected(MenuItem opcion){
        int id =opcion.getItemId();

        switch (id){
            case (R.id.opcion1):
                Intent intent = new Intent(Home.this,perfilUsuario.class);
                startActivity(intent);
                break;
            case (R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent2 = new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;
            case (R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent3 = new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;

        }

        return super.onOptionsItemSelected(opcion);

    }
}