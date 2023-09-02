package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextView user_name, name,mobile,email,userid;
    ImageView edit;

    String uname,umobile,uemail;

    private ProgressBar progressBar;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

        progressBar.setVisibility(View.VISIBLE);


        user_name = findViewById(R.id.user_name);
        name = findViewById(R.id.full_name);
        mobile = findViewById(R.id.mobile_number);
        email = findViewById(R.id.email_address);
        userid = findViewById(R.id.user_id);
        edit = findViewById(R.id.edit);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uname = snapshot.child(uid).child("userName").getValue(String.class);
                umobile = snapshot.child(uid).child("userMobileNumber").getValue(String.class);
                uemail = snapshot.child(uid).child("userEmail").getValue(String.class);

                user_name.setText(uname);
                name.setText(uname);
                mobile.setText(umobile);
                email.setText(uemail);
                userid.setText(uid);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this,EditProfile.class);
                i.putExtra("name",uname);
                i.putExtra("mobile",umobile);
                i.putExtra("email",uemail);
                startActivity(i);
                finish();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}