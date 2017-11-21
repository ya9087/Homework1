package com.example.hyeseong.homework1;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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

        // 데이터 원본 준비
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.s1, "냉모밀", "3000", "3.4"));
        data.add(new MyItem(R.drawable.s2, "치즈라면", "2500", "4.0"));
        data.add(new MyItem(R.drawable.s3, "간장돼불 덮밥", "3500", "4.2"));
        data.add(new MyItem(R.drawable.s4, "육회비빔밥", "4500", "4.5"));
        data.add(new MyItem(R.drawable.s5, "치즈불닭비빔밥", "4000", "3.9"));

        //어댑터 생성
        adapter = new MyAdapter(this, R.layout.item, data);

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

    private void getRestaruntInformation() {
        Cursor cursor = mDbHelper.getAllUsersByMethod();

        TextView name = (TextView) findViewById(R.id.name);
        TextView address = (TextView) findViewById(R.id.address);
        TextView phone = (TextView) findViewById(R.id.phone);

        name.setText(cursor.getString(1));
        address.setText(cursor.getString(2));
        phone.setText(cursor.getString(3));
    }

}

