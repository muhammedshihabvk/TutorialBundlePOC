package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;

public class IntentPOCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_pocactivity);
    }

    public void onButtonClickIntent(View view) {
        Intent intent = null,chooser=null;
        switch (view.getId()){
            case R.id.launchMap:
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:19.076,72.8777"));
                chooser = Intent.createChooser(intent,"Launch Map");
                startActivity(chooser);
                break;
            case R.id.launchMarket:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
                chooser = Intent.createChooser(intent,"Launch Market");
                startActivity(chooser);
                break;
            case R.id.sendEmail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to = {"shihabvk99@gmail.com","muhammed.shihab@litmus7.con"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"System is on High performance");
                intent.putExtra(Intent.EXTRA_TEXT,"Show me more performance on laptop");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent,"Send email");
                startActivity(chooser);
                break;
            case R.id.sendImage:
                Uri imageUri = Uri.parse("android.resource://shabsudemy.slidenerdtutorial/drawable/"+R.drawable.ic_launcher_background);
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM,imageUri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hey i have some data to feed you");
                chooser = Intent.createChooser(intent,"Send Image");
                startActivity(chooser);
                break;

//            case R.id.sendImageExternal:
//                File picture = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//                String[] listOfPictures = picture.list();
//                if(listOfPictures!=null){
//                    Log.i("shabs",listOfPictures.toString());
//                }else{
//                    Log.i("shabs","Null List ");
//                }
//                break;
            default:
                break;


        }

    }
}