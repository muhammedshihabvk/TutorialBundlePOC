package com.shabsudemy.slidenerdtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.intentPOC:
                i = new Intent(this, IntentPOCActivity.class);
                startActivity(i);
                break;
            case R.id.toastPOC:
                i = new Intent(this, ToastActivity.class);
                startActivity(i);
                break;
            case R.id.manuallLayoutGenration:
                i = new Intent(this, ManualLayoutGenerationActivity.class);
                startActivity(i);
                break;
            case R.id.calculatorActivity:
                i = new Intent(this, CalculatorActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}