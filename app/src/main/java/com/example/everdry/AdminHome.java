package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mAuth;
    Button quote,product;
    FirebaseUser user;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        getSupportActionBar().setTitle("EverDry (Admin)");

        mAuth = FirebaseAuth.getInstance();

        quote = findViewById(R.id.quote);
        product = findViewById(R.id.product);

        user = mAuth.getCurrentUser();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(user==null) {
            Intent intent = new Intent(AdminHome.this,SignInActivity.class);
            startActivity(intent);
            finish();
        }

        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this,AdminQuotation.class);
                startActivity(intent);
                finish();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this,AdminCart.class);
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

            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START, false);
                break;

            case R.id.quotation:
                Toast.makeText(AdminHome.this, "Quotation", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(AdminHome.this,AdminQuotation.class);
                startActivity(i1);
                finish();
                break;

            case R.id.cart:
                Toast.makeText(AdminHome.this, "Cart", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(AdminHome.this,AdminCart.class);
                startActivity(i2);
                finish();
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(AdminHome.this, "Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminHome.this,SignInActivity.class);
                startActivity(intent);
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