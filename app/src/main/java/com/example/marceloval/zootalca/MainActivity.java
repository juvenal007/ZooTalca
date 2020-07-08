package com.example.marceloval.zootalca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marceloval.zootalca.DataBase.Crud;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar_main = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar_main);
        setTitle("ZooTalca");
        getSupportActionBar().setSubtitle("-. Abre sus puertas .-");

        RecyclerView rc = findViewById(R.id.lista_recycler);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rc.setLayoutManager(lm);

        Crud crud = new Crud(this);
        List<Animales> list = crud.cafeList();
        AdaptadorAnimales adaptador = new AdaptadorAnimales(list,
                this, R.layout.item_animales);
        rc.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                about();
                break;
        }
        return true;
    }

    public void about(){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

}
