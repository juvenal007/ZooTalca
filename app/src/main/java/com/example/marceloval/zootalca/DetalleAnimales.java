package com.example.marceloval.zootalca;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marceloval.zootalca.DataBase.Crud;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DetalleAnimales extends AppCompatActivity {

    private TextView nombre,descripcion;
    private ImageView foto2,foto3;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_animales);

        Crud crud = new Crud(this);
        String id = getIntent().getStringExtra("id");
        Log.e("INFO", id+" ********* ");
        Animales animales = crud.buscarAnimales(Integer.parseInt(id));
        buscarComentarios(Integer.parseInt(id));
        Toolbar toolbar_menu_detalle = findViewById(R.id.my_toolbar);
        Log.e("INFO", animales.nombre+" ********* ");
        setSupportActionBar(toolbar_menu_detalle);
        setTitle("Zoologio Talca");
        getSupportActionBar().setSubtitle("Animal: "+animales.nombre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.item_nombre);
        nombre.setText(animales.nombre);

        foto2 = findViewById(R.id.item_foto_detalle);
        foto2.setImageResource(animales.imagen2);

        foto3 = findViewById(R.id.item_foto_detalle2);
        foto3.setImageResource(animales.imagen3);

        descripcion = findViewById(R.id.item_descripcion);
        descripcion.setText(animales.descripcion);
        recycler = findViewById(R.id.lista_recycler_comentario);

    }

    @Override
    protected void onResume() {
        String id = getIntent().getStringExtra("id");
        buscarComentarios(Integer.parseInt(id));

        super.onResume();
    }

    public void buscarComentarios(int id){
        String Url="http://raspberry.todojava.net/index.php/buscarComentarios";
        RequestParams params = new RequestParams();
        params.put("id",id);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    String respuesta = new String(responseBody);
                    addComentarios(respuesta);
                    Log.e("INFO", respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void addComentarios(String respuesta){
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lm);

        try {

            List<Comentario> list = new ArrayList<>();
            JSONArray json = new JSONArray(respuesta);

            for (int i = 0; i < json.length(); i++){
                Comentario cm = new Comentario();
                cm.id = json.getJSONObject(i).getInt("id");
                cm.nombre = json.getJSONObject(i).getString("nombre");
                cm.comentario = json.getJSONObject(i).getString("comentario");
                list.add(cm);
            }

            AdaptadorComentario adaptador = new AdaptadorComentario(list, this, R.layout.item_comentario);
            recycler.setAdapter(adaptador);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void agregarCom(View view) {
        String id = getIntent().getStringExtra("id");
        Intent intent = new Intent(this, AgregarComentario.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}