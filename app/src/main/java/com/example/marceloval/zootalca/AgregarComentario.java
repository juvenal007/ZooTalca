package com.example.marceloval.zootalca;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marceloval.zootalca.DataBase.Crud;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class AgregarComentario extends AppCompatActivity {

    private EditText nombre, comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_comentarios);

        nombre = findViewById(R.id.edit_nombre);
        comentario = findViewById(R.id.edit_comentario);

        String id = getIntent().getStringExtra("id");
        Crud crud = new Crud(this);
        Animales cafe = crud.buscarAnimales(Integer.parseInt(id));

        Toolbar toolbar_menu_opinion = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar_menu_opinion);
        setTitle("Agregar Comentario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void AgregarComentario(View view){
        Comentario cm = new Comentario();
        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        String nombree = nombre.getText().toString();
        String comentarioo = comentario.getText().toString();
        cm.id = id;
        cm.nombre = nombree;
        cm.comentario = comentarioo;
        insertarComentarios(cm);
        Log.e("INFO",nombree+comentarioo);
        finish();
    }
    public void insertarComentarios(Comentario c){
        String Url="http://raspberry.todojava.net/index.php/insertarComentario";
        RequestParams params = new RequestParams();
        params.put("id", c.id);
        params.put("nombre",c.nombre);
        params.put("comentario", c.comentario);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    String respuesta = new String(responseBody);
                    Toast.makeText(AgregarComentario.this, "Comentario Insertado :)", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


}
