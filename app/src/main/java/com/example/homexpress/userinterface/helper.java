package com.example.homexpress.userinterface;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homexpress.R;
import com.example.homexpress.database.DBProductos;
import com.example.homexpress.entidades.Producto;

public class helper extends AppCompatActivity {

    EditText txtNombre, txtCantidad, txtPrecio;
    Button btn_guardar;

    Producto producto;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helper);

        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);
        btn_guardar = findViewById(R.id.btn_guardar);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }
        DBProductos dbProductos = new DBProductos(helper.this);
        producto = dbProductos.verProducto(id);

        if(producto != null){
            txtNombre.setText(producto.getTxtnombre());
            txtCantidad.setText(producto.getNumCant());
            txtPrecio.setText(producto.getNumPrecio());
            btn_guardar.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtCantidad.setInputType(InputType.TYPE_NULL);
            txtPrecio.setInputType(InputType.TYPE_NULL);
        }
    }
}
