package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BaseAdapterActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<SingleRow> dataObject = new ArrayList<SingleRow>();

    int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        for (int i = 0; i < 100; i++) {
            String n = "Name-" + String.valueOf(i);
            String s = "Sub Titles-" + String.valueOf(i);
            int randomInt = new Random().nextInt(5);
            int imageValue = images[randomInt];
            dataObject.add(new SingleRow(n,s,imageValue));
        }

        MyCustomBaseAdapter myCustomBaseAdapter = new MyCustomBaseAdapter(this,dataObject);

        listView = (ListView) findViewById(R.id.baseAdapterListView);
        listView.setAdapter(myCustomBaseAdapter);
    }
}


class MyCustomBaseAdapter extends BaseAdapter {

    ArrayList<SingleRow> data;
    Context context;

    MyCustomBaseAdapter( Context context,ArrayList<SingleRow> incomingData) {
        this.data=incomingData;
        this.context=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_row_layout_base_adapter,parent,false);
        }

        TextView textView1 = row.findViewById(R.id.baseAdapterRowtextView1);
        TextView textView2 = row.findViewById(R.id.baseAdapterRowtextView2);
        ImageView imageView = row.findViewById(R.id.baseAdapterRowImageView);

        SingleRow sR = data.get(position);

        textView1.setText(sR.name);
        textView2.setText(sR.subTitle);
        imageView.setImageResource(sR.image);

        return row;
    }
}

class SingleRow {
    String name;
    String subTitle;
    int image;
    SingleRow() {

    }
    SingleRow(String name, String subTitle, int image) {
        this.image = image;
        this.name = name;
        this.subTitle = subTitle;
    }
}