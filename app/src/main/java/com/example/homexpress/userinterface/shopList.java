package com.example.homexpress.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.homexpress.R;
import com.example.homexpress.database.DBHelper;
import com.example.homexpress.database.DBProductos;

import java.util.ArrayList;
import java.util.List;

public class shopList extends AppCompatActivity{
    private Button btn_agregar;
    private EditText numProd, txtNombre, numCant, numPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);


        txtNombre = findViewById(R.id.txtNombre);
        numCant = findViewById(R.id.numCant);
        numPrecio = findViewById(R.id.numPrecio);
        btn_agregar = findViewById(R.id.btn_agregar);
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBProductos dbProductos = new DBProductos(shopList.this);
                long id = dbProductos.insertarDatos(txtNombre.getText().toString(), numCant.getText().toString(), numPrecio.getText().toString());
                if (id > 0) {
                    Toast.makeText(shopList.this, "Producto añadido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(shopList.this, "Error al añadir producto!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    /*public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_agregar:
                DBHelper dbHelper = new DBHelper(shopList.this);
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                String producto = editText.getText().toString().trim();
                int cant_prod =
                productosLista.add(text);
                editText.getText().clear();
                Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productosLista);
                listView.setAdapter(Adapter);
                Toast.makeText(this, "Producto añadido", Toast.LENGTH_SHORT).show();
        }
    }
     */
    }
}

