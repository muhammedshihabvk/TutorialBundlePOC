package com.shabsudemy.slidenerdtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.FrameLayout;

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
            case R.id.facebookUIActivity:
                i = new Intent(this, FacebookUIActivity.class);
                startActivity(i);
                break;

            case R.id.frameLayoutActivity:
                i=new Intent(this, FrameLayoutActivity.class);
                startActivity(i);
                break;

            case R.id.arrayAdapterPocActivity:
                i = new Intent(this,AdapterPocActivity.class);
                startActivity(i);
                break;

            case R.id.baseAdapterPocActivity:
                i = new Intent(this,BaseAdapterActivity.class);
                startActivity(i);
                break;

            case  R.id.gridViewActivity:
                i=new Intent(this,GridViewActivity.class);
                startActivity(i);
                break;
            case  R.id.generalWidgets:
                i=new Intent(this,GeneralWidgetsActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}