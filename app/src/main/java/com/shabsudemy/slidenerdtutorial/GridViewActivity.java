package com.shabsudemy.slidenerdtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GridViewActivity extends AppCompatActivity implements MyAdapter.AdapterClickListner {

    GridView gridView;
    ArrayList<Country> countryList = new ArrayList<Country>();

    int[] images = {
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.gridView);
//        gridView.setOnItemClickListener(this);

        for (int i = 0; i < 100; i++) {
            String countryName = "country" + String.valueOf(i);
            int randomInt = new Random().nextInt(5);
            int imageValue = images[randomInt];
            countryList.add(new Country(countryName, imageValue));
        }

        MyAdapter myAdapter = new MyAdapter(this, countryList, this);
        gridView.setAdapter(myAdapter);
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        TextView textView = view.findViewById(R.id.gridViewTextView);
//        Toast.makeText(this, String.valueOf(textView.getText()), Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onClicked(String countryName, int imageId) {
        Toast.makeText(this, countryName, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, CustomDialogueActivity.class);
        i.putExtra("image", imageId);
        i.putExtra("countryName", countryName);
        startActivity(i);

    }
}


class MyAdapter extends BaseAdapter {

    interface AdapterClickListner {
        void onClicked(String countryName, int imageId);
    }


    ArrayList<Country> countryList;
    Context context;
    AdapterClickListner adapterClickListner;

    MyAdapter(Context context, ArrayList<Country> countryList, AdapterClickListner adapterClickListner) {
        this.countryList = countryList;
        this.context = context;
        this.adapterClickListner = adapterClickListner;
    }


    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_grid_item, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.imageView.setImageResource(countryList.get(position).imageId);
        holder.textView.setText(countryList.get(position).countryName);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterClickListner.onClicked(countryList.get(position).countryName, countryList.get(position).imageId);
            }
        });

        return row;
    }

}

class ViewHolder {
    ImageView imageView;
    TextView textView;

    ViewHolder(View v) {
        this.imageView = v.findViewById(R.id.gridViewImage);
        this.textView = v.findViewById(R.id.gridViewTextView);
    }
}


class Country {
    String countryName;
    int imageId;

    Country(String countryName, int imageId) {
        this.countryName = countryName;
        this.imageId = imageId;
    }
}
