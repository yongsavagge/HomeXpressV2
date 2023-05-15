package com.example.homexpress.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.homexpress.R;
import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class prodList extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private ListView listViewProd;
    private EditText editTextProd;
    private EditText editTextNumber;

    private List<String> productosList = new ArrayList<>();
    private List<String> preciosList = new ArrayList<>();
    private List<String> produList = new ArrayList<>();
    private ArrayAdapter<String> Adapter;
    private ArrayAdapter<String> Adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_list);

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        listViewProd = findViewById(R.id.listViewProd);
        editTextProd = findViewById(R.id.editTextProd);
        editTextNumber = findViewById(R.id.editTextNumber);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_add:
            String producto = editTextProd.getText().toString().trim();
            String precio = editTextNumber.getText().toString().trim();
            String conjunto = producto + '\n' + precio;
            productosList.add(conjunto);
            editTextProd.getText().clear();
            editTextNumber.getText().clear();
            Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productosList);
            listViewProd.setAdapter(Adapter);
                Toast.makeText(this, "Producto y precio añadido", Toast.LENGTH_SHORT).show();
        }
    }
}