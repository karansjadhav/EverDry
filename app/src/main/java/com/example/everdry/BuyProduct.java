package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyProduct extends AppCompatActivity {

    ImageView product_image;
    TextView product_name,product_offer1,product_offer2,product_price,free_delivery,delivery_charges;
    Button brochure,buy_now;

    String[] name = {"Zoriscott (20 Litre)" , "ScottProof 200 (5 Litre)" , "Tank Seal (15KG)" , "Mix-N-Fix (5KG)" , "KrackSeal (500gm)" , "EWC (1KG)" , "SuperFlash Strip" , "Brush 4'"};
    String[] offer = {"30% off" , "25% off" , "15% off" , "40% off" , "20% off" , "30% off" , "15% off" , "20% off"};
    String[] offer_price = {"7̶2̶5̶8̶" , "9̶6̶1̶" , "3̶0̶4̶3̶" , "3̶5̶0̶" , "2̶0̶9̶" , "4̶1̶9̶" , "2̶1̶0̶0̶" , "2̶3̶2̶"};
    String[] offer_price2 = {"7,258" , "961" , "3,043" , "350" , "209" , "419" , "2,100" , "232"};
    String[] price = {"5080" , "720" , "2586" , "210" , "167" , "293" , "1785" , "185"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product_image = findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_offer1 = findViewById(R.id.product_offer1);
        product_offer2 = findViewById(R.id.product_offer2);
        product_price = findViewById(R.id.product_price);

        free_delivery = findViewById(R.id.free_delivery);
        delivery_charges = findViewById(R.id.delivery_charge);

        brochure = findViewById(R.id.brochure);
        buy_now = findViewById(R.id.buy_now);


        Intent i = getIntent();
        String s = i.getStringExtra("product");
        String bro = i.getStringExtra("brochure");

        if(s.equals("1")) {
            product_image.setImageResource(R.drawable.a1);
            product_name.setText(name[0]);
            product_offer1.setText(offer[0]);
            product_offer2.setText(offer_price[0]);
            product_price.setText("₹" + price[0]);
        }
        else if(s.equals("2")) {
            product_image.setImageResource(R.drawable.a2);
            product_name.setText(name[1]);
            product_offer1.setText(offer[1]);
            product_offer2.setText(offer_price[1]);
            product_price.setText("₹" + price[1]);
            free_delivery.setText("Delivery Charge:");
            delivery_charges.setText("₹ 50");
        }
        else if(s.equals("3")) {
            product_image.setImageResource(R.drawable.a3);
            product_name.setText(name[2]);
            product_offer1.setText(offer[2]);
            product_offer2.setText(offer_price[2]);
            product_price.setText("₹" + price[2]);
        }
        else if(s.equals("4")) {
            product_image.setImageResource(R.drawable.a4);
            product_name.setText(name[3]);
            product_offer1.setText(offer[3]);
            product_offer2.setText(offer_price[3]);
            product_price.setText("₹" + price[3]);
            free_delivery.setText("Delivery Charge:");
            delivery_charges.setText("₹ 50");
        }
        else if(s.equals("5")) {
            product_image.setImageResource(R.drawable.a5);
            product_name.setText(name[4]);
            product_offer1.setText(offer[4]);
            product_offer2.setText(offer_price[4]);
            product_price.setText("₹" + price[4]);
            free_delivery.setText("Delivery Charge:");
            delivery_charges.setText("₹ 50");
        }
        else if(s.equals("6")) {
            product_image.setImageResource(R.drawable.a6);
            product_name.setText(name[5]);
            product_offer1.setText(offer[5]);
            product_offer2.setText(offer_price[5]);
            product_price.setText("₹" + price[5]);
            free_delivery.setText("Delivery Charge:");
            delivery_charges.setText("₹ 50");
        }
        else if(s.equals("7")) {
            product_image.setImageResource(R.drawable.a7);
            product_name.setText(name[6]);
            product_offer1.setText(offer[6]);
            product_offer2.setText(offer_price[6]);
            product_price.setText("₹" + price[6]);
        }
        else if(s.equals("8")) {
            product_image.setImageResource(R.drawable.a8);
            product_name.setText(name[7]);
            product_offer1.setText(offer[7]);
            product_offer2.setText(offer_price[7]);
            product_price.setText("₹" + price[7]);
            free_delivery.setText("Delivery Charge:");
            delivery_charges.setText("₹ 50");
        }

        brochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.equals("7") || s.equals("8")) {
                    Toast.makeText(BuyProduct.this, "Brochure not found!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW) ;
                    i.setData(Uri.parse(bro)) ;
                    startActivity(i);
                }
            }
        });

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyProduct.this,CheckOut.class);
                intent.putExtra("image",s);
                int x = Integer.parseInt(s);
                x = x - 1;
                intent.putExtra("product",name[x]);
                intent.putExtra("dis1",offer[x]);
                intent.putExtra("dis2",offer_price[x]);
                intent.putExtra("dis3",offer_price2[x]);
                intent.putExtra("price",price[x]);
                intent.putExtra("brochure",bro);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(BuyProduct.this, Product.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(BuyProduct.this, Product.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}