package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FacebookUIActivity extends AppCompatActivity {

    CheckBox saveLogin;
    ToggleButton toggleButton;
    RelativeLayout rL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_uiactivity);

        saveLogin = (CheckBox) findViewById(R.id.saveLoginCheckbox);
        toggleButton =  (ToggleButton) findViewById(R.id.toggleButton);
        rL = (RelativeLayout) findViewById(R.id.facebookUIRelativeLayout);


        saveLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cB =(CheckBox) v;
                Toast.makeText(FacebookUIActivity.this, String.valueOf(cB.isChecked()), Toast.LENGTH_SHORT).show();
            }
        });


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    rL.setBackgroundColor(Color.parseColor("#0A5FB3"));
                }else{
                    rL.setBackgroundColor(Color.BLACK);
                }
                Toast.makeText(FacebookUIActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }
        });



    }
}