package com.example.everdry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    EditText name,mobile;
    TextView user_name,email,userid;
    Button update;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_name = findViewById(R.id.user_name);
        name = findViewById(R.id.full_name);
        mobile = findViewById(R.id.mobile_number);
        email = findViewById(R.id.email_address);
        userid = findViewById(R.id.user_id);
        update = findViewById(R.id.update);

        Intent i = getIntent();
        user_name.setText(i.getStringExtra("name"));
        name.setText(i.getStringExtra("name"));
        mobile.setText(i.getStringExtra("mobile"));
        email.setText(i.getStringExtra("email"));
        userid.setText(uid);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String m = mobile.getText().toString();

                databaseReference.child(uid).child("userName").setValue(n);
                databaseReference.child(uid).child("userMobileNumber").setValue(m);

                Intent i = new Intent(EditProfile.this,Profile.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(EditProfile.this,Profile.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(EditProfile.this, Profile.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}