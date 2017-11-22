package com.example.hyeseong.homework1;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class RestaurantDetailActivity extends AppCompatActivity {
    static MyAdapter adapter;

    private DBHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        mDbHelper = new DBHelper(this);

        getRestaruntInformation();


        ImageButton btn = (ImageButton) findViewById(R.id.iconItem2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicit_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:027604499"));
                startActivity(implicit_intent);
            }
        });

        //어댑터 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {

                int icon = ((MyItem)adapter.getItem(position)).menuIcon;
                String name = ((MyItem)adapter.getItem(position)).menuName;
                String price = ((MyItem)adapter.getItem(position)).menuPrice;
                String grade = ((MyItem)adapter.getItem(position)).menuGrade;

                Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);

                intent.putExtra("MenuIcon", icon);
                intent.putExtra("MenuName", name);
                intent.putExtra("MenuPrice", price);
                intent.putExtra("MenuGrade", grade);

                startActivity(intent);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.plus:
                startActivity(new Intent(this, MenuRegistrationActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    RestaurantRegistrationActivity RR;
    private void getRestaruntInformation() {

        TextView name = (TextView) findViewById(R.id.name);
        TextView address = (TextView) findViewById(R.id.address);
        TextView phone = (TextView) findViewById(R.id.phone);

        Cursor cursor = mDbHelper.getAllUsersBySQL();

        StringBuffer namebuffer = new StringBuffer();
        StringBuffer addressbuffer = new StringBuffer();
        StringBuffer phonebuffer = new StringBuffer();

        while (cursor.moveToNext()) {
            namebuffer.setLength(0);
            addressbuffer.setLength(0);
            phonebuffer.setLength(0);
            namebuffer.append(cursor.getString(1) + "\t");
            addressbuffer.append(cursor.getString(2) + "\t");
            phonebuffer.append(cursor.getString(3) + "\n");
        }
        name.setText(namebuffer);
        address.setText(addressbuffer);
        phone.setText(phonebuffer);

        ImageView imageView = (ImageView) findViewById(R.id.picture);

        imageView.setImageURI(RR.image_Uri);
    }



}



