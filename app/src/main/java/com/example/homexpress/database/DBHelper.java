package com.example.homexpress.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NOMBRE = "shopxpress.db";
    public static final String TABLE_PRODUCTOS = "t_productos";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "id_producto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_prod TEXT NOT NULL," +
                "cant_prod INTEGER NOT NULL," +
                "precio_prod INTEGER NOT NULL)");
    }
    // en caso de que se cambie la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PRODUCTOS);
        onCreate(sqLiteDatabase);
    }
}
