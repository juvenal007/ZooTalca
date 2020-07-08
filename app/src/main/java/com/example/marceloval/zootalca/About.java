package com.example.marceloval.zootalca;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar_menu_about = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar_menu_about);
        setTitle("Acerca de los Creadores");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
