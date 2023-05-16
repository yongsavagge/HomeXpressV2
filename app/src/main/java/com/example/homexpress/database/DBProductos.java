package com.example.homexpress.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBProductos extends DBHelper{

    Context context;

    public DBProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarDatos(String nombre_prod, String cant_prod, String precio_prod) {
        long id = 0;
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre_prod", nombre_prod);
            values.put("cant_prod", cant_prod);
            values.put("precio_prod", precio_prod);
            id = db.insert(TABLE_PRODUCTOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

}
