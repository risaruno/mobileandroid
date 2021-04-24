package com.example.term;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.OptionalDataException;
import java.lang.reflect.Array;

public class FullScreenActifity extends AppCompatActivity
implements View.OnClickListener{

    ImageView imageView,prev,next;
    ImageAdapter imageAdapter = new ImageAdapter(this);
    static int pos,len;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("FullScreen Image");

        imageView = (ImageView)findViewById(R.id.image);
        prev = (ImageView)findViewById(R.id.prev);
        next = (ImageView)findViewById(R.id.next);
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        int length = (imageAdapter.getCount())-1;
        showImage(position, length);

        prev.setImageResource(R.drawable.prev);
        prev.setOnClickListener(this);
        next.setImageResource(R.drawable.next);
        next.setOnClickListener(this);

    }

    public void showImage(int position, int length){
        pos = position;
        len = length;
        imageView.setImageResource(imageAdapter.imageArray[pos]);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.prev:
                if(pos>0){
                    pos-=1;
                }
                showImage(pos,len);
                Toast.makeText(getApplicationContext(), pos+" of "+len+" Image(s)", Toast.LENGTH_SHORT).show();
                break;
            case R.id.next:
                if(pos<len){
                    pos+=1;
                }
                showImage(pos,len);
                Toast.makeText(getApplicationContext(), pos+" of "+len+" Image(s)", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
