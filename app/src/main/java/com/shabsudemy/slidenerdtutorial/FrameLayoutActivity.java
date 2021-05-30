package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {

    ImageView pinky,ponkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        pinky =  (ImageView) findViewById(R.id.pinkeyImageView);
        ponkey = (ImageView) findViewById(R.id.ponkeyImageView);


        pinky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ponkey.setVisibility(View.VISIBLE);
                pinky.setVisibility(View.INVISIBLE);
            }
        });

        ponkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinky.setVisibility(View.VISIBLE);
                ponkey.setVisibility(View.INVISIBLE);
            }
        });


    }
}