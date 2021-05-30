package com.shabsudemy.slidenerdtutorial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdapterPocActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView sampleListview;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> subtitles = new ArrayList<String>();
    int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_poc);

        sampleListview = (ListView) findViewById(R.id.sampleListview);
        sampleListview.setOnItemClickListener(this);

        for (int i = 0; i < 100; i++) {
            names.add("Name-" + String.valueOf(i));
        }
        for (int i = 0; i < 100; i++) {
            subtitles.add("Sub Titles-" + String.valueOf(i));
        }


        //single item example
//        data.add("hello");
//        data.add("man");
//        data.add("got it");
//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.custom_row_layout,R.id.textView ,data);
//        sampleListview.setAdapter(arrayAdapter);

        CustomAdapter customAdapter = new CustomAdapter(this, names, subtitles, images);
        sampleListview.setAdapter(customAdapter);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}


class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> names;
    ArrayList<String> subtitles;
    int[] images;

    public CustomAdapter(@NonNull Context context, ArrayList<String> name, ArrayList<String> subtitles, int[] images) {
        super(context, R.layout.custom_row_layout, R.id.textView, name);
        this.context = context;
        this.names = name;
        this.images = images;
        this.subtitles = subtitles;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        MyViewHolder myViewHolder = null;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row_layout, parent, false);
            myViewHolder = new MyViewHolder(row);
            row.setTag(myViewHolder);
            Log.i("shabs", "creating new row");
        } else {
            myViewHolder = (MyViewHolder) row.getTag();
            Log.i("shabs", "recycling stuff");
        }

        int imageValue = 0;
        try {
            imageValue = Integer.parseInt(String.valueOf(images[position]));
        } catch (Exception e) {
            int randomInt = new Random().nextInt(5);
            imageValue = images[randomInt];
            Log.e("shabs", "null image invoked");
        }

        myViewHolder.myImage.setImageResource(imageValue);
        myViewHolder.myTitle.setText(names.get(position));
        myViewHolder.mySubtitle.setText(subtitles.get(position));

        return row;
    }

    @Override
    public int getCount() {
        return names.size();
    }
}

class MyViewHolder {
    ImageView myImage;
    TextView myTitle, mySubtitle;

    MyViewHolder(View view) {
        myImage = (ImageView) view.findViewById(R.id.imageView);
        myTitle = (TextView) view.findViewById(R.id.textView);
        mySubtitle = (TextView) view.findViewById(R.id.subTitle);
    }
}