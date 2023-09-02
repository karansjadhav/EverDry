package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class CheckOut extends AppCompatActivity  {

    ImageView image;
    TextView p_name, p_offer1, p_offer2, p_price;
    TextView c_name, c_mobile;
    TextView delivery1,delivery2;
    EditText c_address;
    TextView f_price, f_discount, f_total_price;
    Button brochure,checkout;

    private ProgressBar progressBar;

    String pid,pname,poffer,pdelivery="Free Delivery",ppayment="Offline",paddress,pprice;
    String uname,umobile;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar);
        delivery1 = findViewById(R.id.delivery1);
        delivery2 = findViewById(R.id.delivery2);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

        progressBar.setVisibility(View.VISIBLE);

        image = findViewById(R.id.image);
        p_name = findViewById(R.id.p_name);
        p_offer1 = findViewById(R.id.p_offer1);
        p_offer2 = findViewById(R.id.p_offer2);
        p_price = findViewById(R.id.p_price);
        c_name = findViewById(R.id.c_name);
        c_mobile = findViewById(R.id.c_mobile);
        c_address = findViewById(R.id.c_address);
        f_price = findViewById(R.id.f_price);
        f_discount = findViewById(R.id.f_discount);
        f_total_price = findViewById(R.id.f_total_cost);

        //Button
        brochure = findViewById(R.id.brochure1);
        checkout = findViewById(R.id.checkout);

        Intent i = getIntent();
        String s = i.getStringExtra("image");

        pname = i.getStringExtra("product");
        p_name.setText(pname);

        poffer = i.getStringExtra("dis1");
        p_offer1.setText(poffer);

        p_offer2.setText("₹" + i.getStringExtra("dis2"));

        p_price.setText("₹" + i.getStringExtra("price"));

        f_price.setText("₹" + i.getStringExtra("dis3"));
        f_discount.setText(i.getStringExtra("dis1"));

        pprice = i.getStringExtra("price");
        f_total_price.setText("₹" +pprice);

        int z = Integer.parseInt(pprice);
        z = z + 50;

        String bro = i.getStringExtra("brochure");

        if(s.equals("1")) {
            image.setImageResource(R.drawable.a1);
        }
        else if(s.equals("2")) {
            image.setImageResource(R.drawable.a2);
            pprice = Integer.toString(z);
            delivery1.setText("Delivery Charge: ₹50");
            delivery2.setText("₹50");
            f_total_price.setText("₹" + pprice);
            pdelivery = "Delivery: ₹50";
        }
        else if(s.equals("3")) {
            image.setImageResource(R.drawable.a3);
        }
        else if(s.equals("4")) {
            image.setImageResource(R.drawable.a4);
            pprice = Integer.toString(z);
            delivery1.setText("Delivery Charge: ₹50");
            delivery2.setText("₹50");
            f_total_price.setText("₹" + pprice);
            pdelivery = "Delivery: ₹50";

        }
        else if(s.equals("5")) {
            image.setImageResource(R.drawable.a5);
            pprice = Integer.toString(z);
            delivery1.setText("Delivery Charge: ₹50");
            delivery2.setText("₹50");
            f_total_price.setText("₹" + pprice);
            pdelivery = "Delivery: ₹50";
        }
        else if(s.equals("6")) {
            image.setImageResource(R.drawable.a6);
            pprice = Integer.toString(z);
            delivery1.setText("Delivery Charge: ₹50");
            delivery2.setText("₹50");
            f_total_price.setText("₹" + pprice);
            pdelivery = "Delivery: ₹50";
        }
        else if(s.equals("7")) {
            image.setImageResource(R.drawable.a7);
        }
        else if(s.equals("8")) {
            image.setImageResource(R.drawable.a8);
            pprice = Integer.toString(z);
            delivery1.setText("Delivery Charge: ₹50");
            delivery2.setText("₹50");
            f_total_price.setText("₹" + pprice);
            pdelivery = "Delivery: ₹50";
        }

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                uname = snapshot.child(uid).child("userName").getValue(String.class);
                umobile = snapshot.child(uid).child("userMobileNumber").getValue(String.class);
                pid = snapshot.child(uid).child("count").getValue(String.class);

                c_name.setText(uname);
                c_mobile.setText(umobile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        brochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals("7") || s.equals("8")) {
                    Toast.makeText(CheckOut.this, "Brochure not found!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW) ;
                    i.setData(Uri.parse(bro)) ;
                    startActivity(i);
                }
            }
        });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paddress = c_address.getText().toString();

                UserProducts up = new UserProducts(pid,pname,poffer,pdelivery,ppayment,paddress,pprice,s);
                databaseReference.child(uid).child("products").child(pid).setValue(up);

                AdminProducts ap = new AdminProducts(uid,pid,s,uname,umobile,paddress,pname,pdelivery,ppayment,pprice);
                databaseReference.child("vfJHYhyUZWWumffrHZnOMkrHXDp2").child("products").child(uid).child(pid).setValue(ap);

                int x = Integer.parseInt(pid);
                x = x + 1;

                String z = Integer.toString(x);
                databaseReference.child(uid).child("count").setValue(z);

                Intent intent =new Intent(CheckOut.this,MainActivity.class);
                Toast.makeText(CheckOut.this, "Done!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(CheckOut.this, Product.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(CheckOut.this, Product.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}