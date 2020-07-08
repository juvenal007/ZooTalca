package com.example.marceloval.zootalca.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.marceloval.zootalca.R;

public class ConexionHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DataBase";
    private static final int VERSION = 1;

    public static final String TABLA = "animales";
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String IMAGEN1 = "imagen1";
    public static final String IMAGEN2 = "imagen2";
    public static final String IMAGEN3 = "imagen3";
    public static final String DESCRIPCION = "descripcion";

    public ConexionHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String script = "";
        script = "create table "+TABLA+"("+ID+" integer primary key autoincrement,";
        script +=NOMBRE+" text,";
        script +=IMAGEN1+" int,";
        script +=IMAGEN2+" int,";
        script +=IMAGEN3+" int,";
        script +=DESCRIPCION+" text";
        script +=");";
        sqLiteDatabase.execSQL(script);
        sqLiteDatabase.execSQL("insert into "+TABLA+" values(null, 'Rey León',"+R.drawable.animal1+","+R.drawable.animal1m1+","+R.drawable.animal1m1m1+",'El león forma parte de la familia de los félidos del género Panthera')");
        sqLiteDatabase.execSQL("insert into "+TABLA+" values(null, 'Tortuga Taruga',"+R.drawable.animal2+","+R.drawable.animal2m2+","+R.drawable.animal2m2m2+",'Las tortugas marinas comen coral y las más carnívoras comen pequeños invertebrados.')");
        sqLiteDatabase.execSQL("insert into "+TABLA+" values(null, 'Ovejita bee',"+R.drawable.animal3+","+R.drawable.animal3m3+","+R.drawable.animal3m3m3+",'Tiene cuatro patas que terminan en pezuñas. Algunas razas poseen dos cuernos en su cabeza.')");
        sqLiteDatabase.execSQL("insert into "+TABLA+" values(null, 'Oso Pandarian',"+R.drawable.animal4+","+R.drawable.animal4m4+","+R.drawable.animal4m4m4+",'El oso panda gigante es un animal grande, parecido a un oso, con pelaje blanco largo.')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}