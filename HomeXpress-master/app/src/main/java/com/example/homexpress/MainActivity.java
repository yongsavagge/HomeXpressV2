package com.example.homexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_shop_list;
    Button btn_lug_interes;
    Button btn_prod_list;
    Button btn_prod_inv;
    Button btn_reminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_shop_list=(Button)findViewById(R.id.btn_shop_list);
        btn_lug_interes=(Button)findViewById(R.id.btn_lug_interes);
        btn_prod_list=(Button)findViewById(R.id.btn_prod_list);
        btn_prod_inv=(Button)findViewById(R.id.btn_prod_inv);
        btn_reminder=(Button)findViewById(R.id.btn_reminder);
        btn_shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopList = new Intent(MainActivity.this, shopList.class);
                startActivity(shopList);
            }
        });
        btn_lug_interes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lugInteres = new Intent(MainActivity.this, lugInteres.class);
                startActivity(lugInteres);
            }
        });
        btn_prod_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prodList = new Intent(MainActivity.this, prodList.class);
                startActivity(prodList);
            }
        });
        btn_prod_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prodInv = new Intent(MainActivity.this, prodInv.class);
                startActivity(prodInv);
            }
        });
        btn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reminder = new Intent(MainActivity.this, reminder.class);
                startActivity(reminder);
            }
        });
    }
}