package com.example.hyeseong.homework1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    final static String TAG = "SQLiteDBTest";

    public DBHelper(Context context) {
        super(context, RestaurantInformation.DB_NAME, null, RestaurantInformation.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, getClass().getName() + ".onCreate()");
        db.execSQL(RestaurantInformation.Restaurants.CREATE_TABLE);
        db.execSQL(RestaurantInformation.Menu.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG, getClass().getName() + ".onUpgrade()");
        db.execSQL(RestaurantInformation.Restaurants.DELETE_TABLE);
        db.execSQL(RestaurantInformation.Menu.DELETE_TABLE);
        onCreate(db);
    }

    public long insertUserByMethod(String name, String address, String phone, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RestaurantInformation.Restaurants.KEY_NAME, name);
        values.put(RestaurantInformation.Restaurants.KEY_ADDRESS, address);
        values.put(RestaurantInformation.Restaurants.KEY_PHONE, phone);
        values.put(RestaurantInformation.Restaurants.KEY_IMAGE, image);

        return db.insert(RestaurantInformation.Restaurants.TABLE_NAME, null, values);
    }

    public long insertMenuByMethod(String name, String price, String explanation, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RestaurantInformation.Menu.KEY_NAME, name);
        values.put(RestaurantInformation.Menu.KEY_Price, price);
        values.put(RestaurantInformation.Menu.KEY_Explanation, explanation);
        values.put(RestaurantInformation.Restaurants.KEY_IMAGE, image);

        return db.insert(RestaurantInformation.Menu.TABLE_NAME, null, values);
    }

    public Cursor getAllUsersBySQL() {
        String sql = "Select * FROM " + RestaurantInformation.Restaurants.TABLE_NAME;
        return getReadableDatabase().rawQuery(sql, null);
    }

    public Cursor getAllMenusBySQL() {
        String sql = "Select * FROM " + RestaurantInformation.Menu.TABLE_NAME;
        return getReadableDatabase().rawQuery(sql, null);
    }
}
