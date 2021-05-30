package com.shabsudemy.slidenerdtutorial;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CustomDialogueActivity  extends Activity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialogue_activity);

        imageView = (ImageView) findViewById(R.id.dialogImageView);
        textView = (TextView) findViewById(R.id.dialogTextView);

        Intent i =getIntent();
        int imageId = i.getExtras().getInt("image",0);
        String countryName = i.getStringExtra("countryName");

        imageView.setImageResource(imageId);
        textView.setText(countryName);


    }

    public void dialogueClose(View view) {
        finish();
    }
}
