package com.example.everdry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class quote2 extends AppCompatActivity {

    Button roof,terrace,wall,watertank,bathroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote2);

        getSupportActionBar().setTitle("Quotation Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        roof = findViewById(R.id.roof);
        terrace = findViewById(R.id.terrace);
        wall = findViewById(R.id.wall);
        watertank = findViewById(R.id.watertank);
        bathroom = findViewById(R.id.bathroom);

        Intent i = getIntent();
        String s = i.getStringExtra("quote1");
        String price_estimate = i.getStringExtra("price_estimate");

        Intent intent = new Intent(quote2.this, quote3.class);
        intent.putExtra("quote1",s);
        intent.putExtra("price_estimate",price_estimate);

        roof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("quote2","Roof");
                startActivity(intent);
            }
        });

        terrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("quote2","Terrace");
                startActivity(intent);
            }
        });

        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("quote2","Wall");
                startActivity(intent);
            }
        });

        watertank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("quote2","Watertank");
                startActivity(intent);
                finish();
            }
        });

        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("quote2","Bathroom");
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(quote2.this, quote1.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(quote2.this, quote1.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}