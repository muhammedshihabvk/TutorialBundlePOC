package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ManualLayoutGenerationActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        linearLayout = new LinearLayout(this);
        textView = new TextView(this);
        button = new Button(this);

        LinearLayout.LayoutParams dimensions = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(dimensions);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        textView.setText("Hello shihab");
        button.setText("Click");

        linearLayout.addView(textView);
        linearLayout.addView(button);

        setContentView(linearLayout);
    }
}