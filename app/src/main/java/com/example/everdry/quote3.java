package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class quote3 extends AppCompatActivity {

    Button next;
    String s1,s2,s3,s4,price_estimate;
    Boolean f1=false,f2=false;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote3);

        getSupportActionBar().setTitle("Quotation Generation");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        next = findViewById(R.id.next_page);

        Intent i = getIntent();
        s1 = i.getStringExtra("quote1");
        s2 = i.getStringExtra("quote2");
        price_estimate = i.getStringExtra("price_estimate");


        RadioGroup radioGroup1 = findViewById(R.id.coat);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                s3 = rb.getText().toString();
                f1 = true;
            }
        });

        RadioGroup radioGroup2 = findViewById(R.id.location);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                s4 = rb.getText().toString();
                f2 = true;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!f1 && !f2) {
                    Toast.makeText(quote3.this, "Please select Coating type & Location", Toast.LENGTH_SHORT).show();
                }
                else if(!f1) {
                    Toast.makeText(quote3.this, "Please select Coating type", Toast.LENGTH_SHORT).show();
                }
                else if(!f2) {
                    Toast.makeText(quote3.this, "Please select Location", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String name = snapshot.child(uid).child("userName").getValue(String.class);
                            String mobile = snapshot.child(uid).child("userMobileNumber").getValue(String.class);
                            String email = snapshot.child(uid).child("userEmail").getValue(String.class);
                            String count = snapshot.child(uid).child("count").getValue(String.class);

                            Intent intent = new Intent(quote3.this,quote4.class);

                            intent.putExtra("count",count);
                            intent.putExtra("name",name);
                            intent.putExtra("mobile",mobile);
                            intent.putExtra("email",email);
                            intent.putExtra("s1",s1);
                            intent.putExtra("s2",s2);
                            intent.putExtra("s3",s3);
                            intent.putExtra("s4",s4);
                            intent.putExtra("price_estimate",price_estimate);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });
                }

            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(quote3.this, quote2.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(quote3.this, quote2.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}