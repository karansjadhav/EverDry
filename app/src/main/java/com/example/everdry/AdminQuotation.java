package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminQuotation extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapterAdminQuotation myAdapter;
    ArrayList<UsersQuotations> list;

    private ProgressBar progressBar;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quotation);

        getSupportActionBar().setTitle("Admin Quotations");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.admin_quotation_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapterAdminQuotation(this,list);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.child(uid).child("quotations").getChildren()) {
                    for(DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        UsersQuotations q = dataSnapshot2.getValue(UsersQuotations.class);
                        list.add(q);
                    }
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(AdminQuotation.this, AdminHome.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AdminQuotation.this, AdminHome.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}