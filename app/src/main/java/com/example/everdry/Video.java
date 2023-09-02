package com.example.everdry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    VideoView simpleVideoView;
    MediaController mediaControls;

    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().setTitle("Videos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        simpleVideoView = findViewById(R.id.video);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);

        Intent i = getIntent();
        String s = i.getStringExtra("video");
        String text1 = i.getStringExtra("text1");
        String text2 = i.getStringExtra("text2");
        String text3 = i.getStringExtra("text3");

        t1.setText(text1);
        t2.setText(text2);
        t3.setText(text3);

        if (mediaControls == null) {
            mediaControls = new MediaController(Video.this);
            mediaControls.setAnchorView(simpleVideoView);
        }

        simpleVideoView.setMediaController(mediaControls);

        if(s.equals("1")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices1));
        }
        else if(s.equals("2")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices2));
        }
        else if(s.equals("3")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices3));
        }
        else if(s.equals("4")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices4));
        }
        else if(s.equals("5")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices5));
        }
        else if(s.equals("6")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices6));
        }
        else if(s.equals("7")) {
            simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gaurinengineeringservices7));
        }


        simpleVideoView.start();

        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(Video.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Video.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}