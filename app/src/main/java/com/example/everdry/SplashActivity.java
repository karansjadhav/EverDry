package com.example.everdry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation topanim,bottomanim;
    ImageView logo;
    TextView appname, waterproofing,comapny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo = findViewById(R.id.logo);
        appname = findViewById(R.id.appname);
        waterproofing = findViewById(R.id.waterproofing);
        comapny = findViewById(R.id.company);

        logo.setAnimation(topanim);
        appname.setAnimation(topanim);
        waterproofing.setAnimation(bottomanim);
        comapny.setAnimation(bottomanim);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}