package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Product extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setTitle("Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Product.this,BuyProduct.class);
                i1.putExtra("product","1");
                i1.putExtra("brochure","https://drive.google.com/file/d/1aGx0kaOI1AQeuNiiwbckWFWuCyIsEAxt/view?usp=sharing");
                startActivity(i1);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Product.this,BuyProduct.class);
                i2.putExtra("product","2");
                i2.putExtra("brochure","https://drive.google.com/file/d/1hHxnIIa-rPIpesO2eADOy4J9FwfCbYfy/view?usp=sharing");
                startActivity(i2);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Product.this,BuyProduct.class);
                i3.putExtra("product","3");
                i3.putExtra("brochure","https://drive.google.com/file/d/1mJHSaXWD-gK_IbszyYzKgD8Zqr7_sWwu/view?usp=sharing");
                startActivity(i3);
                finish();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Product.this,BuyProduct.class);
                i4.putExtra("product","4");
                i4.putExtra("brochure","https://drive.google.com/file/d/1I6C9ih9zcWNbZW0M5bAauC2dYyWdt4lm/view?usp=sharing");
                startActivity(i4);
                finish();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Product.this,BuyProduct.class);
                i5.putExtra("product","5");
                i5.putExtra("brochure","https://drive.google.com/file/d/1n7ewichdpnaDrZdBAny3qIpRswQ_5seU/view?usp=sharing");
                startActivity(i5);
                finish();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Product.this,BuyProduct.class);
                i6.putExtra("product","6");
                i6.putExtra("brochure","https://drive.google.com/file/d/1Ti7RwH_0Y2mTicf30zrO6O00BFM1HU0u/view?usp=sharing");
                startActivity(i6);
                finish();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(Product.this,BuyProduct.class);
                i7.putExtra("product","7");
                i7.putExtra("brochure","");
                startActivity(i7);
                finish();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(Product.this,BuyProduct.class);
                i8.putExtra("product","8");
                i8.putExtra("brochure","");
                startActivity(i8);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Product.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Product.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}