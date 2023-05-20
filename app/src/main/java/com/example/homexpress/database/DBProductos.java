package com.example.homexpress.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.homexpress.entidades.Producto;

import java.util.ArrayList;

public class DBProductos extends DBHelper {

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

    public ArrayList<Producto> mostrarProductos() {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto producto = null;
        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS, null);
        if (cursorProducto.moveToFirst()) {
            do {
                producto = new Producto();
                producto.setTxtnombre(cursorProducto.getString(0));
                producto.setNumCant(cursorProducto.getInt(1));
                producto.setNumPrecio(cursorProducto.getInt(2));
                listaProductos.add(producto);
            } while (cursorProducto.moveToNext());

        }
        cursorProducto.close();
        return listaProductos;
    }
    public Producto verProducto(int id) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Producto producto = null;
        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS + "WHERE id = " + id + " LIMIT 1", null);
        if (cursorProducto.moveToFirst()) {
                producto = new Producto();
                producto.setTxtnombre(cursorProducto.getString(0));
                producto.setNumCant(cursorProducto.getInt(1));
                producto.setNumPrecio(cursorProducto.getInt(2));
        }
        cursorProducto.close();
        return producto;
    }
}
