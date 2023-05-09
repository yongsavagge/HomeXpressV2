package com.example.homexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class prodInv extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> nombre = new ArrayList<>();
    private ArrayList<String> cant = new ArrayList<>();
    private TableLayout table;
    private Button btn_anadir;
    private EditText etProd;
    private EditText etCant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_inv);

        etProd = findViewById(R.id.etProd);
        etCant = findViewById(R.id.etCant);
        btn_anadir = findViewById(R.id.btn_anadir);
        btn_anadir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_anadir:
                String producto = etProd.getText().toString().trim();
                String cantidad = etCant.getText().toString().trim();
                nombre.add(producto);
                cant.add(cantidad);
                etProd.getText().clear();
                etCant.getText().clear();

                TableLayout table = (TableLayout) findViewById(R.id.tabla_1);
                TableRow row = new TableRow(this);
                TextView text1 = new TextView(this);
                TextView text2 = new TextView(this);

                text1.setText(producto);
                text2.setText(cantidad);

                row.addView(text1);
                row.addView(text2);
                table.addView(row);

        }
    }
}