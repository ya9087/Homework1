package com.example.hyeseong.homework1;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuDetailActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private DBHelper mDbHelper;
    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        mDbHelper = new DBHelper(this);


        Intent intent = getIntent();

        ImageView imageView = (ImageView)findViewById(R.id.micon);
        imageView.setImageResource(intent.getIntExtra("MenuIcon", 1));
        TextView textView1 = (TextView)findViewById(R.id.mname);
        textView1.setText(intent.getStringExtra("MenuName"));
        TextView textView2 = (TextView)findViewById(R.id.mprice);
        textView2.setText(intent.getStringExtra("MenuPrice") + " 원");
        TextView textView3 = (TextView)findViewById(R.id.mgrade);
        textView3.setText("설명 : " + intent.getStringExtra("MenuGrade"));
    }


}

