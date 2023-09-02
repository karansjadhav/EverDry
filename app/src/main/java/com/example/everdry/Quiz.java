package com.example.everdry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz extends AppCompatActivity {

    int yes = 0;
    int no = 0;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RadioGroup a1 = findViewById(R.id.a1);
        a1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a2 = findViewById(R.id.a2);
        a2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a3 = findViewById(R.id.a3);
        a3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a4 = findViewById(R.id.a4);
        a4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a5 = findViewById(R.id.a5);
        a5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a6 = findViewById(R.id.a6);
        a6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a7 = findViewById(R.id.a7);
        a7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a8 = findViewById(R.id.a8);
        a8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a9 = findViewById(R.id.a9);
        a9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });

        RadioGroup a10 = findViewById(R.id.a10);
        a10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                String s = rb.getText().toString();
                if(s.equals("Yes")) {
                    yes++;
                }
                else if(s.equals("no")){
                    no++;
                }
            }
        });


        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Quiz.this);

                builder.setTitle("Your Score is " + yes*10);

                if(yes>=5) {
                    builder.setMessage("Your house need Waterproofing!");
                }
                else if(yes==0) {
                    builder.setMessage("Your house does not need Waterproofing!");
                }
                else if(yes<5) {
                    builder.setMessage("Your house might need Waterproofing!");
                }


                builder.setCancelable(false);

                builder.setPositiveButton("Generate Quotation", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Intent i = new Intent(Quiz.this,quote1.class);
                    startActivity(i);
                    finish();
                });

                builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Intent intent = new Intent(Quiz.this, MainActivity.class);
                    startActivity(intent);
                    dialog.cancel();
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(Quiz.this, MainActivity.class);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Quiz.this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}