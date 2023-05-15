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

import java.util.ArrayList;
import java.util.List;

public class shopList extends AppCompatActivity implements View.OnClickListener {
    private Button btn_agregar;
    private ListView listView;
    private EditText editText;
    private List<String> productosLista = new ArrayList<>();
    private ArrayAdapter<String> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        btn_agregar = findViewById(R.id.btn_agregar);
        btn_agregar.setOnClickListener(this);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.textEdit);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_agregar:
                DBHelper dbHelper = new DBHelper(shopList.this);
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                String text = editText.getText().toString().trim();
                productosLista.add(text);
                editText.getText().clear();
                Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productosLista);
                listView.setAdapter(Adapter);
                Toast.makeText(this, "Producto añadido", Toast.LENGTH_SHORT).show();
        }
    }
}