package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth mAuth;
    Button quote,product;
    FirebaseUser user;

    ImageView kyc,quiz,price,dealer;
    ImageView ges1,ges2,ges3,ges4,ges5,ges6,ges7;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("EverDry");

        mAuth = FirebaseAuth.getInstance();

        quote = findViewById(R.id.quote);
        product = findViewById(R.id.product);

        kyc = findViewById(R.id.kyc);
        quiz = findViewById(R.id.quiz);
        price = findViewById(R.id.price);
        dealer = findViewById(R.id.dealer);
        ges1 = findViewById(R.id.ges1);
        ges2 = findViewById(R.id.ges2);
        ges3 = findViewById(R.id.ges3);
        ges4 = findViewById(R.id.ges4);
        ges5 = findViewById(R.id.ges5);
        ges6 = findViewById(R.id.ges6);
        ges7 = findViewById(R.id.ges7);

        user = mAuth.getCurrentUser();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(user==null) {
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
            finish();
        }

        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,quote1.class);
                intent.putExtra("price_estimate","0");
                startActivity(intent);
                finish();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Product.class);
                startActivity(intent);
                finish();
            }
        });

        kyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KYC.class);
                startActivity(intent);
                finish();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Quiz.class);
                startActivity(intent);
                finish();
            }
        });

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,quote1.class);
                intent.putExtra("price_estimate","1");
                startActivity(intent);
                finish();
            }
        });

        dealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/LgXRvgh6mfekmyfW8"));
                startActivity(intent);
            }
        });

        ges1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","1");
                intent.putExtra("text1","Product used:  EWC");
                intent.putExtra("text2","Process:   White coating on terrace.");
                intent.putExtra("text3","Site : Menon bungalow, Kadamwadi, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","2");
                intent.putExtra("text1","Product used:  APP membrane");
                intent.putExtra("text2","Process:   Side wall and bottom surface APP membrane heating and fixing process.");
                intent.putExtra("text3","Site : Highlands Club, Shiroli, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","3");
                intent.putExtra("text1","Product used:  EWC");
                intent.putExtra("text2","Process:   Cleaning Terrace before coating");
                intent.putExtra("text3","Site : Menon bungalow, Kadamwadi, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","4");
                intent.putExtra("text1","Product used:  EWC");
                intent.putExtra("text2","Process:   Making of (mixing) of EWC.");
                intent.putExtra("text3","Site : Menon bungalow, Kadamwadi, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","5");
                intent.putExtra("text1","Product used:  EWC");
                intent.putExtra("text2","Process:   Cleaning Terrace before coating");
                intent.putExtra("text3","Site : Menon bungalow, Kadamwadi, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","6");
                intent.putExtra("text1","Product used:  EWC");
                intent.putExtra("text2","Process:   Cleaning Terrace before coating");
                intent.putExtra("text3","Site : Menon bungalow, Kadamwadi, Kolhapur");
                startActivity(intent);
                finish();
            }
        });

        ges7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Video.class);
                intent.putExtra("video","7");
                intent.putExtra("text1","Product used:  APP membrane");
                intent.putExtra("text2","Process:   fixing membrane to bottom surface of bathroom");
                intent.putExtra("text3","Site : HighLands club, Shiroli, Kolhapur");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.profile:
                    Intent intent = new Intent(MainActivity.this,Profile.class);
                    startActivity(intent);
                    finish();
                break;

            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START, false);
                break;

            case R.id.quotation:
                Intent i1 = new Intent(MainActivity.this,Quotations.class);
                startActivity(i1);
                finish();
                break;

            case R.id.cart:
                Intent i2 = new Intent(MainActivity.this,Cart.class);
                startActivity(i2);
                finish();
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(i3);
                finish();
                break;

            case R.id.about:
                Intent i4 = new Intent(MainActivity.this,About.class);
                startActivity(i4);
                finish();
                break;

            default:
                return true;
        }
        return false;
    }

    public void onBackPressed()
    {
        finishAffinity();
        System.exit(0);
    }
}