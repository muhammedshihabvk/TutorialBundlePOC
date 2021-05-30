package com.shabsudemy.slidenerdtutorial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class GeneralWidgetsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    File image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_widgets);

        ArrayList arrayList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("Item-" + String.valueOf(i));
        }

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        Context context;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        spinner.setAdapter(arrayAdapter);

//
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        image = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
//        Uri tempuru = Uri.fromFile(image);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,tempuru);
//        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
//        startActivityForResult(intent,0);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==0){
//            switch (resultCode){
//                case Activity.RESULT_OK:
//                    if(image.exists()){
//                        Toast.makeText(this, "Image saved"+image.getAbsolutePath(), Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(this, "Imagenot save Error", Toast.LENGTH_SHORT).show();
//                    }
//
//                    break;
//                case Activity.RESULT_CANCELED:
//                        break;
//
//            }
//        }


//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Toast.makeText(this, String.valueOf(textView.getText()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show();

    }
}