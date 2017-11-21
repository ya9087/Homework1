package com.example.hyeseong.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuDetailActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp);
            if (drawable != null) {
                drawable.setTint(Color.WHITE);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        Intent intent = getIntent();

        ImageView imageView = (ImageView)findViewById(R.id.micon);
        imageView.setImageResource(intent.getIntExtra("MenuIcon", 1));
        TextView textView1 = (TextView)findViewById(R.id.mname);
        textView1.setText(intent.getStringExtra("MenuName"));
        TextView textView2 = (TextView)findViewById(R.id.mprice);
        textView2.setText(intent.getStringExtra("MenuPrice") + " 원");
        TextView textView3 = (TextView)findViewById(R.id.mgrade);
        textView3.setText("평점 : " + intent.getStringExtra("MenuGrade"));
    }
}
