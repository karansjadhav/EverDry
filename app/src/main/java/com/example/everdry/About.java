package com.example.everdry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class About extends AppCompatActivity {

    ImageView w,i,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About Us");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        w = findViewById(R.id.what);
        i = findViewById(R.id.insta);
        c = findViewById(R.id.contact);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://wa.me/";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url+"9370732391"));
                startActivity(i);
            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://instagram.com/gaurinengineeringservices07?igshid=MzRlODBiNWFlZA==";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9370732391"));
                startActivity(i);
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(About.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(About.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}