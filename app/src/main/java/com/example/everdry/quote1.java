package com.example.everdry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class quote1 extends AppCompatActivity {

    Button newq;
    Button repair;
    String price_estimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote1);

        getSupportActionBar().setTitle("Quotation Generation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        price_estimate = i.getStringExtra("price_estimate");

        newq = findViewById(R.id.newq);
        repair = findViewById(R.id.repair);

        newq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quote1.this, quote2.class);
                intent.putExtra("quote1","New");
                intent.putExtra("price_estimate",price_estimate);
                startActivity(intent);
                finish();
            }
        });

        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quote1.this, quote2.class);
                intent.putExtra("quote1","Repair");
                intent.putExtra("price_estimate",price_estimate);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(quote1.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(quote1.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}