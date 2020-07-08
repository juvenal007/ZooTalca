package com.example.marceloval.zootalca.DataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.marceloval.zootalca.Animales;

import java.util.ArrayList;
import java.util.List;

public class Crud {

    private ConexionHelper helper;
    private SQLiteDatabase basededatos;
    private ContentValues values;

    public Crud(Context context){
        helper = new ConexionHelper(context);
        values = new ContentValues();
    }

    public void insertar(Animales animales){
        basededatos = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.NOMBRE, animales.nombre);
        values.put(ConexionHelper.IMAGEN1, animales.imagen1);
        values.put(ConexionHelper.IMAGEN2, animales.imagen2);
        values.put(ConexionHelper.IMAGEN3, animales.imagen3);
        values.put(ConexionHelper.DESCRIPCION, animales.descripcion);
        basededatos.insert(ConexionHelper.TABLA, null, values);
        basededatos.close();
    }

    public void actualizar(Animales animales){
        basededatos = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.NOMBRE, animales.nombre);
        values.put(ConexionHelper.IMAGEN1, animales.imagen1);
        values.put(ConexionHelper.IMAGEN2, animales.imagen2);
        values.put(ConexionHelper.IMAGEN3, animales.imagen3);
        values.put(ConexionHelper.DESCRIPCION, animales.descripcion);
        String pk = String.valueOf(animales.id);
        basededatos.update(ConexionHelper.TABLA, values, ConexionHelper.ID+"=?", new String[]{pk});
        basededatos.close();
    }

    public Animales buscarAnimales(int id){
        Animales animales = new Animales();
        basededatos = helper.getReadableDatabase();
        Cursor cursor = basededatos.rawQuery("select * from "+ ConexionHelper.TABLA+" where id=?",
                new String[]{String.valueOf(id)});
        if (cursor.moveToNext()){
            animales.id = cursor.getInt(0);
            animales.nombre = cursor.getString(1);
            animales.imagen1 = cursor.getInt(2);
            animales.imagen2 = cursor.getInt(3);
            animales.imagen3 = cursor.getInt(4);
            animales.descripcion = cursor.getString(5);
        }
        basededatos.close();
        return animales;
    }

    public List<Animales> cafeList(){
        List<Animales> list = new ArrayList<>();
        basededatos = helper.getWritableDatabase();
        String sql = "select * from "+ ConexionHelper.TABLA;
        Cursor cursor = basededatos.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Animales animales = new Animales();
            animales.id = cursor.getInt(0);
            animales.nombre = cursor.getString(1);
            animales.imagen1 = cursor.getInt(2);
            animales.imagen2 = cursor.getInt(3);
            animales.imagen3 = cursor.getInt(4);
            animales.descripcion = cursor.getString(5);
            list.add(animales);
        }
        basededatos.close();
        return list;
    }

}
