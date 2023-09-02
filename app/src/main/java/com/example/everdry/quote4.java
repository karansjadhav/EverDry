package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class quote4 extends AppCompatActivity {

    String uname,umobile,uemail,uaddress,construction,part,coat,location,sqft,quality,total_cost,price_estimate;

    TextInputLayout area,address;
    Button generate_quote;

    Bitmap bmp, scaledbmp;
    Date dateObj;
    DateFormat dateFormat;

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://everdry-7777-default-rtdb.firebaseio.com");
    DatabaseReference databaseReference = firebaseDatabase.getReference("UsersInformation");
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote4);

        getSupportActionBar().setTitle("Quotation Generation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        area = findViewById(R.id.area);
        address = findViewById(R.id.address);
        generate_quote = findViewById(R.id.generate_quote);

        RadioGroup radioGroup = findViewById(R.id.rate);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                quality = rb.getText().toString();
            }
        });

        Intent i = getIntent();

        String count = i.getStringExtra("count");
        uname = i.getStringExtra("name");
        umobile = i.getStringExtra("mobile");
        uemail = i.getStringExtra("email");
        construction = i.getStringExtra("s1");
        part = i.getStringExtra("s2");
        coat = i.getStringExtra("s3");
        location = i.getStringExtra("s4");
        price_estimate = i.getStringExtra("price_estimate");

        generate_quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sqft = area.getEditText().getText().toString();
                int area = Integer.parseInt(sqft);

                int total = 0;
                if(quality.equals("Low (25)")) {
                    total = area*25;
                }
                else if(quality.equals("Mid (35)")) {
                    total = area*35;
                }
                else if(quality.equals("High (45)")) {
                    total = area*45;
                }

                total_cost = Integer.toString(total);
                uaddress = address.getEditText().getText().toString();

                if(!validateArea() | !validateAddress()) {
                    Toast.makeText(quote4.this, "Enter Details", Toast.LENGTH_SHORT).show();
                }
                else {

                    if(price_estimate.equals("0")) {
                        Quotation q = new Quotation(construction,part,coat,location,sqft,quality,uaddress,total_cost,count);
                        databaseReference.child(uid).child("quotations").child(count).setValue(q);

                        UsersQuotations u = new UsersQuotations(uid,count,uname,umobile,uemail,construction,part,coat,location,sqft,quality,uaddress,total_cost);
                        databaseReference.child("vfJHYhyUZWWumffrHZnOMkrHXDp2").child("quotations").child(uid).child(count).setValue(u);
                    }

                    x = Integer.parseInt(count);
                    x = x + 1;

                    String z = Integer.toString(x);
                    databaseReference.child(uid).child("count").setValue(z);

                    bmp = BitmapFactory.decodeResource(getResources(),R.drawable.design);
                    scaledbmp = Bitmap.createScaledBitmap(bmp,1200,518, false);

                    dateObj = new Date();

                    PdfDocument myPDFDocument = new PdfDocument();
                    Paint myPaint = new Paint();
                    Paint boldPaint = new Paint();

                    PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                    PdfDocument.Page myPage1 = myPDFDocument.startPage(myPageInfo1);
                    Canvas canvas = myPage1.getCanvas();

                    canvas.drawBitmap(scaledbmp, 0, 0, myPaint);

                    myPaint.setTextAlign(Paint.Align.LEFT);
                    myPaint.setTextSize(50f);
                    myPaint.setColor(Color.BLACK);

                    boldPaint.setTextAlign(Paint.Align.LEFT);
                    boldPaint.setTextSize(50f);
                    boldPaint.setColor(Color.BLACK);
                    boldPaint.setFakeBoldText(true);

                    canvas.drawText("Username :  " + uname, 20, 590, myPaint);
                    canvas.drawText("Phone Number :  " + umobile, 20, 660, myPaint);
                    canvas.drawText("Email :  " + uemail, 20, 730, myPaint);
                    canvas.drawText("Address :  " + uaddress, 20, 800, myPaint);
                    canvas.drawText("Quotation :  " + (x - 1), 20, 870, myPaint);
                    canvas.drawText("Construction :  " + construction, 20, 940, myPaint);
                    canvas.drawText("Part :  " + part, 20, 1010, myPaint);
                    canvas.drawText("Coating :  " + coat, 20, 1080, myPaint);
                    canvas.drawText("Area :  " + sqft + "sq.ft", 20, 1150, myPaint);
                    canvas.drawText("Location :  " + location, 20, 1220, myPaint);
                    canvas.drawText("Quality :  " + quality + "per sq.ft", 20, 1290, myPaint);
                    canvas.drawText("Total Cost :  " + total_cost, 20, 1460, boldPaint);

                    dateFormat = new SimpleDateFormat("dd/MM/yy");
                    canvas.drawText("Date:  " + dateFormat.format(dateObj), 830, 590, myPaint);
                    dateFormat = new SimpleDateFormat("HH:mm:ss");
                    canvas.drawText("Time:  " + dateFormat.format(dateObj), 850, 660, myPaint);


                    myPDFDocument.finishPage(myPage1);

                    int permission = ContextCompat.checkSelfPermission(quote4.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
                        }
                    }

                    String fullPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
                    //fullPath = String.valueOf(fromFile(new File(fullPath)));
                    try {
                        File dir = new File(fullPath);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        OutputStream fOut = null;
                        File file = new File(fullPath, "/" + uname + "_" + (x-1) + ".pdf");
                        if (file.exists())
                            file.delete();
                        boolean is_file = file.createNewFile();
                        if (is_file) {
                            Toast.makeText(getApplicationContext(), "Quotation Generated Successfully!", Toast.LENGTH_SHORT).show();

                        }
                        myPDFDocument.writeTo(new FileOutputStream(file));
                        //fOut = new FileOutputStream(file);
                        fOut.flush();
                        fOut.close();
                    } catch (Exception e) {
                        Log.e("saveToExternalStorage()", e.getMessage());
                    }

                    Intent intent =new Intent(quote4.this,MainActivity.class);
                    Toast.makeText(quote4.this,"Quotation Generated Successfully!",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void generatePDF() {


    }

    public void onBackPressed() {
        Intent intent = new Intent(quote4.this, quote3.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(quote4.this, quote3.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean validateArea() {;

        if (sqft.isEmpty()) {
            area.setError("Please enter Area");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {

        if (uaddress.isEmpty()) {
            address.setError("Please enter Address");
            return false;
        }
        return true;
    }
}