package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void onButtonClickToast(View view) {

        Toast t=null;
        switch (view.getId()){
            case R.id.toastButton:
                t = Toast.makeText(this, "Message", Toast.LENGTH_SHORT);//simpel toast
                t.setGravity(Gravity.TOP,0,450);  //set gravity and X and Y corrdinate value from gravity
                t.show();
                break;

            case R.id.custonToastButton:
                t= new Toast(getApplicationContext());

                //changing xml layout to view
                LayoutInflater inflater = getLayoutInflater();
                View appear  = inflater.inflate(R.layout.custom_toast_layout,(ViewGroup)findViewById(R.id.toastLinearLayout)); //view group is the root layout,here its lenear layout

                t.setView(appear);
                t.show();

            default:
                break;

        }
    }
}